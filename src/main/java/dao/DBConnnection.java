package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnnection {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/jsp-project";
		String user = "root";
		String password = "";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(dbURL, user, password);
		
		return connection;
	}
}
