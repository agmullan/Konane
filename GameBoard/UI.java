import java.util.Date;

import javafx.application.Application;
import javafx.collections.*;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.paint.*;
import javafx.scene.Group;


public class UI extends Application{

  //Declarations
  public static final int TILE_SIZE = 100; //for the tile square
  public static final int WIDTH = 8;       /* This is to make the board */
  public static final int HEIGHT = 8;      /*  8 x 8 whcih is a standard board in Konane */

  private Group tileGroup = new Group();

  private Pane createBoard(){
    Pane root = new Pane();
    root.setPrefSize(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
    root.getChildren().addAll(tileGroup);

    //root.getChildren().addAll(new Text("here"));

    for(int x = 0; x < HEIGHT; x++){
      for(int y = 0; y < WIDTH; y++){
        Tile tile = new Tile (( x + y ) % 2 == 0, x, y);

        tileGroup.getChildren().add(tile);
      }
    }


    return root;
  }//end of createBoard

  public void start(Stage primaryStage){
    //set up display
BorderPane pane = new BorderPane();
HBox Tpane = new HBox (10); // for title
HBox Board_Pane = new HBox(10);
pane.setPadding(new Insets(10, 10, 10, 10));


//set up header
 Text title = new Text("Konane");
 title.setFont(new Font("Times New Roman", 60));

//numbers for Scene size
final double NUM_WIDTH = 1000; //2500
final double NUM_HEIGHT = 1000; //1000

//set up panes
Tpane.getChildren().addAll(title);
Tpane.setAlignment(Pos.CENTER);
//Tpane.setStyle("-fx-border-color: blue");
pane.setStyle("-fx-background-color: teal");

Board_Pane.getChildren().addAll(createBoard());
Board_Pane.setAlignment(Pos.TOP_CENTER);
HBox.setHgrow(Board_Pane, Priority.ALWAYS);
//Board_Pane.setPrefSize(temp);
//pane.setFill(Color.rgb(0,153,0));


//place stuff on screen
pane.setLeft(Tpane);
pane.setCenter(Board_Pane);


//show scene
Scene scene = new Scene (pane, NUM_WIDTH, NUM_HEIGHT);
primaryStage.setTitle("Konane");
primaryStage.setScene(scene);
primaryStage.show();

  }//end of start

/**
  * this is the main method
 **/
public static void main(String[] args){
  //call methods here
  Application.launch(args);
  //System.out.println("Hello");
}//end of main

}//end of UI class
