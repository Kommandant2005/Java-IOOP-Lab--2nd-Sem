import java.util.Scanner;
class ArrayManipulation{
	Scanner scanner = new Scanner(System.in);
	int arr[] = new int[10];
	void input() {
		for(int i=0;i<10;i++) {
			arr[i]=scanner.nextInt();
		}
	}
	void display() {
		for(int i=0;i<10;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	void maxDisplay() {
		int max=arr[0];
		for(int i=0;i<10;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		System.out.println(max);
	}
	void avg() {
		int sum=0;
		for(int i=0;i<10;i++) {
			sum+=arr[i];	
		}
		double 	average=sum/10;
		System.out.println(average);
	}
	void sort() {
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(arr[i]<arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}
}
public class Array {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayManipulation array = new ArrayManipulation();
		while(true) {
			System.out.println("1.Input Values");
			System.out.println("2.Display Values");
			System.out.println("3.Display the largest value");
			System.out.println("4.Display the average");
			System.out.println("5.Sort the Array");
			System.out.println("6.Exit");
			System.out.println("Enter Choice");
			int choice=scanner.nextInt();
			switch(choice) {
				case 1:
					array.input();
					break;
				case 2:
					array.display();
					break;
				case 3:
					array.maxDisplay();
					break;
				case 4:
					array.avg();
					break;
				case 5:
					array.sort();
					break;
				case 6:
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Choice");
					break;
			}
		scanner.close();
		}
	}
}
