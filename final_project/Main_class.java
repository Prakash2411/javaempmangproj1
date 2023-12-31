package final_project;

import java.util.Scanner;

public class Main_class {

	public static void main(String[] args) {
		DAO dao=new Dao_class();
		System.out.println("** Welcome to Employee management Application **");
		Scanner sc=new Scanner(System.in);
		
		do {
			System.out.println("Enter your choice:");
			System.out.println("1.Add Employee\n" + "2. Show all Employee\n"
					+ "3. Show Employee based on id\n"+"4. Update the Employee\n"+
					"5: Delete employee based on id\n"+
					"6. Exit from Application");
			int ch=sc.nextInt();
			
			switch(ch) {
			case 1:
				phojo Emp=new phojo();
				System.out.println("Enter Id:");
				int id=sc.nextInt();
				System.out.println("Enter name");
				String name=sc.next();
				System.out.println("Enter Salary:");
				double salary=sc.nextDouble();
				System.out.println("Enter Age");
				int age=sc.nextInt();
				Emp.setId(id);
				Emp.setName(name);
				Emp.setSalary(salary);
				Emp.setAge(age);
				dao.createEmployee(Emp);
				break;
				
			case 2:
				dao.showAllEmployee();
				break;
				
			case 3:
				System.out.println("Enter id to show the details of the employee:");
				int empid=sc.nextInt();
				dao.showEmployeebasedId(empid);
				break;
				
			case 4:
				System.out.println("Enter id to update the details of the student:");
				int empid1=sc.nextInt();
				System.out.println("Enter the new name of the student");
				String name1=sc.next();
				dao.updateEmployee(empid1, name1);
				break;
				
			case 5:
				System.out.println("Enter id to delete the details from employee");
				int id1=sc.nextInt();
				dao.deleteEmployee(id1);
				break;
				
			case 6:
				System.out.println("Thank you for using these application...");
				System.exit(0);
				
				default:
					System.out.println("Enter valid choice");
			}
			
		}while(true);

	}

}
