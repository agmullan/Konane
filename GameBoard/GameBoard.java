public class GameBoard{

  //instance variables
  protected char[][] gameState = new char[8][8];
  boolean initialState;
  protected final int SIZE = 8;
  protected Tuple black_first_move = new Tuple(-1,-1);
  protected Tuple white_first_move = new Tuple(-1,-1);

  //Move lastMove;

  //constructor
  public GameBoard(){
    initialState = true;
    newGameBoard();
  }


public void newGameBoard(){
  for(int i = 0; i < 8; i ++){
    for(int j = 0; j < 8; j ++){
      if((i+j) % 2 == 0){
        gameState[i][j] = 'b';
      }else{
        gameState[i][j] = 'w';
      }
    }
  }
}

public void replace(int x, int y, char newVal){
  gameState[x][y] = newVal;
}

public void printGameBoard(){
  for(int i = 0; i < 8; i ++){
    for(int j = 0; j < 8; j ++){
      System.out.print(gameState[i][j]);
      System.out.print(" ");
    }
    System.out.print("\n");
  }
}

public char get_game_state(int x, int y){
  return gameState[x][y];
}

public Tuple get_black_first_move(){
  return black_first_move;
}//end of get_black_first_move

public void set_black_first_move(Tuple t){
  black_first_move = t;
}//end of get_black_first_move

public Tuple get_white_first_move(){
  return white_first_move;
}//end of get_white_first_move

public void set_white_first_move(Tuple t){
  white_first_move = t;
}//end of get_white_first_move

public int get_Size(){
  return SIZE;
}//end of get_Size

}//end of GameBoard
