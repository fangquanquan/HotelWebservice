package dao;

import java.sql.*;

public class DBConnect {
	String driver = "com.mysql.jdbc.Driver";
	String dbName = "id26347040";
	String password = "123456";
	String userName = "fit5183a1";
	String url = "jdbc:mysql://localhost:3306/" + dbName;

	public Connection GetDBCon() {
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, userName,
					password);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
