package com.fah.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

	private static String dbURL = "jdbc:derby:FAHDB;create=true";
	
	public static Connection getConnection() {
		try{
			String myDriver = "org.gjt.mm.mysql.Driver";
			  String myUrl = "jdbc:mysql://10.1.1.17/fah";
			  Class.forName(myDriver);
			  Connection conn = DriverManager.getConnection(myUrl, "fah", "fah");
			  return conn;
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	
}
