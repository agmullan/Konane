/**
  *
 **/
package Tests;
import GameElements.Tuple;
import java.util.*;

public class Test_Tuple{

public Test_Tuple(){
  System.out.println("Test tuple result: " + run_test());
}

  public boolean run_test(){
    Tuple t = new Tuple(1,1);

    if((t.x() == 1) && (t.y() == 1)){
      return true;
    }
    else {
      return false;
    }
  }
}//endof Test_Tuple
