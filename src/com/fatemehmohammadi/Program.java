package com.fatemehmohammadi;

import java.util.Random;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        int sleep = 1000;
        int[] location = new int[64];
        Random rnd = new Random();
        Scanner scan = new Scanner(System.in);

        FileManager fileManager = new FileManager();
        fileManager.createfile("pawn.txt");
        fileManager.createfile("bishop.txt");
        fileManager.createfile("castle.txt");
        fileManager.createfile("knight.txt");
        fileManager.createfile("movements.txt");

        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("First Location");


        //The first location of any chess should not be equal
        //soldier
        Pawn p = new Pawn(rnd.nextInt(8) + 1, rnd.nextInt(8) + 1);
        while(true){
            if ((location[(p.getPosY() - 1) * 8 + p.getPosX() - 1] == 0)) {
                location[(p.getPosY() - 1) * 8 + p.getPosX() - 1] = (p.getPosY() - 1) * 8 + p.getPosX() - 1;
                break;
            } else {
                p = new Pawn(rnd.nextInt(8) + 1, rnd.nextInt(8) + 1);
            }
        }

        System.out.print("Pawn is:(" + p.getPosX() + ":" + p.getPosY() + ")     ");
        fileManager.writer("pawn.txt", p.getPosX() + ":" + p.getPosY());



        // elephant
        Bishop b = new Bishop(rnd.nextInt(8) + 1, rnd.nextInt(8) + 1);
        while(true){
            if ((location[(b.getPosY() - 1) * 8 + b.getPosX() - 1] == 0)) {
                location[(b.getPosY() - 1) * 8 + b.getPosX() - 1] = (b.getPosY() - 1) * 8 + b.getPosX() - 1;
                break;
            } else {
                b = new Bishop(rnd.nextInt(8) + 1, rnd.nextInt(8) + 1);
            }
        }

        System.out.print("Bishop is:(" + b.getPosX() + ":" + b.getPosY() + ")     ");
        fileManager.writer("Bishop.txt", b.getPosX() + ":" + b.getPosY());



        // face
        Castle c = new Castle(rnd.nextInt(8) + 1, rnd.nextInt(8) + 1);
        while(true){

            if ((location[(c.getPosY() - 1) * 8 + c.getPosX() - 1] == 0)) {
                location[(c.getPosY() - 1) * 8 + c.getPosX() - 1] = (c.getPosY() - 1) * 8 + c.getPosX() - 1;
                break;
            } else {
                c = new Castle(rnd.nextInt(8) + 1, rnd.nextInt(8) + 1);
            }
        }

        System.out.print("Castle is:(" + c.getPosX() + ":" + c.getPosY() + ")     ");
        fileManager.writer("Castle.txt", c.getPosX() + ":" + c.getPosY());



        // horse
        Knight k = new Knight(rnd.nextInt(8) + 1, rnd.nextInt(8) + 1);
        while(true){
            if ((location[(k.getPosY() - 1) * 8 + k.getPosX() - 1] == 0)) {
                location[(k.getPosY() - 1) * 8 + k.getPosX() - 1] = (k.getPosY() - 1) * 8 + k.getPosX() - 1;
                break;
            } else {
                k = new Knight(rnd.nextInt(8) + 1, rnd.nextInt(8) + 1);
            }
        }

        System.out.println("Knight is:(" + k.getPosX() + ":" + k.getPosY() + ")     ");
        fileManager.writer("Knight.txt", k.getPosX() + ":" + k.getPosY());



        //save movements for first location
        fileManager.movements("movements.txt",
                "First location is\n"
                        +"pawn is:(" + p.getPosX() + ":" + p.getPosY() + ")\n"
                        + "bishop is:(" + b.getPosX() + ":" + b.getPosY() + ")\n"
                        + "castle is:(" + c.getPosX() + ":" + c.getPosY() + ")\n"
                        + "knight is:(" + k.getPosX() + ":" + k.getPosY() + ")\n"
                        + "\n\n");


        //GUI for first location
        int ww = 1;
        for (int l = 8; l >= 1; l--) {//posY
            System.out.print(l + "   ");
            for (int s = 1; s <= 8; s++) {
                if (!(p.getPosX() == s && p.getPosY() == l) &&
                        !(b.getPosX() == s && b.getPosY() == l) &&
                        !(c.getPosX() == s && c.getPosY() == l) &&
                        !(k.getPosX() == s && k.getPosY() == l)) {
                    System.out.print("*   ");
                } else if (p.getPosX() == s && p.getPosY() == l)
                    System.out.print("♟  ");
                else if (b.getPosX() == s && b.getPosY() == l)
                    System.out.print("♝  ");
                else if (c.getPosX() == s && c.getPosY() == l)
                    System.out.print("♜  ");
                else
                    System.out.print("♞  ");
            }
            System.out.println(" ");
        }
        System.out.print(" ");
        while (!(ww == 9)) {
            System.out.print("   " + ww);
            ww++;
        }//while
        System.out.println(" ");




        System.out.println(" ");


        try {
            System.out.print("Please Enter The Number Of movements: ");
            int movements = scan.nextInt();
            if (movements <= 2147483647) {
                scan.close();
                char[] mohres = {'p', 'b', 'c', 'k'};
                for (int i = 0; i < movements; i++) {
                    int SelectChess = rnd.nextInt(4);//0 1 2 3
                    while(true){
                        if(mohres[SelectChess] != '.'){ //if mohre[x] == '.', that mohre is dead
                            break;
                        } else {
                            SelectChess = rnd.nextInt(4);
                        }
                    }

                    try {
                        Thread.sleep(sleep);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println();
                    switch (SelectChess) {

                        case 0:
                            if(p.isAvailable){
                                p.safeMove();

                                if(p.getPosY() == 8){  //When pawn is in the end, nothing has moved
                                    i++;
                                }

                                if(!b.isAvailable && !c.isAvailable && !k.isAvailable && p.getPosY() == 8){
                                    //No one is remained but soldier, and soldier in in y = 8. So game is ended
                                    i = movements;
                                }


                                // remove for same soldier
                                if ((p.getPosX() == b.getPosX()) && (p.getPosY() == b.getPosY())) {
                                    b.isAvailable = false;
                                    mohres[1] = '.';
                                    System.out.println("The Bead Bishop Was Hit By The Bead Pawn");
                                }
                                if ((p.getPosX() == c.getPosX()) && (p.getPosY() == c.getPosY())) {
                                    c.isAvailable = false;
                                    mohres[2] = '.';
                                    System.out.println("The Bead Castle Was Hit By The Bead Pawn");
                                }
                                if ((p.getPosX() == k.getPosX()) && (p.getPosY() == k.getPosY())) {
                                    k.isAvailable = false;
                                    mohres[3] = '.';
                                    System.out.println("The Bead Knight Was Hit By The Bead Pawn");
                                }
                            }
                            System.out.println("Pawn is:(" + p.getPosX() + ":" + p.getPosY() + ")     ");
                            fileManager.writer("pawn.txt", p.getPosX() + ":" + p.getPosY());
                            fileManager.movements("movements.txt","pawn is:("+p.getPosX()+":"+p.getPosY()+")\n\n");
                            break;

                        case 1:
                            b.safeMove();
                            // remove for same elephant
                            if ((b.getPosX() == c.getPosX()) && (b.getPosY() == c.getPosY())) {
                                c.isAvailable = false;
                                mohres[2] = '.';
                                System.out.println("The Bead Castle Was Hit By The Bead Bishop");
                            }
                            if ((b.getPosX() == k.getPosX()) && (b.getPosY() == k.getPosY())) {
                                k.isAvailable = false;
                                mohres[3] = '.';
                                System.out.println("The Bead Knight Was Hit By The Bead Bishop");
                            }
                            if ((b.getPosX() == p.getPosX()) && (b.getPosY() == p.getPosY())) {
                                p.isAvailable = false;
                                mohres[0] = '.';
                                System.out.println("The Bead Pawn Was Hit By The Bead Bishop");
                            }
                            System.out.println("Bishop is:(" + b.getPosX() + ":" + b.getPosY() + ")     ");
                            fileManager.writer("Bishop.txt", b.getPosX() + ":" + b.getPosY());
                            fileManager.movements("movements.txt","bishop is:("+b.getPosX()+":"+b.getPosY()+")\n\n");
                            break;

                        case 2:
                            c.safeMove();
                            // remove for same face
                            if ((c.getPosX() == b.getPosX()) && (c.getPosY() == b.getPosY())) {
                                b.isAvailable = false;
                                mohres[1] = '.';
                                System.out.println("The Bead Bishop Was Hit By The Bead Castle");
                            }
                            if ((c.getPosX() == k.getPosX()) && (c.getPosY() == k.getPosY())) {
                                k.isAvailable = false;
                                mohres[3] = '.';
                                System.out.println("The Bead Knight Was Hit By The Bead Castle");
                            }
                            if ((c.getPosX() == p.getPosX()) && (c.getPosY() == p.getPosY())) {
                                p.isAvailable = false;
                                mohres[0] = '.';
                                System.out.println("The Bead Pawn Was Hit By The Bead Castle");
                            }
                            System.out.println("Castle is:(" + c.getPosX() + ":" + c.getPosY() + ")     ");
                            fileManager.writer("Castle.txt", c.getPosX() + ":" + c.getPosY());
                            fileManager.movements("movements.txt","castle is:("+c.getPosX()+":"+c.getPosY()+")\n\n");
                            break;

                        case 3:
                            k.safeMove();
                            // remove for same horse
                            if ((k.getPosX() == b.getPosX()) && (k.getPosY() == b.getPosY())) {
                                b.isAvailable = false;
                                mohres[1] = '.';
                                System.out.println("The Bead Bishop Was Hit By The Bead Knight");
                            }
                            if ((k.getPosX() == c.getPosX()) && (k.getPosY() == c.getPosY())) {
                                c.isAvailable = false;
                                mohres[2] = '.';
                                System.out.println("The Bead Castle Was Hit By The Bead Knight");
                            }
                            if ((k.getPosX() == p.getPosX()) && (k.getPosY() == p.getPosY())) {
                                p.isAvailable = false;
                                mohres[0] = '.';
                                System.out.println("The Bead Pawn Was Hit By The Bead Knight");
                            }
                            System.out.println("Knight is:(" + k.getPosX() + ":" + k.getPosY() + ")     ");
                            fileManager.writer("Knight.txt", k.getPosX() + ":" + k.getPosY());
                            fileManager.movements("movements.txt","knight is:("+k.getPosX()+":"+k.getPosY()+")\n\n");
                            break;

                        default:
                            break;

                    }


                    //GUI
                    int w = 1;
                    for (int l = 8; l >= 1; l--) {
                        System.out.print(l + "   ");
                        for (int s = 1; s <= 8; s++) {
                            if (!(p.getPosX() == s && p.getPosY() == l) && !(b.getPosX() == s && b.getPosY() == l)
                                    && !(c.getPosX() == s && c.getPosY() == l) && !(k.getPosX() == s && k.getPosY() == l)) {
                                System.out.print("*   ");
                            } else if (p.getPosX() == s && p.getPosY() == l && p.isAvailable)
                                System.out.print("♟  ");
                            else if (b.getPosX() == s && b.getPosY() == l && b.isAvailable)
                                System.out.print("♝  ");
                            else if (c.getPosX() == s && c.getPosY() == l && c.isAvailable)
                                System.out.print("♜  ");
                            else if (k.getPosX() == s && k.getPosY() == l && k.isAvailable)
                                System.out.print("♞  ");
                            else
                                System.out.print("*   ");
                        }
                        System.out.println(" ");
                    }
                    System.out.print(" ");
                    while (!(w == 9)) {
                        System.out.print("   " + w);
                        w++;
                    } // while
                    w = 1;
                    System.out.println(" ");
                }
            } else
                throw new Exception();
        } catch (Exception e) {
            System.out.println("your number is invalid");
        }
    }
}