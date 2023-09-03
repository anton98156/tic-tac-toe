package main.java.game;

public class Main {

    public static void main(String[] args) {
        
        Operations.cell = new char[3][];

        System.out.println("Welcome to tic-tac-toe!\n");

        while (true){
            
            Operations.gamePlay();
            Operations.showGame();

            while (true){
                Operations.playerPutsEl();
                Operations.showGame();
                if (Operations.gameCheck(Operations.POINT_PLAYER, "\nYou won!"))
                    break;
                Operations.computerPutsEl();
                Operations.showGame();
                if (Operations.gameCheck(Operations.POINT_COMPUTER, "\nDefeat :("))
                    break;
            }

            System.out.print("\nDo you want to play again? Input 'Y': ");
            if (!Operations.sc.next().equalsIgnoreCase("Y"))
                break;
        }
    }

}
