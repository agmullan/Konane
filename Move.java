import java.util.*;
import java.io.*;

public class Move{

  public Tuple currentLocation;
  public Tuple futureLocation;

  public ArrayList<Tuple> removeList;

  public Move(int cX, int cY, int fX, int fY){
    currentLocation = new Tuple(cX, cY);
    futureLocation = new Tuple(fY, fY);
    removeList = new ArrayList<Tuple>();
    }

  public Move(){
    removeList = new ArrayList<Tuple>();
    currentLocation = new Tuple(-1,-1);
    futureLocation = new Tuple(-1,-1);
  }
}
