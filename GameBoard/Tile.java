import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Tile extends Rectangle{
  public Tile (boolean light, int x, int y ){
    setWidth(UI.TILE_SIZE);
    setHeight(UI.TILE_SIZE);

    relocate(x * UI.TILE_SIZE, y * UI.TILE_SIZE);

    setFill(light ? Color.rgb(153, 102, 0) : Color.rgb(102, 51, 0));
  }
}//end of Rectangle
