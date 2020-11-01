package assignment;

import java.util.Arrays;

public class Employee {
	private int empId;
	private String name;
	private double basic;
	private String[] skill;
	private String[] project;
	private int experience;
	

	static int idCount;
	static {
		idCount  = 101;   // initializing static variable
	}
	
	// constructors
	Employee(){
		this.empId = idCount;
		idCount++;    // increment the empId count for next Employee Object
	}
	
	Employee(String name, double basic, String[] skill, String[] project, int experience){
		this.empId = idCount;
		idCount++;
		this.name = name;
		this.basic = basic;
		this.skill = new String[skill.length];
		for(int i = 0 ; i<skill.length;i++) {
			this.skill[i] = skill[i];
		}
		this.project =new String[project.length];
		for(int i = 0 ; i<project.length;i++) {
			this.project[i] = project[i];
		}
		
		this.experience = experience;
	}
	
	// getters and setters
	public int getEmpId() {
		return empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	public String[] getSkill() {
		return skill;
	}

	public void setSkill(String[] skill) {
		this.skill = new String[skill.length];   // setting length according to the skill array in tester
		for (int i = 0 ; i<skill.length;i++) {   // deep copy
			this.skill[i] = skill[i];
		}
			
	}

	public String[] getProject() {
		return project;
	}

	public void setProject(String[] project) {
		this.project = new String[project.length]; 
		for (int i = 0 ; i<project.length;i++) {
			this.project[i] = project[i];
		}
	}
	
	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	//data methods 
	public double calSalary() {
		return this.basic+(this.project.length * 5000) ;  // bonus of every project added to salary
	}
	
	public void showDetails() {      // will print every detail of employee on newLine
		System.out.println("");
		System.out.println("EmpId = "+this.empId);
		System.out.println("Name = "+this.name);
		System.out.println("Basic Salary = "+this.basic);
		System.out.println("Skills = "+Arrays.toString(this.skill));
		System.out.println("Projects = "+Arrays.toString(this.project));
		System.out.println("Experience = "+this.experience);
		System.out.println("");
	}
	
	public String getDetails() {   // will return all details in a single row
		return "[  "+this.empId+" : "+this.name+" : "+this.basic+" : "+Arrays.toString(this.skill)+" : "+Arrays.toString(this.project)+" : "+this.experience+"  ]";
	}
	
	
	
}
