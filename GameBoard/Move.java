import java.util.*;
import java.io.*;

public class Move{

    private Tuple currentLocation;
    private Tuple futureLocation;
    private boolean noMove;

    private ArrayList<Tuple> removeList;

    public Move(int cX, int cY, int fX, int fY){
        currentLocation = new Tuple(cX, cY);
        futureLocation = new Tuple(fX, fY);
        removeList = new ArrayList<Tuple>();
        noMove = false;
    }

    public Move(){
        removeList = new ArrayList<Tuple>();
        currentLocation = new Tuple(-1,-1);
        futureLocation = new Tuple(-1,-1);
        noMove = false;
    }

    public Move(boolean b){
        noMove = b;
    }

    public boolean noMove(){
        return noMove;
    }

    public int numRemoves(){
        return removeList.size();
    }
    
    public int cLX(){
        return currentLocation.x();
    }
    
    public int fLX(){
        return futureLocation.x();
    }
    
    public Tuple currentLocation(){
        return currentLocation;
    }
    public Tuple futureLocation(){
        return futureLocation;
    }
    public ArrayList<Tuple> removeList(){
        return removeList;
    }

    public void addRemoval(Tuple t){
        removeList.add(t);
    }

    public void addRemoval(int x, int y){
        removeList.add(new Tuple(x,y));
    }

    @Override
    public String toString(){
        String s = "from " + currentLocation + "\nto " + futureLocation + "\n";
        s += "removes " + removeList.toString();
        return s;
    }
}
