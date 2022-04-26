package jogo.Modelo;

import java.awt.*;
import java.util.Random;

import javax.swing.ImageIcon;

public class Entulho {
    //atributos
    private Image imagem;
    private int x, y, width, height;
    private static int VELOCIDADE;  //velocidade dos obstaculos
    public Random random = new Random();

    //construto
    public Entulho(){
        load();
        x = 853;
        y = random.nextInt(240-60)+240;
    }

    //metodos
    public void load(){
        imagem = new ImageIcon("res\\Entulho" + (random.nextInt(3)+1) + ".png").getImage();
        width = imagem.getWidth(null); height = imagem.getHeight(null);
    }

    public void update(){
        VELOCIDADE = random.nextInt(5)+3;
        x -= VELOCIDADE;
    }

    public void render(Graphics g){
        g.drawImage(imagem, x, y-height, null);
    }

    public int getX(){
        return x;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
