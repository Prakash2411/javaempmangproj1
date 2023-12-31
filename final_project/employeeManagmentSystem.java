package final_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class employeeManagmentSystem {
	static Connection con;

	public static Connection createDBConnection() {
		try {
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return con;

	}

}
