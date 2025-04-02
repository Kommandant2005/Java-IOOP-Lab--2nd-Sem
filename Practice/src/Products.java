import java.util.Scanner;
public class Products {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of products");
		int n=scanner.nextInt();
		
		String[ ] prodNames = new String[n];
		double[] prodPrices = new double[n];
		int[] prodQuantity = new int [n];
		
		for(int i=0;i<n;i++) {
			System.out.println("Enter product name: ");
			scanner.nextLine();
			prodNames[i]=scanner.nextLine();
			System.out.println("Enter product price: ");
			prodPrices[i]=scanner.nextDouble();
			System.out.println("Enter product quantity: ");
			prodQuantity[i]=scanner.nextInt();
		}
		double totalBill=0;
		System.out.println("Enter 1 if you want to purchase product or 0");
		for(int i=0;i<n;i++) {
			int choice,quantity;
			System.out.println("Do you want to buy "+prodNames[i]);
			choice = scanner.nextInt();
			if(choice==0) {
				continue;
			}
			else {
				System.out.println("Enter quantity: ");
				quantity=scanner.nextInt();
				if(quantity > prodQuantity[i]) {
					System.out.println("Low Stock");
					System.out.println("Current Stock "+prodQuantity[i]);
					System.out.println("Enter a valid qauntity");
					quantity=scanner.nextInt();
				}
				totalBill+=prodPrices[i]*quantity;
				}
			}
	
	System.out.println("TotalBill is "+totalBill);
	
	}

}
