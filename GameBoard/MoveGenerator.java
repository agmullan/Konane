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
                m1.removeList().add(new Tuple(0,1));
                Move m2 = new Move();
                m2.removeList().add(new Tuple(1,1));

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

    public ArrayList<Tuple> get_jump(GameBoard currentBoardState, Tuple t, char myColor){
        int y = t.y();
        int x = t.x();

        ArrayList<Tuple> possible_moves = new ArrayList<Tuple>();
        ArrayList<Tuple> legal_jumps = new ArrayList<Tuple>();

        Tuple pos_one = new Tuple(t.x(), t.y()-2); //up
        Tuple pos_two = new Tuple(t.x()-2, t.y()); //left
        Tuple pos_three = new Tuple(t.x(), t.y()+2); //down
        Tuple pos_four = new Tuple(t.x()+2, t.y()); //right

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
                    if(!check_color(tuple, myColor, currentBoardState)){
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

        Tuple pos_one = new Tuple(t.x(), t.y()-2); //up
        Tuple pos_two = new Tuple(t.x()-2, t.y()); //left
        Tuple pos_three = new Tuple(t.x(), t.y()+2); //down
        Tuple pos_four = new Tuple(t.x()+2, t.y()); //right

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
        if((-1 < t.x() ) && (t.x() < 8)){
            if((-1 < t.y() ) && (t.y() < 8)){
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
        if(currentBoardState.get_game_state(t.y(), t.x()) == 'e'){
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

        if(currentBoardState.get_game_state(t.y(), t.x()) == c){
            return false;
        }
        else{
            return true;
        }

    }

    public ArrayList<Move> getMoves(char[][] gameState, char myColor){

        ArrayList<Tree> moveSequences = new ArrayList<Tree>();

        //get all moveable pieces
        ArrayList<Tuple> moveablePieces = getMoveablePieces(gameState, myColor);

        //create a tree for each moveable piece
        for(int i = 0; i < moveablePieces.size(); i++){
            moveSequences.add(new Tree(moveablePieces.get(i).x(), moveablePieces.get(i).y()));
        }
        //System.out.println(moveablePieces.size() + " cosas pueden mover en al menos de una manera");
        //build each tree
        for(int i = 0; i<moveSequences.size(); i++){
            Tree tr = moveSequences.get(i);
            Node r = moveSequences.get(i).getRoot();
            buildMoveTree(moveSequences.get(i), gameState, r, myColor);
        }
        return sequencesToMoves(moveSequences);
    }

    public ArrayList<Move> sequencesToMoves(ArrayList<Tree> t){

        ArrayList<Move> alm = new ArrayList<Move>();
        ArrayList<Node> leaves = new ArrayList<Node>();

        System.out.println("there are " + t.size() + " trees");
        //for each Tree
        for(int x = 0; x < t.size(); x++){
            //create a set of leaf nodes
            //for each node in the tree
            for(int i = 0; i<t.get(x).size(); i ++){
                if(t.get(x).get(i).isLeaf() == true){
                    leaves.add(t.get(x).get(i));
                }
            }

        }

        //System.out.println("There are " + leaves.size() +" leaves, so there should be " + leaves.size() + " moves");

        for(int i = 0; i< leaves.size(); i++){
            Node r = leaves.get(i); //set r = to a leaf

            int lX = r.x(); //save the leaf's coordinates
            int lY = r.y();

            while(!r.isRoot()){ //set r = this leaf's root
                r = r.parent();
            }

            int rX = r.x();
            int rY = r.y();

            Move m = new Move(rX, rY, lX, lY);

            createRemoveList(m, leaves.get(i));

            alm.add(m);
        }

        return expandMoves(alm);
    }

    public void expand(int sX, int sY, int  eX,int  eY, int noJumps, Move fullMove, ArrayList<Move> alm){
        int stepX = -1;
        int stepY = -1;
        //get the new end tuple
        if(sX-eX < 0){
            stepX = eX+1;
            stepY = eY;
        }else if(sX - eX > 0){
            stepX = eX-1;
            stepY = eY;
        }else if(sY-eY < 0){
            stepX = eX;
            stepY = eY+1;
        }else if(sY-eY>0){
            stepX = eX;
            stepY = eY-1;
        }
        Move m = new Move(fullMove.cLX(),fullMove.cLY(),stepX,stepY);
        for(int i = 0; i < noJumps-1; i++){
            m.addRemoval(fullMove.removeList().get(i));
        }
        noJumps--;
        alm.add(m);
        if(noJumps == 1){
            return;
        }
        expand(stepX,stepY,fullMove.removeList().get(noJumps-1).x(),fullMove.removeList().get(noJumps-1).y(),noJumps,fullMove,alm);
    }

    public ArrayList<Move> expandMoves(ArrayList<Move> alm){
        for(int i = 0; i < alm.size(); i++){
            Move fullMove = alm.get(i);
            int noSteps = fullMove.removeList().size();
            if(noSteps > 1){

                int startX = fullMove.fLX();
                int startY = fullMove.fLY();
                int endX = fullMove.removeList().get(noSteps-1).x();
                int endY = fullMove.removeList().get(noSteps-1).y();
                expand(startX,startY,endX,endY,noSteps,fullMove, alm);

            }
        }
        removeDuplicates(alm);
        return alm;
    }

    public void removeDuplicates(ArrayList<Move> alm){
        for(int i = 0; i < alm.size()-1; i++){ //for each move in arraylist
            for(int j = i+1; j<alm.size(); j ++){
                if(alm.get(i).compareTo(alm.get(j)) == 0){//if theyre equal
                    //System.out.println("Remove " + alm.get(j));
                    alm.remove(j);

                }
            }
        }
    }

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
    }

    public void buildMoveTree(Tree t, char[][] state, Node parent, char myColor){

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
            Node n = new Node(jumps.get(i), parent);

            t.addNode(n);
            char[][] newState = tempBoard(state, jumps.get(i), parent.t(), myColor);

            buildMoveTree(t, newState, n, myColor);

        }
    }

    public char[][] tempBoard(char[][] oldState, Tuple to, Tuple from, char myColor){
        char[][] newState = new char[8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                newState[i][j] = oldState[i][j];
            }
        }

        newState[from.x()][from.y()] = 'e';
        newState[to.x()][to.y()] = myColor;
        newState[(to.x()+from.x())/2][(to.y()+from.y())/2] = 'e';

        return newState;
    }

    public ArrayList<Tuple> getJumps(char[][] state, Tuple t, Tuple previous){
        int x = t.x();
        int y = t.y();
        int px = previous.x();
        int py = previous.y();

        ArrayList<Tuple> jumps = new ArrayList<Tuple>();

        if(x+2 < 8 && state[x+2][y] == 'e' && state[x+1][y] != 'e' && ((x+2) != px && y != py)){
            jumps.add(new Tuple(x+2,y));
        }
        if(x-2 >= 0 && state[x-2][y] == 'e' && state[x-1][y] != 'e' && ((x-2) != px && y != py)){
            jumps.add(new Tuple(x-2,y));
        }
        if(y+2 < 8 && state[x][y+2] == 'e' && state[x][y+1] != 'e' && (x != px && (y+2) != py)){
            jumps.add(new Tuple(x,y+2));
        }
        if(y-2 >= 0 && state[x][y-2] == 'e' && state[x][y-1] != 'e' && (x != px && (y-2) != py)){
            jumps.add(new Tuple(x,y-2));
        }

        return jumps;
    }

    public ArrayList<Tuple> getMoveablePieces(char[][] state, char myColor){
        ArrayList<Tuple> moveablePieces = new ArrayList<Tuple>();

        for(int i = 0; i < 8; i++ ){
            for(int j = 0; j < 8; j++){

                if(state[i][j] == myColor)//is it my piece?
                    if(moveable(i, j, state)) //can it move?

                        moveablePieces.add(new Tuple(i,j));
            }
        }
        return moveablePieces;
    }

    public boolean moveable(int x, int y, char[][] state){
        if(x+2 < 8 && state[x+2][y] == 'e' && state[x+1][y] != 'e'){
            return true;
        }
        if(x-2 >= 0 && state[x-2][y] == 'e' && state[x-1][y] != 'e'){
            return true;
        }
        if(y+2 < 8 && state[x][y+2] == 'e' && state[x][y+1] != 'e'){
            return true;
        }
        if(y-2 >= 0 && state[x][y-2] == 'e' && state[x][y-1] != 'e'){
            return true;
        }
        return false;
    }

}//end of MoveGenerator class
