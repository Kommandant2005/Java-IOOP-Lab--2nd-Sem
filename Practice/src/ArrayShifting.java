import java.util.Scanner;
public class ArrayShifting {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of elements");
		int n= scanner.nextInt();
		int arr[]= new int[n];
		System.out.println("Enter the values");
		for(int i=0;i<n;i++) {
			arr[i]=scanner.nextInt();
		}
		System.out.println("Enter 1 to rotate left");
		System.out.println("Enter 2 to rotate right");
		int choice = scanner.nextInt();
		System.out.println("Enter no of rotations");
		int r = scanner.nextInt();
		switch(choice) {
		case 2:
			for(int i=0;i<r;i++) {
				int temp=arr[0];
				for(int j=1;j<n;j++) {
					arr[j-1]=arr[j];
				}
				arr[n-1]=temp;
			}
			break;
		case 1:
			for(int i=0;i<r;i++) {
				int temp=arr[n-1];
				for(int j=n-1;j>0;j--) {
					arr[j]=arr[j-1];
				}
				arr[0]=temp;
			}
			break;
		default:
			System.out.println("Enter valid choice");	
			break;
		}
		System.out.println("New Array");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
