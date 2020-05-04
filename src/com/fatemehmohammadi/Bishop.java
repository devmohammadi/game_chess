package com.fatemehmohammadi;

import java.util.Random;

//elephant
public class Bishop extends MoveChessman {

    @Override
    public void move() {
        Random rnd = new Random();
        int steps = rnd.nextInt(7) + 1;
        int direction = rnd.nextInt(4);

        switch (direction) {
            case 0:
                posY += steps;
                posX += steps;
                break;
            case 1:
                posY -= steps;
                posX += steps;
                break;
            case 2:
                posY -= steps;
                posX -= steps;
                break;
            case 3:
                posY += steps;
                posX -= steps;
                break;
            default:
                break;
        }
    }

    public Bishop(int posX, int posY) {
        super(posX, posY);
    }
}
