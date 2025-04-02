import java.util.*;

class EmpDetails{
	Scanner sc = new Scanner(System.in);
	String Ename[];
	String Email[];
	int Eid[];
	double[] Basic,Net_Sal;
	double DA,Gross_Sal,IT;
	int n;
	Department[] dept;

	EmpDetails(int num){
		n=num;
		dept = new Department[n];
		String dep,loc;
		Basic=new double[n];
		Ename=new String[n];
		Eid=new int[n];
		Email = new String[n];
		Net_Sal=new double[n];
		System.out.println("Enter Employee Names");
		for(int i=0;i<n;i++) {
			Ename[i] = sc.nextLine();
		}
		System.out.println("Enter Employee Id");
		for(int i=0;i<n;i++) {
			Eid[i] = sc.nextInt();
		}
		System.out.println("Enter Employee Basic Salary");
		for(int i=0;i<n;i++) {
			Basic[i] = sc.nextInt();
		}
		System.out.println("Enter Department Info");
		for(int i=0;i<n;i++) {
			System.out.println("Enter Departement Name");
			dep=sc.next();
			System.out.println("Enter Departement Location");
			loc=sc.next();
			dept[i]=new Department(dep,loc);

		}
		
	}
	class Department{
		String departmentName;
		String location;
		Department(String departmentName,String location){
			this.departmentName=departmentName;
			this.location=location;
		}
		void setDepartment(String departmentName,String location) {
			this.departmentName=departmentName;
			this.location=location;
		}
		void displayDepartment() {
			System.out.println("Department Name: "+departmentName);
			System.out.println("Location: "+location);
			System.out.println();
		}
	}
	
	void display() {
		for(int i=0;i<n;i++) {
			System.out.println(Ename[i]+" has a net salary of "+Net_Sal[i]+" and is available at "+Email[i]);
			dept[i].displayDepartment();
		}
	}
	void compute_net_sal() {
		for(int i=0;i<n;i++) {
			DA = 0.52*Basic[i];
			Gross_Sal= Basic[i]+DA;
			IT=0.3*Gross_Sal;
			Net_Sal[i]=Gross_Sal-IT;
		}
	}
	void generateEmail() {
		for(int i=0;i<n;i++) {
			String name=Ename[i];
			String[] temp = name.toLowerCase().split(" ");
			String email = "";
			char[] ch = temp[0].toCharArray();
			email+=ch[0];
			email+=temp[1];
			email+="@gmail.com";
			Email[i]=email;
		}
		
	}
	void formatEmployeeName() {
		for(int i=0;i<n;i++) {
			String[] words = Ename[i].toLowerCase().split(" ");
			String temp = "";
			for(String word:words) {
				char ch[] = word.toCharArray();
				ch[0] = (char) (ch[0]-32);
				String temp_word = new String(ch);
				temp = temp  + temp_word + " ";				
			}
			Ename[i]=temp.trim();			
		}
	}
}
public class Employee {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of employees");
		int n =sc.nextInt();
		EmpDetails emp_temp_new = new EmpDetails(n);
		emp_temp_new.formatEmployeeName();
		emp_temp_new.generateEmail();
		emp_temp_new.compute_net_sal();
		emp_temp_new.display();
		sc.close();
	}
}
