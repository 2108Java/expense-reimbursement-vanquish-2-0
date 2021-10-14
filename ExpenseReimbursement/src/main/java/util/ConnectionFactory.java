package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String SERVER = "localhost";

		private final static String URL =  "jdbc:postgresql://" + SERVER + "/postgres";
		private static final String USERNAME = "postgres";
		private final static String PASSWORD = "1983barada";
		
		

	
		public static Connection connection() throws SQLException {
			
			
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			
		}
}
