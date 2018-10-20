import java.util.*;
import java.io.*;

public class Move{

  public int currentX;
  public int currentY;
  public int futureX;
  public int futureY;

  public ArrayList<Tuple> removeList;

  public Move(int cX, int cY, int fX, int fY){
    currentX = cX;
    currentY = cY;
    futureX = fX;
    futureY = fY;
  }
}
