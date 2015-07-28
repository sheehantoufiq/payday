package payday;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	public static Connection connection = null;

	public static Connection getConnection() {
		if (connection != null) {
			return connection;
		} else {
			try {

				// DB Credentials
				String driver = "com.mysql.jdbc.Driver";
				String hostname = "jdbc:mysql://localhost:3306/payday_db";
				String user = "root";
				String password = "root";

				Class.forName(driver);
				connection = DriverManager.getConnection(hostname, user, password);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}
		
	}

}