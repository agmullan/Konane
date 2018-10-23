/**
 * @author: Francine Dennehy
 * @author: Alexandra Mullan
 * @version: 1.0
 * This class contains the methods to set up the artifical interegents.
 *
 **/

import java.io.*;
import java.util.Scanner;
import java.util.*;

public class Human extends Player{
    private char myColor;
    private MoveGenerator moveGenerator;
    private boolean isCPU;

    public Human(char myColor, boolean isCPU){
        this.myColor = myColor;
        this.isCPU = isCPU;
        moveGenerator = new MoveGenerator(myColor);
    }

    public boolean isCPU(){
        return isCPU;
    }
    
      public char myColor(){
      return myColor;
    }

    public ArrayList<Move> takeFirstTurn(GameBoard currentBoardState){
        ArrayList<Move> availableMoves = moveGenerator.first_turn(myColor,currentBoardState);
        return availableMoves; //chooseMove(availableMoves);
    }

    public ArrayList<Move> takeTurn(GameBoard currentBoardState){
        ArrayList<Move> availableMoves = moveGenerator.getMoves(currentBoardState.gameState());
        return availableMoves;
    }

    public Move chooseMove(ArrayList<Move> availableMoves){
        if(availableMoves.size() > 0){
            return availableMoves.get(0);
        }else{
            Move m = new Move(true);
            return m;
        }
    }

    public Move playerChooseMove(ArrayList<Move> availableMoves, int i){
        if(availableMoves.size() > 0){
            return availableMoves.get(i);
        }else{
            Move m = new Move(true);
            return m;
        }
    }

}//end of Agent class
