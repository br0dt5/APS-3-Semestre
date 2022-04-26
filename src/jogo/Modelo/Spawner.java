package jogo.Modelo;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Spawner {
    private int timer;
    private ArrayList<Entulho> entulhos = new ArrayList<>();
    public Random random = new Random();

    public void spawn(Dimension area) {
        timer ++;
        int spawn_time = (random.nextInt(3)+1)*60;

        if (timer % spawn_time == 0) {
            entulhos.add(new Entulho());
            timer = 0;
        }
    }

    public void update(Player player, Game game) {
        for (Entulho entulho : entulhos) {
            entulho.update();
        }

        for (int i = 0; i < entulhos.size(); i++) {
            Entulho e = entulhos.get(i);
            if (player.getBounds().intersects(e.getBounds())) {
                entulhos.remove(e);
                game.aumentaPontuacao();
            }

            if (e.getX() < 0) {
                entulhos.remove(e);
                game.perdeVida();
            }
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < entulhos.size(); i++) {
            entulhos.get(i).render(g);
        }
    }
}
