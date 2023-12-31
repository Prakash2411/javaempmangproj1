package final_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao_class implements DAO {
	Connection con;

	
	@Override
	public void createEmployee(phojo ph) {
		
		con=employeeManagmentSystem.createDBConnection();
		String query="insert into Employee values(?,?,?,?)";
		
		try {
			PreparedStatement pstm=con.prepareStatement(query);
			pstm.setInt(1,ph.getId());
			pstm.setString(2, ph.getName());
			pstm.setDouble(3, ph.getSalary());
			pstm.setInt(4, ph.getAge());
			
			int cnt=pstm.executeUpdate();
			
			if(cnt!=0)
				System.out.println("Data inserted sucesfully....!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void showAllEmployee() {
		con=employeeManagmentSystem.createDBConnection();
		String query="select * from Employee";
		System.out.println("---------------------------------------------------------");
		System.out.println("Employee Details");
		System.out.println("----------------------------------------------------------");
		System.out.println("id\tname\tsalary\tage\n");
		
		try {
			Statement stmt=con.createStatement();
			ResultSet result=stmt.executeQuery(query);
			
			while(result.next()) {
				System.out.format("%d\t%s\t%f\t%d\n",result.getInt(1),result.getString(2),result.getDouble(3),result.getInt(4));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void showEmployeebasedId(int id) {
		con=employeeManagmentSystem.createDBConnection();
		String query="select * from Employee where Id="+id;
		System.out.println("----------------------------------------------------------------");
		System.out.println("Employee Details");
		System.out.println("----------------------------------------------------------------");
		System.out.println("id\tname\tsalary\tage\n");
		
		try {
			Statement stmt =con.createStatement();
			ResultSet result=stmt.executeQuery(query);
			while(result.next()) {
				System.out.format("%d\t%s\t%f\t%d\n",result.getInt(1),result.getString(2),result.getDouble(3),result.getInt(4));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateEmployee(int id, String name) {
		con=employeeManagmentSystem.createDBConnection();
		String query="update Employee set Name=? where Id=?";
		try {
			PreparedStatement pstm=con.prepareStatement(query);
			pstm.setInt(2, id);
			pstm.setString(1, name);
			int cnt=pstm.executeUpdate();
			if(cnt!=0) {
				System.out.println("Data updated sucessfully!........");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteEmployee(int id) {
		con=employeeManagmentSystem.createDBConnection();
		String query="delete from Employee where id=?";
		try {
			PreparedStatement pstm=con.prepareStatement(query);
			pstm.setInt(1, id);
			int cnt=pstm.executeUpdate();
			if(cnt!=0) {
				System.out.println("Data deleted sucessfully......");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
