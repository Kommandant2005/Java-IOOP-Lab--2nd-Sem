import java.util.Scanner;

public class BitWiseAdd {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter first number: ");
		int a = scanner.nextInt();
		System.out.print("Enter second number: ");
		int b = scanner.nextInt();
		while(b!=0) {
			int  carry = a&b;
			a=a^b;
			b=carry<<1;
		}
		System.out.println(a);
		if(a%2==0) {
			System.out.println("Even Number");
		}
		else {
			System.out.println("Odd Number");
		}
	}

}
