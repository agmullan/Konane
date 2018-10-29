/**
**/
import GameElements.Tuple;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Test_Tuple{

 Tuple test_tuple;
/**
  * Sets up the test fixture.
  *
  * Called before every test case method.
  **/
  @Before
  public void setUp(){
    test_tuple = new Tuple(1,1);
  }
/**
 * Tears down the test fixture.
 *
 * Called after every test case method.
 */
@After
  public void tearDown(){

  }

  @Test
  public void test_one() {
    assertEquals(1, test_tuple.x());
    assertEquals(1, test_tuple.y());
  }

}
