package challenge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection createConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:sqlite:" +
				"C:\\Users\\leona\\codenation\\java-4\\src\\main\\resources\\database.sqlite");
	}

}
