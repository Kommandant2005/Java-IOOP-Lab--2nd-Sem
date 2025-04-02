import java.util.*;

class Employee{
	String ename;
	double grossSal;
	double netSalary;
	Employee(String en,double gsal){
		ename = en;
		grossSal = gsal;
	}
	void compute() {
		netSalary = 0.7*grossSal;
	}
	void display() {
		System.out.println("Name: "+ename);
		System.out.println("Salary: "+netSalary);
		System.out.println();
	}
}
class PartTimeEmployee extends Employee{
	int hours;
	static final double rate = 100;
	PartTimeEmployee(String en,int hours) {
		super(en, 0);
		this.hours = hours;
	}
	void compute() {
		netSalary = hours*rate;
	}
	void display() {
		System.out.println("Name: "+ename);
		System.out.println("Salary: "+netSalary);
		System.out.println("Hourly Rate: "+hours);
		System.out.println("Hours Worked: "+rate);
		System.out.println();
	}
}
class FullTimeEmployee extends Employee{
	int bonus;
	int deductions;
	FullTimeEmployee(String en,double gsal,int b,int d) {
		super(en, gsal);
		this.bonus = b;
		this.deductions=d;
	}
	void compute() {
		netSalary = 0.7*grossSal + bonus - deductions;
	}
	void display() {
		System.out.println("Name: "+ename);
		System.out.println("Salary: "+netSalary);
		System.out.println("Bonus: "+bonus);
		System.out.println("Deductions: "+deductions);
		System.out.println();
	}
}
public class EmpDetails {
	public static void main(String[] args) {
		Employee e1 = new Employee("Param",10000);
		PartTimeEmployee e2 = new PartTimeEmployee("Manish",200);
		FullTimeEmployee e3 = new FullTimeEmployee("Shreya",20000,2000,100);
		e1.compute();
		e2.compute();
		e3.compute();
		e1.display();
		e2.display();
		e3.display();		
	}
}
