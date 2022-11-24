package defaultJavaFXHelloWorld;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

public class SqlHandler {
	
	Connection connection;

	public SqlHandler() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/pets";
		String username = "remuser";
		String password = "passu123";

		System.out.println("Connecting database...");
		try {
			this.connection = DriverManager.getConnection(url, username, password);
		
		    System.out.println("Database connected!");
		    Statement stmt = this.connection.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT * FROM `pets`.`cats` where `id` = 1;");
		    while (rs.next()) {
		    	  String id = rs.getString("id");
		    	  String name = rs.getString("name");
		    	  String owner = rs.getString("owner");
		    	  String birth = rs.getString("birth");
		    	}
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	
	public String[] fetchData(String sql) throws SQLException {
		try {
		    Statement stmt = this.connection.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    ArrayList<String> subjects = new ArrayList<String>();
    		while (rs.next()) {
    		    subjects.add(rs.getString("id"));
    		    subjects.add(rs.getString("name"));
    		    subjects.add(rs.getString("owner"));
    		    subjects.add(rs.getString("birth"));
    		}
    		String[] subjectArr = new String[subjects.size()];
    		subjectArr = subjects.toArray(subjectArr);
    		return subjectArr;
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	
	public void closeConnection() {
		try {
			this.connection.close();
			System.out.println("db connection closed successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveCat(String name, String owner, java.sql.Date birthDate) {
		try {
	      String query = " insert into cats (name, owner, birth)"
	        + " values (?, ?, ?)";

	      PreparedStatement preparedStmt;
		
	      preparedStmt = this.connection.prepareStatement(query);
		
	      preparedStmt.setString (1, name);
	      preparedStmt.setString (2, owner);
	      preparedStmt.setDate   (3, birthDate);

	      preparedStmt.execute();
	      
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
