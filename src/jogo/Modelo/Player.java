package jogo.Modelo;

import java.awt.*;
import javax.swing.ImageIcon;

public class Player {
    //atributos
    private int x, y;
    private Image imagem;
    private int width, height;
    private final int floorLimit = 395, weight = 1;
    private int jumpStrength = 0;

    //construtor
    public Player(){
        load();
        x = 100;
        y = floorLimit;
    }

    public void load(){
        imagem = new ImageIcon("res\\Player5.png").getImage();
        width = 70;
        height = 70;
    }

    public void render(Graphics g) {
        g.drawImage(imagem, x, y-35, width, height, null);
    }

    public void update(){
        y += jumpStrength;
        jumpStrength += weight;
        if (y > floorLimit) y = floorLimit;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 70, 70);
    }

    public void jump() {
        jumpStrength = -18;
    }
}
