/**
  * @author: Francine Dennehy
  * @author: Alexandra Mullan
  * @version: 1.0
  * This class contains the methods to set up the artifical interegents.
  *
 **/
public class Human extends Player{
char myColor;

public Human(char myColor){
  this.myColor = myColor;
}

public GameBoard takeTurn(){
  GameBoard g = new GameBoard();
  return g;
}

}//end of Agent class
