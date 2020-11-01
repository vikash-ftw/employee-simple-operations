package assignment;

import java.util.Arrays;
import java.util.Scanner;

public class TesterEmployee {
	public static Scanner scn = new Scanner(System.in);    //static scanner 
	private static Employee[] emp;   // static employee array but size is not fixed here
	
	public static void addEmployee() {
		boolean isAdded = false;   // first set employee added to false
		for (int i =0;i<emp.length;i++) {
			if(emp[i]==null && !isAdded) {  // checking 1.emp[i] must be empty  2.employee must not be added in previous loop itr 
				// why 2nd condition ? --- bcz we don't want to add multiple employees is single function call.
				System.out.println("Enter Name, basicPay, experience :: ");
				String name = scn.next();
				double bsPay = scn.nextDouble();
				int exp = scn.nextInt();
				System.out.println("Enter the no. of skills :: ");
				String[] skill = new String[scn.nextInt()];
				System.out.println("Enter skills :: ");
				for (int j = 0; j<skill.length ; j++) {
					skill[j]=scn.next();
				}
				System.out.println("Enter the no. of projects :: ");
				String[] project = new String[scn.nextInt()];
				System.out.println("Enter projects :: ");
				for (int k = 0; k<project.length ; k++) {
					project[k]=scn.next();
				}
				
				emp[i] = new Employee(name , bsPay, skill,project,exp);
				System.out.println("Added Employee successfully !!");
				System.out.println("Generated EmpId = "+emp[i].getEmpId());
				isAdded = true;     // set true bcz employee is added
			}
		}
		if (!isAdded) {       // check if employee is added or not ....still false it means no space left to add.
			System.out.println("Employee database is full ....no space left");
		}
	}
	
	public static void modifyEmployee() {
		System.out.println("\nEnter the employee id:: ");
		int id = scn.nextInt();
		boolean notF = true;       // set notFound to be true 
		String menu = "\n1. Modify name"
				+"\n2. Modify basicPay"
				+"\n3. Modify experience"
				+"\n4. Modify skill set"
				+"\n5. Modify project set";
		for (int i = 0; i < emp.length; i++) {
			if(emp[i]!=null && (emp[i].getEmpId()== id)) {
				emp[i].showDetails();
				System.out.println(menu);   // display modify menu
				int uchoice = scn.nextInt();
				switch (uchoice) {
				case 1:{
					System.out.println("Enter name:: ");
					emp[i].setName(scn.next());
					break;
				}
				case 2:{
					System.out.println("Enter basic salary:: ");
					emp[i].setBasic(scn.nextDouble());
					break;
				}
				case 3:{
					System.out.println("Enter Experience:: ");
					emp[i].setExperience(scn.nextInt());
				}
				case 4:{
					System.out.println("Enter the no. of skills:: ");
					int size = scn.nextInt();
					String[] skills = new String[size];
					System.out.println("Enter skills ---");
					for(int j=0; j<skills.length; j++) {
						skills[j]=scn.next();
					}
					emp[i].setSkill(skills);
					break;
				}
				case 5:{
					System.out.println("Enter the no. of projects completed:: ");
					int size = scn.nextInt();
					String[] projects = new String[size];
					System.out.println("Enter skills ---");
					for(int j=0; j<projects.length; j++) {
						projects[j]=scn.next();
					}
					emp[i].setProject(projects);;
					break;
				}
				}
				notF = false;          // since employee is found ...set notFound to false 
			}
		}
		if(notF) {      // check the notFound status
			System.out.println("Emp Id not found !!");
		}
	}
	
	public static void deleteEmployee() {
		System.out.println("Enter Employee id:: ");
		int id = scn.nextInt();
		boolean notF = true;       // set notFound to be true
		for(int i =0; i<emp.length; i++) {
			if(emp[i]!=null && (emp[i].getEmpId()==id)) {
				emp[i].showDetails();
				emp[i] = null;
				System.out.println("Employee deleted Successfully!");
				notF =false;      // since employee is found and deleted ...set it to false
			}
		}
		if (notF) {   // check the notFound status
			System.out.println("Emp Id not found !!");
		}		
	}
	
	public static void searchEmployee() {
		String subMenu = "\nSearch Function --------" + "\n1. id" + "\n2. name" + "\n3. skill" + "\n4. project name"
				+ "\n5. back to Main Menu";
		
		boolean flag = true;     // boolean flag to control and display the search menu option  ....init set true
		while (flag) {    // check flag status
		
			System.out.println(subMenu);   // display searchBy menu
			int subC = scn.nextInt();

			switch(subC) {
			
			case (1):{
				System.out.println("Enter empId:: ");
				int empId = scn.nextInt();
				boolean notF = true;   // set notFound to true
				for(int i = 0 ; i<emp.length;i++) {
					if(emp[i]!=null && emp[i].getEmpId() == empId) {
						emp[i].showDetails();
						notF =false;      // since employee is matched and found ...set it to false
					}
				}
				if (notF) {   // check status
					System.out.println("EmpId does not exist");
				}
				break;
			}
			case (2):{
				System.out.println("Enter Name:: ");
				String name = scn.next();
				boolean notF = true;
				for(int i = 0 ; i<emp.length;i++) {
					if(emp[i]!=null && emp[i].getName().equalsIgnoreCase(name)) {
						emp[i].showDetails();
						notF = false;
					}
				}
				if (notF) {
					System.out.println("Emp Name does not exist");
				}
				break;
			}
			case (3):{
				System.out.println("Enter skill:: ");
				String skill = scn.next();
				boolean notF = true;
				for(int i = 0 ; i<emp.length;i++) {
			
					if(emp[i]!=null) {
						String[] skArr = emp[i].getSkill();   // getting the reference of the particular employee skill array and storing it in local array   
						for (String e : skArr) {                 
							if(e.equalsIgnoreCase(skill)) {
								emp[i].showDetails();            
								notF = false;
							}
						}
					}
				

				}
				if (notF) {
					System.out.println("Skill is not matching with any emloyees !!");
				}
				break;
			}
			case (4):{
				System.out.println("Enter project Name:: ");
				String proj = scn.next();
				boolean notF=true;
				for(int i = 0 ; i<emp.length;i++) {
					if(emp[i]!=null) {
						String[] pjArr = emp[i].getProject();  //  getting the reference of the particular employee project array and storing it in local array   
						for (String e : pjArr) {
							if(e.equalsIgnoreCase(proj)) {
								emp[i].showDetails();
								notF = false;
							}
						}
					}
				}
				if (notF) {
					System.out.println("Project is not matching with any employee !!");
				}
				break;
			}
			case (5) : {
				System.out.println("Going back to main menu -----------");  
				flag = false;  // setting the loop flag to false  bcz we no more want the loop to be executed
				break;
			}

			}

		}
	}
	
	public static double calTotalSalary() {
		double total = 0.0;   // creating a local var to add salary total of all employees
		for(int i = 0; i < emp.length; i++) {
			if(emp[i]!=null) {
				total+=emp[i].calSalary();  // adding here
			}
		}
		return total;   // return the total of salary of double type
	}
	
	
	public static void displayEmp() {
		System.out.println("All details of employee ---------------");
		boolean empty = true;  // setting the empty flag true
		
		System.out.printf("%8s %20s %15s %50s %50s %20s","EmpId","Name","BasicSalary","Skills","Projects","Experience");  //title tabs
		System.out.println("");
		for(int i =0 ; i<emp.length;i++) {
			if(emp[i]!=null) { 
				// data display
				System.out.printf("%8d %20s %15.2f %50s %50s %20d", 
						           emp[i].getEmpId(),emp[i].getName(),emp[i].getBasic(),Arrays.toString(emp[i].getSkill()),
						           Arrays.toString(emp[i].getProject()),
						           emp[i].getExperience());
				System.out.println("");
				empty = false;  // setting it to false ...bcz we found atleast one entry of employee
			}
		}
		if (empty) {  // checking empty status
			System.out.println("There are no employees in database!");
		}
	}
	

	
	// MAIN method
	public static void main(String[] args) {
		
		String mainMenu = "\n------------------------------------------------" + "\n1. Add Employee"
				+ "\n2. Modify Employee Details" + "\n3. Delete an Employee" + "\n4. Display all Employees"
				+ "\n5. Search specific Employee" + "\n6. Calulate Salary of all Employees" + "\n7. Exit"
				+ "\n------------------------------------------------";

		System.out.println("Enter no. of employees:: ");
		emp = new Employee[scn.nextInt()];
		
		while (true) {   // running in a infinite loop ... so condition is set to be true always
			int choice = 0;
			System.out.println(mainMenu);  // display menu
			System.out.println("Your Choice :: ");
			choice = scn.nextInt();

			switch (choice) {
			case (1): {
				addEmployee();  // summon addEmployee()
				break; 
			}
			case (2): {
				modifyEmployee();  // summon modifyEmployee()
				break;
			}
			case (3): {
				deleteEmployee();  // summon deleteEmployee()
 				break;
			}
			
			case (4):{    // display details of all employees
				displayEmp();  // summon displayEmp()  
				break;
			}
			case (5):{
				searchEmployee();  // summon searchEmployee()
				break;
			}
			case (6):{
				System.out.println("Total salary of all employees = "+calTotalSalary());   // display total salary of all employees
				break;
			}
			case (7):{
				System.out.println("Thanks --- good BYE!! --------");
				System.exit(0);   // program exit point ...and execution ends here
				
			}
			}

		}
	}

}
