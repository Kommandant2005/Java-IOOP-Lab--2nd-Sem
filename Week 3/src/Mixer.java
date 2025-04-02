import java.util.Scanner;
class ArrayMani{
	Scanner scanner = new Scanner(System.in);
	int arr[];
	void accept() {
		int n=scanner.nextInt();
		arr=new int[n];
		System.out.println("Enter Non Duplicate Array");
		for(int i=0;i<n;i++) {
			arr[i]=scanner.nextInt();
		}
	}	
	void display() {
		for(int i=0;i<10;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
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
public class Mixer {
	public static void main(String[] args) {
		ArrayMani arr1 = new ArrayMani();
		arr1.accept();
		arr1.sort();
		arr1.display();
	}
}
