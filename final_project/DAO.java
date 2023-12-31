package final_project;

public interface DAO {

	public void createEmployee(phojo ph);
	public void showAllEmployee();
	public void showEmployeebasedId(int id);
	public void updateEmployee(int id , String name);
	public void deleteEmployee(int id);
	
}
