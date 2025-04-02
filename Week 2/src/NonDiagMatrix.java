import java.util.Scanner;
public class NonDiagMatrix {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of rows");
		int n=scanner.nextInt();
		int a[][] = new int[n][n];
		System.out.println("Enter elements");
		int sum=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				a[i][j]=scanner.nextInt();
				sum+=a[i][j];
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j | i==j-n-1 | i==n-j-1) {
					sum-=a[i][j];
				}
			}
		}
		System.out.println("The sum of non diagonal elements is "+sum);
	}

}
