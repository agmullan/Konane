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
MoveGenerator temp = new MoveGenerator();

ArrayList<Tuple> list =  temp.first_turn('b', game);

for (int i = 0; i < list.size(); i++){
  System.out.println(list.get(i).toString());
}

game.replace(7,7,'e');

System.out.println();

ArrayList<Tuple> list2 =  temp.first_turn('w', game);

for (int i = 0; i < list2.size(); i++){
  System.out.println(list2.get(i).toString());
}

game.printGameBoard();

}//end of main

}//end of game_driver class
