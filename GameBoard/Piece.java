import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.*;

public class Piece extends Circle{

private double mouseX, mouseY;
private double orig_X, orig_Y;

  public Piece (boolean black, int x, int y ){

    setRadius((0.5) * UI.TILE_SIZE);

    relocate(x * UI.TILE_SIZE, y * UI.TILE_SIZE);
    // move(x * UI.TILE_SIZE, y * UI.TILE_SIZE);
    setFill(black ? Color.rgb(0, 0, 0) : Color.rgb(255, 255, 255));

    setStrokeWidth(3);
    setStroke(Color.BLACK);

    setOnMousePressed(e ->{
      mouseX = e.getSceneX();
      mouseY = e.getSceneY();
      setStroke(Color.GOLD);

    });

    // setOnMouseDragged(e ->{
    //   relocate(e.getSceneX() - mouseX + orig_X, e.getSceneY() - mouseY + orig_Y);
    // });


  }//end constructor

  public void move(int x, int y){
    orig_X = x * UI.TILE_SIZE;
    orig_Y = y * UI.TILE_SIZE;
    relocate(orig_X, orig_Y);
  }//end of move

}//end of Piece
