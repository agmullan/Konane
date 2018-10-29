
package Tests;
import GameElements.GameBoard;
import GameElements.Tuple;
import java.util.*;

public class Test_GameBoard{

  public Test_GameBoard(){
    System.out.println("Test get_Size() result: " + Test_getSize());
    System.out.println("Test get_game_state() result: " + Test_get_game_state());
    System.out.println("Test replace() result: " + Test_replace());
    System.out.println("Test update() result: ";
  }

  public boolean Test_getSize(){
    GameBoard gb = new GameBoard();
    if(gb.get_Size() == 8){
      return true;
    }
    else{
      return false;
    }
  }//endof Test_getSize()

  public boolean Test_get_game_state(){
    GameBoard gb = new GameBoard();
  //  gb.printGameBoard();
    if(gb.get_game_state(1,2) == 'w'){
      return true;
    }
    else{
      return false;
    }
  }//endof Test_get_game_state

  public boolean Test_replace(){
    GameBoard gb = new GameBoard();
    Tuple tuple = new Tuple(1,2);
    gb.replace(tuple, 'b');

    if(gb.get_game_state(1,2) == 'b'){
      return true;
    }
    else{
      return false;
    }

  }//endof Test_replace


}//endof Test_GameBoard
