package com.fatemehmohammadi;

import java.util.Random;

//soldier
public class Pawn extends MoveChessman {
    @Override
    public void move() {
        Random rnd = new Random();
        if (posY == 2) {
            int step = rnd.nextInt(2) + 1;// if pawn's position is in y = 2, then 1 or 2 moves
            this.posY += step;
        } else if (posY == 8){
            this.posY += 0;
        } else {
            this.posY += 1;
        }
    }

    public Pawn(int posX, int posY) {
        super(posX, posY);
    }
}
