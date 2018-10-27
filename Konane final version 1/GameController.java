/**
 * @author: Francine Dennehy
 * @author: Alexandra Mullan
 * @version: 1.0
 * This class contains the methods to make the game functioning.
 * These methods inclube making the GameBoard, keeping the game loop up to date,
 * and much more
 *
 **/
import java.util.Scanner;
import java.util.*;

public class GameController{

    //instance variables
    private GameBoard      gameBoard;
    private Player         white, black;
    private static Scanner scan;
    private boolean        gameWon;
    private int            round       = 2;
    private int            searchDepth = -1;
    private int            speed       = -1;

    //constructor
    public GameController(){
        gameBoard = new GameBoard();
        gameWon = false;

        initializeGameSettings();
        runGame();
    }

    public void firstTurn(Player p){
        ArrayList<Move> moves;
        Move m;
        if(!p.isCPU()){ //if this player is human
            moves = p.takeFirstTurn(gameBoard);
            m     = p.playerChooseMove(moves, selectMove(moves, p.myColor()));
        }else{
            moves = p.takeFirstTurn(gameBoard);
            m     = p.chooseMove(moves, gameBoard, p.myColor(), true);
        }
        gameBoard.update(m, p.myColor());
    }

    public void turn(Player p){
        ArrayList<Move> moves;
        Move m;
        if(!p.isCPU()){ //if this player is human
            moves = p.takeTurn(gameBoard);
            m     = p.playerChooseMove(moves, selectMove(moves, p.myColor()));
        }else{
            moves = p.takeTurn(gameBoard);
            m     = p.chooseMove(moves, gameBoard, p.myColor(), false);
        }

        String loser;
        String winner;
        if(p.myColor() == 'b'){
            loser = "Black";
            winner = "White";
        }else{
            loser = "White";
            winner = "Black";
        }

        gameWon = checkForWin(m, loser, winner);

        gameBoard.update(m, p.myColor());
    }

    public void runGame(){

        ArrayList<Move> moves;
        Move m;

        //BLACK FIRST MOVE
        System.out.println("-----------------------");
        System.out.println("Round 1: Black's move");
        System.out.println("-----------------------");
        gameBoard.printGameBoard();
        firstTurn(black);

        //WHITE FIRST MOVE
        System.out.println("-----------------------");
        System.out.println("Round 1: White's move");
        System.out.println("-----------------------");
        gameBoard.printGameBoard();
        firstTurn(white);

        //BEGIN REST OF GAME
        while(!gameWon){
            System.out.println("-----------------------");
            System.out.println("Round " + round + ": Black's move");
            System.out.println("-----------------------");
            gameBoard.printGameBoard();
            turn(black);

            System.out.println("-----------------------");
            System.out.println("Round " + round + ": White's move");
            System.out.println("-----------------------");
            gameBoard.printGameBoard();
            turn(white);

            round++;
        }
    }

    public int selectMove(ArrayList<Move> alm, char myColor){
        if(alm.size() == 0){
            System.out.println("No moves!");
            return 0;
        }
        for(int i = 0; i < alm.size(); i++){
            System.out.println(i+1 +". " + alm.get(i));
        }
        scan = new Scanner(System.in);
        System.out.println("Enter the number of the move you choose.");
        int i = scan.nextInt()-1;

        return i;
    }

    public boolean checkForWin(Move m, String loser, String winner){
        if(m.noMove() == true){
            scan.close();
            System.out.println(loser + "! you are out of moves! " + winner + "! You win!");
            System.exit(0);
        }
        return false;
    }

    public void initializeGameSettings(){
       System.out.println("\n\nWELCOME TO KONANE\n");
       boolean validInput = false;

       scan = new Scanner(System.in);

       while(!validInput){
          System.out.println("Choose the game tree search depth. \nType a number between 1 and 6, or type O for random depth.");

          searchDepth = scan.nextInt();

          if(searchDepth >= 0 && searchDepth <= 6)
            validInput = true;

          if(!validInput)
            System.out.println("Invalid input, try again. Game tree depth must be between 1 and 6, or 0 for random depth.");
       }

       validInput = false;

       while(!validInput){
          System.out.println("Choose the speed of your opponent. \nType 1 for slow (minimax) and 2 for fast (alpha beta pruning)");
          speed = scan.nextInt();

          if(speed == 1 || speed == 2)
            validInput = true;

          if(!validInput)
            System.out.println("Invalid input, try again.");
       }

       chooseYourColor();
    }

    public void chooseYourColor(){
        String ans = "";
        boolean validInput = false;

        scan = new Scanner(System.in);

        while(!validInput){

            System.out.println("Choose your color. Type b for black or w for white: ");

            ans = scan.next();

            if(ans.equals("b") || ans.equals("w")){
                validInput = true;
            }

            if(!validInput){
                System.out.println("invalid input, try again.");
            }
        }

        if(ans.equals("b")){
            black = new Human('b', false);
            white = new Agent('w', true);
            white.addStrategySettings(speed, searchDepth);
        }
        else if(ans.equals("w")){
            System.out.println("HERE");
            white = new Human('w', false);
            black = new Agent('b', true);
            black.addStrategySettings(speed, searchDepth);
        }
    }

}//end of GameBoard class
