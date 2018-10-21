public class GameBoard{

  //instance variables
  char[][] gameState = new char[8][8];
  boolean initialState;


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

}
