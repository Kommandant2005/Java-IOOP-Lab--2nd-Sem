import java.util.Scanner;

public class Salary {
	public static void main(String[] args) {
		var scanner = new Scanner(System.in);
		
		System.out.print("Enter time worked in hours: ");
		int timeWorked  = scanner.nextInt();
		int baseRate=500;
		double salary;
		if(timeWorked<=40) {
			salary = timeWorked * baseRate;
		}	
		else {
			salary = timeWorked * baseRate + (timeWorked - 40) * (baseRate * 0.5);
		}
		
		System.out.println("Your salary is "+salary);
	}
}