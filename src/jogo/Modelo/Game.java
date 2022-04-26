package jogo.Modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel implements Runnable, KeyListener {
    //atributos
    private int width, height;
    private Player player;
    private Cenario cenario;
    private Spawner spawner;
    private Thread thread;
    private boolean gameover = false;
    private int pontuacao = 0, vidas = 3;

    //construtor(es)
    public Game(){
        player = new Player();
        spawner = new Spawner();
        cenario = new Cenario();

        width = cenario.getWidth();
        height = cenario.getHeight();

        //melhoria de desempenho
        setFocusable(true);
        setDoubleBuffered(true);

        setPreferredSize(new Dimension(width, height));

        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(cenario.getImagem(), 0, 0, cenario.getWidth(), cenario.getHeight(),this);
        player.render(g);
        spawner.render(g);

        // Vidas
        g.setColor(Color.WHITE);
        g.fillRect(50, 30, 100, 20);
        g.setColor(Color.BLACK);
        g.drawRect(50, 30, 100, 20);
        g.drawString("Vidas", 55, 45);
        g.setColor(Color.YELLOW);
        g.fillRect(50, 51, 100, 30);
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(vidas), 55, 70);

        // Pontuação
        g.setColor(Color.WHITE);
        g.fillRect(650, 30, 100, 20);
        g.setColor(Color.BLACK);
        g.drawRect(650, 30, 100, 20);
        g.drawString("Pontuação", 655, 45);
        g.setColor(Color.CYAN);
        g.fillRect(650, 51, 100, 30);
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(pontuacao), 655, 70);
    }

    public void render() {
        if (!gameover){
            repaint();
        } else {
            Graphics g = this.getGraphics();
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 25));
            g.drawString("Game Over!", width/2-80, height/2 - 30);
            g.drawString("Sua pontuação: " + pontuacao, width/2 - 110, height/2 + 30);
        }
    }

    public void update() {
        spawner.spawn(this.getPreferredSize());
        spawner.update(player, this);
        player.update();
    }

    public void startGame() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    public void aumentaPontuacao() {
        pontuacao++;
    }

    public void perdeVida() {
        vidas--;
        if (vidas == 0) gameover = true;
    }

    @Override
    public void run() {
        while (true) {
            update();
            render();
            try { Thread.sleep(1000/60); }
            catch (InterruptedException e) { e.printStackTrace(); }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int codigo = e.getKeyCode();
        if (codigo == KeyEvent.VK_SPACE) { player.jump();}
    }

    @Override
    public void keyTyped(KeyEvent e) { }
    @Override
    public void keyReleased(KeyEvent e) { }
}
