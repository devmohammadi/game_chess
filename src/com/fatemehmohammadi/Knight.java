package com.fatemehmohammadi;

import java.util.Random;

//horse
public class Knight extends MoveChessman {

    @Override
    public void move() {
        Random rnd = new Random();
        int direction = rnd.nextInt(8);

        switch (direction) {
            case 0:
                posY += 2;
                posX += 1;
                break;
            case 1:
                posY += 2;
                posX -= 1;
                break;
            case 2:
                posY += 1;
                posX += 2;
                break;
            case 3:
                posY += 1;
                posX -= 2;
                break;
            case 4:
                posY -= 2;
                posX -= 1;
                break;
            case 5:
                posY -= 2;
                posX += 1;
                break;
            case 6:
                posY -= 1;
                posX -= 2;
                break;
            case 7:
                posY -= 1;
                posX += 2;
                break;
            default:
                break;
        }
    }

    public Knight(int posX, int posY) {
        super(posX, posY);
    }
}
