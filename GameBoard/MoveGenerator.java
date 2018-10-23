/**
  * @author: Francine Dennehy
  * @author: Alexandra Mullan
  * @version: 1.0
  * This class contains the methods to generate the legal moves on Konane.
  *
 **/
import java.util.*;

public class MoveGenerator{

  private char myColor;


  public MoveGenerator(char myColor){
      this.myColor = myColor;
  }//end of Constructor

/**
  * @version 2
 **/
  public ArrayList<Move> first_turn(char c, GameBoard currentBoardState){

    ArrayList<Move> legal_moves = new ArrayList<Move>();

    if(c == 'b'){
        Move m1 = new Move();
        m1.removeList().add(new Tuple(7,7));
        Move m2 = new Move();
        m2.removeList().add(new Tuple(0,0));
        Move m3 = new Move();
        m3.removeList().add(new Tuple(4,4));
        Move m4 = new Move();
        m4.removeList().add(new Tuple(3,3));

        legal_moves.add(m1); /* the numbers are changed because the   */
        legal_moves.add(m2); /* game board is from 0 - 7 not 1 - 8    */
        legal_moves.add(m3); /* also the numebers are stored as (y,x) */
        legal_moves.add(m4);

    }
    if(c == 'w'){

        if(currentBoardState.get_game_state(7,7) == 'e'){
            Move m1 = new Move();
            m1.removeList().add(new Tuple(6,7));
            Move m2 = new Move();
            m2.removeList().add(new Tuple(7,6));

            legal_moves.add(m1);
            legal_moves.add(m2);
        }
        else if(currentBoardState.get_game_state(0,0) == 'e'){
            Move m1 = new Move();
            m1.removeList().add(new Tuple(1,2));
            Move m2 = new Move();
            m2.removeList().add(new Tuple(2,1));

            legal_moves.add(m1);
            legal_moves.add(m2);
        }
        else if(currentBoardState.get_game_state(4,4) == 'e'){
            Move m1 = new Move();
            m1.removeList().add(new Tuple(3,4));
            Move m2 = new Move();
            m2.removeList().add(new Tuple(4,3));
            Move m3 = new Move();
            m3.removeList().add(new Tuple(5,4));
            Move m4 = new Move();
            m4.removeList().add(new Tuple(4,5));

            legal_moves.add(m1);
            legal_moves.add(m2);
            legal_moves.add(m3);
            legal_moves.add(m4);
        }
        else if(currentBoardState.get_game_state(3,3) == 'e'){
            Move m1 = new Move();
            m1.removeList().add(new Tuple(2,3));
            Move m2 = new Move();
            m2.removeList().add(new Tuple(3,2));
            Move m3 = new Move();
            m3.removeList().add(new Tuple(4,3));
            Move m4 = new Move();
            m4.removeList().add(new Tuple(3,4));

            legal_moves.add(m1);
            legal_moves.add(m2);
            legal_moves.add(m3);
            legal_moves.add(m4);
        }

    }//end of if c == 'w'
    return legal_moves;
}//end of first_turn


  public ArrayList<Move> getMoves(char[][] gameState){

        ArrayList<Tree> moveSequences = new ArrayList<Tree>();

        //get all moveable pieces
        ArrayList<Tuple> moveablePieces = getMoveablePieces(gameState);

        //create a tree for each moveable piece
        for(int i = 0; i < moveablePieces.size(); i++){
            moveSequences.add(new Tree(moveablePieces.get(i).x(), moveablePieces.get(i).y()));
        }

        //build each tree
        for(int i = 0; i<moveSequences.size(); i++){
            Tree tr = moveSequences.get(i);
            Node r = moveSequences.get(i).getRoot();
            buildMoveTree(moveSequences.get(i), gameState, r);
        }
        return sequencesToMoves(moveSequences);
    }

    public ArrayList<Move> sequencesToMoves(ArrayList<Tree> t){

        ArrayList<Move> alm = new ArrayList<Move>();

        //for each Tree
        for(int x = 0; x < t.size(); x++){
            //create a set of leaf nodes
            ArrayList<Node> leaves = new ArrayList<Node>();

            //for each node in the tree
            for(int i = 0; i<t.get(x).size(); i ++){
                if(t.get(x).get(i).isLeaf() == true)
                    leaves.add(t.get(x).get(i));
            }
            //backtrack up all the leaf nodes to get complete moves
            for(int i = 0; i< leaves.size(); i++){

                int lX = leaves.get(i).x();
                int lY = leaves.get(i).y();

                int rX = t.get(x).root().x();
                int rY = t.get(x).root().y();

                Move m = new Move(rX, rY, lX, lY);

                createRemoveList(m, leaves.get(i));

                alm.add(m);
            }
        }

        return alm;
    }//end of sequencesToMoves(ArrayList<Tree> t)

    public void createRemoveList(Move m, Node n){

        if(n.isRoot()){
            return;
        }

        int nX = n.x();
        int nY = n.y();

        int pX = n.parent().x();
        int pY = n.parent().y();

        int rmvX = (nX + pX)/2;
        int rmvY = (nY + pY)/2;

        m.addRemoval(rmvX, rmvY);

        createRemoveList(m, n.parent());
    }//end of createRemoveList(Move m, Node n)

    public void buildMoveTree(Tree t, char[][] state, Node parent){

        ArrayList<Tuple> jumps;


        if(parent.isRoot()){
            jumps = getJumps(state, parent.t(), new Tuple(-1,-1));
        }else{
            jumps = getJumps(state, parent.t(), parent.parent().t()); //HERE
        }

        if(jumps.size() == 0){
            return;
        }

        for(int i = 0; i < jumps.size(); i++){
            Node n = new Node(jumps.get(i).x(), jumps.get(i).y(), parent);
            // System.out.println("new node, this is a leaf");
            //System.out.println(n);
            if(nodeNotInPath(n, n.parent())){
                t.addNode(n);
                char[][] newState = tempBoard(state, jumps.get(i), parent.t());

                buildMoveTree(t, newState, n);
            }
        }
    }//end of buildMoveTree(Tree t, char[][] state, Node parent)

    public boolean nodeNotInPath(Node n, Node next){
        //System.out.print("\n" + next + " compare to ");
        //System.out.print(n +"\n");
        if(n.x() == next.x() && n.y() == next.y()){
            return false;
        }
        if(next.isRoot()){
            return true;
        }

        nodeNotInPath(n, next.parent());
        return false;
    }//end of nodeNotInPath(Node n, Node next)

    public char[][] tempBoard(char[][] oldState, Tuple to, Tuple from){
        char[][] newState = new char[8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                newState[i][j] = oldState[i][j];
            }
        }
        newState[from.x()][from.y()] = 'e';
        newState[to.x()][to.y()] = myColor;
        //get rid of the middle piece
        return newState;
    }//end of tempBoard(char[][] oldState, Tuple to, Tuple from)

    public ArrayList<Tuple> getJumps(char[][] state, Tuple t, Tuple previous){
        int x = t.x();
        int y = t.y();
        int px = previous.x();
        int py = previous.y();

        ArrayList<Tuple> jumps = new ArrayList<Tuple>();

        if(x+2 < 8 && state[x+2][y] == 'e' && state[x+1][y] != 'e' && ((x+2) != px && y != py)){
            jumps.add(new Tuple(x+2,y));
        }
        if(x-2 > 0 && state[x-2][y] == 'e' && state[x-1][y] != 'e' && ((x-2) != px && y != py)){
            jumps.add(new Tuple(x-2,y));
        }
        if(y+2 < 8){
            if(state[x][y+2] == 'e'){
                if (state[x][y+1] != 'e'){
                    if(x != px && (y+2) != py){
                        jumps.add(new Tuple(x,y+2));
                    }
                }
            }
        }
        if(y-2 > 0 && state[x][y-2] == 'e' && state[x][y-1] != 'e' && (x != px && (y-2) != py)){
            jumps.add(new Tuple(x,y-2));
        }

        return jumps;
    }//end of getJumps(char[][] state, Tuple t, Tuple previous)

    public ArrayList<Tuple> getMoveablePieces(char[][] state){
        ArrayList<Tuple> moveablePieces = new ArrayList<Tuple>();

        for(int i = 0; i < 8; i++ ){
            for(int j = 0; j < 8; j++){

                if(state[i][j] == myColor)//is it my piece?
                    if(moveable(i, j, state)) //can it move?

                        moveablePieces.add(new Tuple(i,j));
            }
        }
        return moveablePieces;
    }//end of getMoveablePieces(char[][] state)

    public boolean moveable(int x, int y, char[][] state){
        if(x+2 < 8 && state[x+2][y] == 'e' && state[x+1][y] != 'e'){
            return true;
        }
        if(x-2 > 0 && state[x-2][y] == 'e' && state[x-1][y] != 'e'){
            return true;
        }
        if(y+2 < 8 && state[x][y+2] == 'e' && state[x][y+1] != 'e'){
            return true;
        }
        if(y-2 > 0 && state[x][y-2] == 'e' && state[x][y-1] != 'e'){
            return true;
        }
        return false;
    }//end of moveable(int x, int y, char[][] state)

     //based on the current board state return a move with active piece location,

}//end of MoveGenerator class
