package com.fatemehmohammadi;

import java.util.Random;

//face
public class Castle extends MoveChessman {

    @Override
    public void move() {
        Random rnd = new Random();

        int steps = rnd.nextInt(8) + 1;
        int direction = rnd.nextInt(4);


        switch (direction) {
            case 0:
                posY += steps;
                break;
            case 1:
                posY -= steps;
                break;
            case 2:
                posX -= steps;
                break;
            case 3:
                posX += steps;
                break;
            default:
                break;
        }


    }

    public Castle(int posX, int posY) {
        super(posX, posY);
    }
}
