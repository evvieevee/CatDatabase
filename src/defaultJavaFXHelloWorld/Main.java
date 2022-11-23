package defaultJavaFXHelloWorld;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {
  @Override 
  public void start(Stage primaryStage) {
    try{
    	SqlHandler sqlHandler = new SqlHandler();
    	sqlHandler.connectDB();
        String otsikko=" Kissa tietokanta";
        primaryStage.setTitle(otsikko);
        Scene scene = new Scene(new VBox(this.addMenu()));
        MenuClass mClass = new MenuClass();
        
        ((VBox) scene.getRoot()).getChildren().addAll(mClass.getRootPane());
        primaryStage.setScene(scene);
        primaryStage.show();

    } catch(Exception e) {
        e.printStackTrace();
    }
  }
  
	 public MenuBar addMenu() {
			Menu menu1 = new Menu("Menu 1");

			MenuBar menuBar = new MenuBar();

			menuBar.getMenus().add(menu1);
			return menuBar;
	 }
		

  public static void main(String[] args) {
     launch(args);
  }
}

