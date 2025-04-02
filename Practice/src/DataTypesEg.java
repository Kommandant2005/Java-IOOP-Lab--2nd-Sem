import java.util.Scanner;
public class DataTypesEg {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter your age: ");
		int age = scanner.nextInt();
		
		System.out.print("Enter your price: ");
		double price = scanner.nextDouble();
		
		System.out.print("Enter your grade: ");
		char grade = scanner.next().charAt(0);
		
		System.out.print("Enter whether you passed or not: ");		
		System.out.print("Enter your name: ");
		scanner.nextLine();//Consume leftover space in the same line
		String name = scanner.nextLine();
		
		System.out.println("Hello "+name+", you passed with grade "+grade+" and have a price "+price+" at an age of "+age);
		
	}

}
