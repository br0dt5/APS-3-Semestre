package jogo;

import jogo.Modelo.Game;

import javax.swing.JFrame;
import java.awt.*;

public class Janela extends JFrame{
    //construtor
    public Janela(){
        Game game = new Game();
        add(game);
        setTitle("APS");
        setSize(new Dimension(853, 480));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        game.startGame();
    }

    //main
    public static void main(String[] args) {
        new Janela();
    }
}
