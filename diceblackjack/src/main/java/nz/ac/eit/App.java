package nz.ac.eit;

import java.lang.Math;
import java.io.*;
/**
 * Hello world!
 *
 */




public class App {

    // main
    public static void main(String args[])
    {
        Player player1 = new Player;
        Player AI = new Player;
        char playerInputPlay, playerInputRoll;
        Scanner s = new Scanner(System.in);

        while (playerInputPlay != "n")
        {
            System.out.println("Would you like to play a game?");
            System.out.println("please enter 'y' or 'n'");
            playerInputPlay = s.next().charAt(0);
            playerInputPlay = playerInputPlay.toLowerCase();
            switch (playerInputPlay)
            {
                case y:
                    player1.setPlayerScore(0);
                    AI.setPlayerScore(0);
                    System.out.println("making your initial roll");
                    hit(player1);

                    while (playerInputRoll != 'n')
                    {
                        System.out.println("Your score is: " + Player1.getPlayerScore);
                        System.out.println("Do you wish to roll again");
                        playerInputRoll = s.next().charAt(0);
                        switch (playerInputRoll)
                        {
                            case y:
                                hit(player1);
                                break;
                            case n:
                                System.out.println("You stand on :" + Player1.getPlayerScore);
                                break;
                            default:
                                System.out.println("Invalid Input");
                                System.out.println("please ensure to enter correct data");
                        }
                    }
                    System.out.println("It is the Dealers Turn");
                    System.out.println("Dealer Rolls");
                    roll(AI);
                    Thread.sleep(1000);
                    System.out.println("Dealer rolls a: " + AI.getPLayerScore());
                    Thread.sleep(1000);
                    while (AI.getPlayerScore<16)
                    {
                        System.out.println("Dealer Hits Again");
                        Thread.sleep(1000);
                        AI.dealerTurn();
                        System.out.println("Dealer Score after roll: " + AI.getPlayerScore())
                    }
                    if (AI.getPlayerScore()>21){
                        System.out.println("Dealer goes Bust");
                    }
                    else {
                        System.out.println("Dealer sits on :" + AI.getPlayerScore())
                    }
                    System.out.println("And the winner is: " + calculateWinner());
                    Thread.sleep(1000);
                    System.out.println("This game has finished");




                    break;
                case n:
                    System.exit();
                    break;
                default:
                    System.out.println("Warning Invalid Input");
                    System.out.println("Please enter y or n");
                    playerInputPlay = s.next().charAt(0);
                    playerInputPlay = playerInputPlay.toLowerCase();
            }



        }
    }
}
