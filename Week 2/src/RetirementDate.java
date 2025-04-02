import java.util.Scanner;
public class RetirementDate {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter date of birth in ddmmyyyy format");
		long dob=scanner.nextLong();
		System.out.println("Enter age of joining");
		int age=scanner.nextInt();
		dob=dob+(60);
		System.out.println("The retirement date is "+dob);
	}

}
