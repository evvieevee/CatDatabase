package defaultJavaFXHelloWorld;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MenuClass {

	private final BorderPane rootPane ;

	public MenuClass() {
		
		rootPane = new BorderPane();
		HBox hbox = this.addHBox();
		VBox vbox = this.addVBox();
		VBox vboxButtons = this.addVBoxButtons();
		rootPane.setLeft(vbox);
		rootPane.setTop(hbox);
		rootPane.setRight(vboxButtons);
		
	}
	
	private VBox addVBoxButtons() {
		VBox vbox = new VBox();
	    vbox.setPadding(new Insets(10));
	    vbox.setSpacing(8);
	    
	    Button newButton = new Button("Uusi");
	    newButton.setPrefSize(100, 20);
	    
	    Button saveButton = new Button("Tallenna");
	    saveButton.setPrefSize(100, 20);
	    
	    vbox.getChildren().addAll(newButton, saveButton);
		return vbox;
	}

	public Pane getRootPane() {
        return rootPane ;
    }
	
	public HBox addHBox() {
	    HBox hbox = new HBox();
	    hbox.setPadding(new Insets(15, 12, 15, 12));
	    hbox.setSpacing(10);
	    hbox.setStyle("-fx-background-color: #336699;");

	    Button buttonFirst = new Button("<<");
	    buttonFirst.setPrefSize(50, 20);

	    Button buttonBackOne = new Button("<");
	    buttonBackOne.setPrefSize(50, 20);
	    
	    Button buttonForwardOne = new Button(">");
	    buttonForwardOne.setPrefSize(50, 20);
	    
	    Button ButtonLast = new Button(">>");
	    ButtonLast.setPrefSize(50, 20);
	    hbox.getChildren().addAll(buttonFirst, buttonBackOne, buttonForwardOne, ButtonLast);

	    return hbox;
	}
	
	public VBox addVBox() {
	    VBox vbox = new VBox();
	    vbox.setPadding(new Insets(10));
	    vbox.setSpacing(8);

	    Text id = new Text("ID");
	    id.setFont(Font.font("Arial", FontWeight.BOLD, 14));
	    vbox.getChildren().add(id);
	    
	    Text name = new Text("Name");
	    name.setFont(Font.font("Arial", FontWeight.BOLD, 14));
	    vbox.getChildren().add(name);
	    
	    Text owner = new Text("owner");
	    owner.setFont(Font.font("Arial", FontWeight.BOLD, 14));
	    vbox.getChildren().add(owner);
	    
	    Text Birth = new Text("Birth");
	    Birth.setFont(Font.font("Arial", FontWeight.BOLD, 14));
	    vbox.getChildren().add(Birth);


	    return vbox;
	}

}
