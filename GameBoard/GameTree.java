/**
  * @author Francine Dennehy
  * @author Alexandra Mullan
  *
  * This class is used to build the GameTree. This tree will hold GameNodes which are
  * representative of the different possible states a game can be.
 **/
public class GameTree{
  //depth given here
  //creates the tree
  //root
  //arraylist for each depth or leafs?

//Declarations
  protected int DEPTH = 6;
  protected GameNode root;
  protected ArrayList<GameNode> tree;

/**
  * @version 1.0
  *
 **/
  public GameTree(GameNode root){
    tree = new ArrayList<GameNode>();
    set_root(root);
  }//end of constructor

/**
  * @version 1.0
  * @return void
  *
 **/
  public void set_root(GameNode gnode){
    this.root = gnode;
  }//end of set_root(GameNode gnode)

/**
  * @version 1.0
  * @return void
  *
 **/
  public void add_child(GameNode gnode){
    tree.add(gnode);
  }// end of add_child(GameNode gnode)

/**
  * @version 1.0
  * @return int tree.size()
  *
 **/
  public int get_GameTree_Size(){
    return tree.size();
  }//end of get_GameTree_Size()

/**
  * @version 1.0
  * @return GameNode root
  *
 **/
  public GameNode get_root(){
    if((tree.size() > 0)){
      return this.root;
    }
    else{
      return null
    }
  }//end of get_root()

/**
  * @version 1.0
  * @return ArrayList<GameNode> tree
  *
 **/
  public ArrayList<GameNode> get_GameTree(){
    return this.tree;
  }//end of get_GameTree()

/**
  * @version 1.0
  * @return GameNode tree.get(i)
  *
  **/
  public GameNode get_branch(int i){
    return this.tree.get(i);
  }//end of get_branch(int i)

}//end of GameTree
