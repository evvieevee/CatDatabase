package defaultJavaFXHelloWorld;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlHandler {

	public SqlHandler() {
		
	}
	
	public void connectDB() throws SQLException {
		System.out.println("lol");
		String url = "jdbc:mysql://localhost:3306/pets";
		String username = "remuser";
		String password = "passu123";

		System.out.println("Connecting database...");

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
		    System.out.println("Database connected!");
		    Statement stmt = connection.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT * FROM `pets`.`cats` where `id` = 1;");
		    while (rs.next()) {
		    	  String id = rs.getString("id");
		    	  String name = rs.getString("name");
		    	  String owner = rs.getString("owner");
		    	  String birth = rs.getString("birth");
		    	  System.out.println(id + " : " + name + " : " + owner + " : " + birth + "\n");
		    	}
		    connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
}
