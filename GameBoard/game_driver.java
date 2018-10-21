/**
  * @author: Francine Dennehy
  * @author: Alexandra Mullan
  * @version: 1.0
  * This class contains the main function that will start the entire game of
  * Konane.
  *
 **/

 import java.util.*;

public class game_driver{

/**
  * this is the main method
 **/
public static void main(String[] args){

GameBoard game = new GameBoard();
MoveGenerator mg = new MoveGenerator();

game.replace(7,7,'e');
game.replace(6,7,'e');
//7,5

game.printGameBoard();

Tuple t = new Tuple(5,7);

ArrayList<Tuple> list = mg.get_jump('b', game, t);

for (int i = 0; i < list.size(); i++){
  System.out.println(list.get(i).toString());
}



}//end of main

}//end of game_driver class
