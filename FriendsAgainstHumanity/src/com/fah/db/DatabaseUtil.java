package com.fah.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.derby.impl.jdbc.EmbedConnection;

public class DatabaseUtil {

	private static String dbURL = "jdbc:derby:FAHDB;create=true";
	
	private static Connection createConnection() {
		try{
			
			Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
			// Get a connection
			Connection conn = DriverManager.getConnection(dbURL);
			EmbedConnection derbConn = (EmbedConnection) conn;
			
			return conn;
		}catch(ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	
	public static void main(String[] args) {
		System.getProperties().list(System.out);
		Connection conn = DatabaseUtil.createConnection();
		
		System.out.println(conn);
	}
}
