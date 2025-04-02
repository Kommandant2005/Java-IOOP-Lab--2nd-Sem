package week5;
import java.util.*;
class ShoppingCart{
	Scanner sc = new Scanner(System.in);
	Item[] cart_list = new Item[100];
	int item_count=0;
	double total;
	class Item{
		String itemName;
		int quantity;
		double price;
		Item(String itemName,int quantity,double price){
			this.itemName=itemName;
			this.price=price;
			this.quantity=quantity;
		}
	}

	void addItem() {
		if(item_count==cart_list.length){
			System.out.println("Can't Enter More Items");
		}
		else {
			System.out.println("Enter Item Name: ");
			String name=sc.next();
			System.out.println("Enter Item Price: ");
			double price=sc.nextDouble();
			System.out.println("Enter Item Quantity: ");
			int quantity=sc.nextInt();
			cart_list[item_count]=new Item(name,quantity,price);
			item_count++;
		}
	}
	void display() {
		for(int i=0;i<item_count;i++) {
			System.out.println("Product Name: "+cart_list[i].itemName);
			System.out.println("Product Quantity: "+cart_list[i].quantity);
			System.out.println("Product Price: "+cart_list[i].price);
			System.out.println();
		}
		System.out.println("The Total Bill is "+total);
		System.out.println();
	}
	void tally() {
		for(int i=0;i<item_count;i++) {
			this.total+=(cart_list[i].price * cart_list[i].quantity);
		}
	}
}
public class Shop {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ShoppingCart cart = new ShoppingCart();
		while(true) {
			System.out.println("Enter 1 to add item or 0 to display cart or -1 to exit");
			int choice=sc.nextInt();
			switch(choice) {
				case 1:
					cart.addItem();
					break;
				case 0:
					cart.tally();
					cart.display();
					break;
				case -1:
					System.exit(0);
				default:
					System.out.println("Enter Valid Input");
			}
		}
	}

}
