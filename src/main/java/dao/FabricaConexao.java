package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {
	
	private static Connection conn;
	
	public static Connection fazerConexao() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String strConn = "jdbc:mysql://172.17.0.3:3306/aula_web";
			String user = "root";
			String pass = "impa123";
			
			conn = DriverManager.getConnection(strConn, user, pass);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return conn;
	}
}