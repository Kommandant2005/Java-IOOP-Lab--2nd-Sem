package week4;

import java.util.Scanner;
class ArrayManipulation{
	Scanner scanner = new Scanner(System.in);
	int arr[];
	int n;
	ArrayManipulation(){
		System.out.println("Enter Array Size");
		n = scanner.nextInt();
		arr=new int[n];
	}
	ArrayManipulation(int num){
		n=num;
		arr=new int[n];
	}
	void input() {
		for(int i=0;i<n;i++) {
			arr[i]=scanner.nextInt();
		}
	}
	void display() {
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	void search(int key) {
		for(int i=0;i<n;i++) {
			if(arr[i]==key) {
				System.out.println("Element found at position "+(i+1));
			}
		}
	}
	void compare(ArrayManipulation array1,ArrayManipulation array2) {
		for(int i=0;i<n;i++) {
			if(array1.arr[i]!=array2.arr[i]) {
				System.out.println("Not Equal");
				return;
			}
		}
		System.out.println("Equal");
	}
}
public class Array {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayManipulation array1 = new ArrayManipulation();
		ArrayManipulation array2 = new ArrayManipulation();
		while(true) {
			System.out.println("1.Input Values");
			System.out.println("2.Display Values");
			System.out.println("3.Search an element");
			System.out.println("4.Compare");
			System.out.println("5.Exit");
			System.out.println("Enter Choice");
			int choice=scanner.nextInt();
			switch(choice) {
				case 1:
					array1.input();
					break;
				case 2:
					array1.display();
					break;
				case 3:
					System.out.println("Enter element to be searched");
					int num=scanner.nextInt();
					array1.search(num);
					break;
				case 4:
					array1.compare(array1,array2);
					break;
				case 5:
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Choice");
					break;
			}
		}
	}
}
