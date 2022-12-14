package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import projects.exception.DbException;

public class DbConnection {
	private static String HOST = "localhost";
	private static String PASSWORD = "projects";
	private static int PORT = 3306;
	private static String SCHEMA = "projects";
	private static String USER = "projects";

	public static Connection getConnection() {
		String url = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=false", HOST, PORT, SCHEMA, USER, PASSWORD);
		
		System.out.println("Connecting with url: " + url);
		try {
			Connection connection = DriverManager.getConnection(url);
			System.out.println("Connection successful!");
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection failed");
			throw new DbException(e);
		}
		
	}

}
