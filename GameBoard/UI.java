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


public class UI extends Application{

  public void start(Stage primaryStage){
    //set up display
BorderPane pane = new BorderPane();
HBox Lpane = new HBox (10); // for label
HBox Tpane = new HBox (10); // for title
HBox Opane = new HBox (10); // for selection
pane.setPadding(new Insets(10, 10, 10, 10));


//set up header
 Text title = new Text("Konane");
 title.setFont(new Font("Times New Roman", 60));



//set up panes
Tpane.getChildren().addAll(title);
Tpane.setAlignment(Pos.CENTER);
Tpane.setStyle("-fx-border-color: green");


//place stuff on screen
pane.setTop(Tpane);

//show scene
Scene scene = new Scene (pane, 2500, 1000);
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
