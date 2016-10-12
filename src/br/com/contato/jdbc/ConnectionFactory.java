package br.com.contato.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public Connection getConnection(){
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");

			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			return DriverManager.getConnection("jdbc:mysql://localhost/atpsPSD","root","macapple");
		
		} catch (Exception e) {

			throw new RuntimeException(e);

		}
	}
}
