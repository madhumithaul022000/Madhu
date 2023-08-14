package RailwayReserv;

import java.sql.*;

public class DbConnection {
	private static final String url = "jdbc:mysql://localhost:3306/RailwayReserv";
	private static final String userName = "root";
	private static final String passWord = "Bro1706@1802#";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,userName,passWord);
	}
	
}