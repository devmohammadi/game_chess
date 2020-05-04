package com.fatemehmohammadi;

public abstract class MoveChessman {

    int posX;
    int posY;
    boolean isAvailable = true;

    public MoveChessman(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public abstract void move();

    public boolean isvalid() {
        if (posX > 8 || posY > 8 || posX < 1 || posY < 1) {
            return false;
        } else {
            return true;
        }
    }

    public void safeMove() {
        int tempX = this.posX;
        int tempY = this.posY;

        move();

        while(true){

            if (!isvalid()) {

                posX = tempX;
                posY = tempY;

                move();

            } else {
                break;
            }
        }

    }

}
