/**
  * @author: Francine Dennehy
  * @author: Alexandra Mullan
  * @version: 1.0
  * This class contains the methods to generate the legal moves on Kunane.
  *
 **/

 import java.util.*;

public class MoveGenerator{

  public MoveGenerator(){

  }//end of Constructor

  public ArrayList<Tuple> first_turn(char c, GameBoard currentBoardState){
     ArrayList<Tuple> legal_moves = new ArrayList<Tuple>();

    if(c == 'b'){
      legal_moves.add(new Tuple(7,7)); /* the numbers are changed because the   */
      legal_moves.add(new Tuple(0,0)); /* game board is from 0 - 7 not 1 - 8    */
      legal_moves.add(new Tuple(4,4)); /* also the numebers are stored as (y,x) */
      legal_moves.add(new Tuple(3,3));

    }
    if(c == 'w'){
      System.out.println("in white");

      if(currentBoardState.get_game_state(7,7) == 'e'){
          legal_moves.add(new Tuple(6,7));
          legal_moves.add(new Tuple(7,6));
      }
      else if(currentBoardState.get_game_state(0,0) == 'e'){
          legal_moves.add(new Tuple(1,2));
          legal_moves.add(new Tuple(2,1));
      }
      else if(currentBoardState.get_game_state(4,4) == 'e'){
          legal_moves.add(new Tuple(3,4));
          legal_moves.add(new Tuple(4,3));
          legal_moves.add(new Tuple(5,4));
          legal_moves.add(new Tuple(4,5));
      }
      else if(currentBoardState.get_game_state(3,3) == 'e'){
          legal_moves.add(new Tuple(2,3));
          legal_moves.add(new Tuple(3,2));
          legal_moves.add(new Tuple(4,3));
          legal_moves.add(new Tuple(3,4));
      }

    }//end of if c == 'w'

    return legal_moves;
  }//end of first_turn

  public ArrayList<Tuple> get_jump(char c, GameBoard currentBoardState, Tuple t){
      int y = t.y;
      int x = t.x;

      ArrayList<Tuple> possible_moves = new ArrayList<Tuple>();
      ArrayList<Tuple> legal_jumps = new ArrayList<Tuple>();

      Tuple pos_one = new Tuple(t.x, t.y-1); //up
      Tuple pos_two = new Tuple(t.x-1, t.y); //left
      Tuple pos_three = new Tuple(t.x, t.y+1); //down
      Tuple pos_four = new Tuple(t.x+1, t.y); //right

      possible_moves.add(pos_one);
      possible_moves.add(pos_two);
      possible_moves.add(pos_three);
      possible_moves.add(pos_four);

      for(Tuple tuple : possible_moves){
        if(legal(tuple)){
          if(check_isEmpty(tuple, currentBoardState)){
            continue; /*this means it was a legal tile but there is nothing on the block to jump */
          }//end if(check_isEmpty(t, currentBoardState))
          else{
            if(!check_color(tuple, c, currentBoardState)){
              continue; /* this means it was the same color*/
            }//end if(check_color(t, c, currentBoardState)){
            else{
              if(check_landing(tuple, currentBoardState) == true){
                legal_jumps.add(tuple);
              }//end if
            }//end else

          }//end else

        }//end if(legal(t))
      }//end of for

      return legal_jumps;
  }//end of get_jump()

  public boolean check_landing(Tuple t, GameBoard gb){

    ArrayList<Tuple> possible_moves = new ArrayList<Tuple>();

    Tuple pos_one = new Tuple(t.x, t.y-2); //up
    Tuple pos_two = new Tuple(t.x-2, t.y); //left
    Tuple pos_three = new Tuple(t.x, t.y+2); //down
    Tuple pos_four = new Tuple(t.x+2, t.y); //right

    possible_moves.add(pos_one);
    possible_moves.add(pos_two);
    possible_moves.add(pos_three);
    possible_moves.add(pos_four);

    for(Tuple tuple : possible_moves){
      if((legal(tuple) == true) && (check_isEmpty(tuple, gb) == true)){
        return true;
      }
      else{
        return false;
      }
    }//end of for

    return false;
  }//end of check_landing

/*
 * @version 1.0
 * This method is used to see if the tuple given is legal or not. Meaning tuple not
 * on gameboard
 */
public boolean legal(Tuple t){
    if((-1 < t.x ) && (t.x < 8)){
      if((-1 < t.y ) && (t.y < 8)){
        return true;
      }//end inner if
    }//end outer if

    return false;
}

/*
 * @version 1.0
 * This method is used to see if the adjacent tile is empty. If the tile is empty
 * it returns false. If the tile is occupied it will return true.
*/
  public boolean check_isEmpty(Tuple t, GameBoard currentBoardState ){
        if(currentBoardState.get_game_state(t.y, t.x) == 'e'){
          return true;
        }
        else{
          return false;
        }
  }//end of check_isEmpty

  /*
   * @version 1.0
   * This method is used to see if the adjacent tile is the same or different color.
   * If the tile is the same color it returns false. If the tile is a different color
   * it returns true.
  */
  public boolean check_color(Tuple t , char c, GameBoard currentBoardState){

    if(currentBoardState.get_game_state(t.y, t.x) == c){
      return false;
    }
    else{
      return true;
    }

  }

  public Move[] getMoves(GameBoard currentBoardState){
    //based on the current board state return a move with active piece location,
    Move[] optionalMoves = {};
    return optionalMoves;
  }

    //based on the current board state return a move with active piece location,


}//end of MoveGenerator class
