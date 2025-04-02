import java.util.Scanner;
public class Factorial {
	public static long fact(int n) {
		if(n==1) {
			return 1;
		}
		return n*fact(n-1);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number");
		int n = scanner.nextInt();
		long res = fact(n);
		System.out.println("The factorial is "+res);

	}

}
