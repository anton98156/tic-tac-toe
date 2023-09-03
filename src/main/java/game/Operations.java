package main.java.game;

import java.util.Random;
import java.util.Scanner;

public class Operations {

    protected static final char POINT_PLAYER = 'X';
    protected static final char POINT_COMPUTER = '0';
    protected static final char POINT_NULL = '-';
    protected static final Scanner sc = new Scanner(System.in);
    protected static final Random random = new Random();
    protected static char[][] cell;
    protected static int xSize;
    protected static int ySize;

    protected static void gamePlay(){

        xSize = 3;
        ySize = 3;

        cell = new char[xSize][ySize];
        
        for (int x = 0; x < xSize; x++){
            for (int y = 0; y < ySize; y++){
                cell[x][y] = POINT_NULL;
            }
        }

    }

    protected static void showGame(){
        
        System.out.println();

        for (int x = 0; x < xSize; x++){
            System.out.print("|");
            for (int y = 0; y < ySize; y++){
                System.out.print(cell[x][y] + "|");
            }
            System.out.println();
        }

    }

    protected static void playerPutsEl(){
        int x;
        int y;

        do {
            while (true){
                System.out.print("\nEnter X (1 - 3): ");
                if (sc.hasNextInt()){
                    x = sc.nextInt() - 1;
                    sc.nextLine();
                    break;
                } else {
                    System.out.println("\nWrong number, try again: ");
                    sc.nextLine();
                }
            }

            while (true){
                System.out.print("\nEnter Y (1 - 3): ");
                if (sc.hasNextInt()){
                    y = sc.nextInt() - 1;
                    sc.nextLine();
                    break;
                } else {
                    System.out.println("\nWrong number, try to input again: ");
                    sc.nextLine();
                }
            }
        }

        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        cell[x][y] = POINT_PLAYER;
    }

    private static boolean isCellEmpty(int x, int y){
        return cell[x][y] == POINT_NULL;
    }

    private static boolean isCellValid(int x, int y){
        return x >= 0 && x < xSize && y >= 0 && y < ySize;
    }

    protected static void computerPutsEl(){
        int x, y;

        do {
            x = random.nextInt(xSize);
            y = random.nextInt(ySize);
        }
        while (!isCellEmpty(x, y));
        cell[x][y] = POINT_COMPUTER;
    }

    protected static boolean gameCheck(char c, String s){
        
        if (checkWin(c)) {
            System.out.println(s);
            return true;
        }

        if (checkDraw()) {
            System.out.println("\nDraw!");
            return true;
        }

        return false;
    }

    private static boolean checkWin(char c){

        if (cell[0][0] == c && cell[0][1] == c &&
                        cell[0][2] == c) return true;
        if (cell[1][0] == c && cell[1][1] == c &&
                        cell[1][2] == c) return true;
        if (cell[2][0] == c && cell[2][1] == c &&
                        cell[2][2] == c) return true;

        if (cell[0][0] == c && cell[1][0] == c &&
                        cell[2][0] == c) return true;
        if (cell[0][1] == c && cell[1][1] == c &&
                        cell[2][1] == c) return true;
        if (cell[0][2] == c && cell[1][2] == c &&
                        cell[2][2] == c) return true;

        if (cell[0][0] == c && cell[1][1] == c &&
                        cell[2][2] == c) return true;
        if (cell[0][2] == c && cell[1][1] == c &&
                        cell[2][0] == c) return true;

        return false;
        
    }

    static boolean check(int x, int y, int win){
        return false;
    }


    private static boolean checkDraw(){
        for (int x = 0; x < xSize; x++){
            for (int y = 0; y < ySize; y++){
                if (isCellEmpty(x, y))
                return false;
            }
        }

        return true;
    }

}

