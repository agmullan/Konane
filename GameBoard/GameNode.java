/**
  * @author Francine Dennehy
  * @author Alexandra Mullan
  * This is the GameNode class this will be used to create the game tree that
  * Alpha Beta Pruning will use to run.
  //player -> myColor
  //state
  //previous node (parent)
  //next nodes (ArrayList<GameNodes>)
  //Utility
  //arrayList of moves
 **/
import java.util.*;

public class GameNode{

//Declarations
  protected Player player;
  protected boolean root;
  protected ArrayList<GameNode> children;
  protected ArrayList<Move> moves;
  protected GameNode parent_node;
  protected char[][] gameState;
  protected int utility;

/**
  * @version 1.0
  * This is the constuctor for the GameNode. This constuctor is only used for the root node
  *
 **/
  public GameNode(Player p, GameBoard gd, ArrayList<Move> moves, boolean isRoot){
    set_player(p);
    set_moves(moves);
    set_root(isRoot);
  }//end of constructor

/**
  * @version 1.0
  * @return void
  * This method is used to set the gameNode's player
 **/
  public void set_player(Player p){
    this.player = p;
  }//end set_player(Player p)

/**
  * @version 1.0
  * @return void
  * This method is used to set the root
 **/
  public void set_root(boolean bool){
    this.root = bool;
  }//end set_root()

/**
  * @version 1.0
  * @return void
  * This method is used to set the Parent node of any given node.
 **/
  public void set_parent_node(GameNode gnode){
    this.parent_node = gnode;
  }//end of set_parent_node(GameNode gnode)

/**
  * @version 1.0
  * @return void
  * This method is used to add a child to the GameNode's children
 **/
  public void add_child(GameNode gnode){
    children.add(gnode);
  }//end of add_child(GameNode gnode)

/**
  * @version 1.0
  * @return void
  * This method is used to set the utility value for each node
 **/
  public void set_utility(int i){
    this.utility = i;
  }//end of set_utility(int i)

/**
  * @version 1.0
  * @return void
  * This method is used to set the moves that are associated with each game node. 
 **/
  public set_moves(ArrayList<Move> m){
    this.moves = m;
  }//end of set_moves(ArrayList<Move> m)

}//end of GameNode
