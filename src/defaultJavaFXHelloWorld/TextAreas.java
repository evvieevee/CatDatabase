package defaultJavaFXHelloWorld;

import java.sql.SQLException;
import java.time.ZoneId;

import javafx.geometry.Insets;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class TextAreas {
	
	SqlHandler sqlHandler;
	VBox rootNode;
	int currentId = 1;
	TextField name;
	TextField owner;
	DatePicker birth;
	

	TextAreas() {
		try {
			this.sqlHandler = new SqlHandler();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.rootNode = this.addTextList();
	}
	
	public VBox rootNode(String[] values) {
		
		this.rootNode.getChildren().clear();
		for(int i = 0; i < values.length; i++) {
			this.rootNode.getChildren().add(this.createTextNode(values[i]));
		}
		
		return this.rootNode;
	}
	
	public VBox rootNode() {
		
		this.rootNode.getChildren().clear();
		for(int i = 0; i < 4; i++) {
			this.rootNode.getChildren().add(this.createTextNode("-"));
		}
		
		return this.rootNode;
	}
	
	public void updateText(String action) {
		String sql =  "SELECT * FROM `pets`.`cats` ORDER BY id ASC LIMIT 1;";
		if(action == "Last") {
			sql = "SELECT * FROM `pets`.`cats` ORDER BY id DESC LIMIT 1;";
		}else if (action == "Next") {
			sql = "SELECT * FROM `pets`.`cats` WHERE id > " + this.currentId + " ORDER BY id LIMIT 1;";
		}else if (action == "Prev") {
			sql = "SELECT * FROM `pets`.`cats` WHERE id < " + this.currentId + " ORDER BY id DESC LIMIT 1;";
		}
		try {
			String[] a = this.sqlHandler.fetchData(sql);
			if(a.length != 0) {
				this.currentId = Integer.parseInt(a[0]);
				this.rootNode(a);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void changeNewInput() {
		this.rootNode.getChildren().clear();
		this.rootNode.setSpacing(8);
		this.rootNode.getChildren().add(this.createTextNode("-"));
		this.name = this.createFieldNode();
		this.owner = this.createFieldNode();
		DatePicker d = new DatePicker();
		this.birth = d;
		this.rootNode.getChildren().addAll(this.name, this.owner, this.birth);
	}

	public void changeNewValues() {
		this.rootNode.setSpacing(14);
		this.rootNode.getChildren().clear();
		for(int i = 0; i < 4; i++) {
			this.rootNode.getChildren().add(this.createTextNode("-"));
		}
	}
	
	
	
	public void saveInputs() {
		java.util.Date date = java.util.Date.from(this.birth.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		this.sqlHandler.saveCat(this.name.getText(), this.owner.getText(), sqlDate);
		this.changeNewValues();
		this.updateText("Last");
	}
	
	private VBox addTextList() {
	    VBox vbox = new VBox();
	    vbox.setPadding(new Insets(10));
	    vbox.setSpacing(14);
	    
	    return vbox;
	}

	
	private Text createTextNode(String text) {
		Text node = new Text(text);
		node.setFont(Font.font("Arial", FontWeight.LIGHT, 14));
	    return node;
	}
	
	private TextField createFieldNode() {
		TextField textField = new TextField();
	    return textField;
	}
	
	public void closeConnection() {
		this.sqlHandler.closeConnection();
	}
}
