package jogo.Modelo;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Cenario {
    //atributos
    private int width, height;
    private Image imagem;

    //construtor(es)
    public Cenario(){
        load();
    }

    //metodos
    public void load(){
        imagem = new ImageIcon("res\\Background.png").getImage();
        width = imagem.getWidth(null); height = imagem.getHeight(null);
    }

    //metodos get
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Image getImagem(){
        return imagem;
    }
}
