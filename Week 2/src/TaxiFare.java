/*
  A Taxi service offers a new service based on travel distance. Write a Java 
program to calculate the total distance traveled by considering the following 
charges. First 5 km = INR 10/km, Next 15 km = INR 8/km, Next 25 km = INR 
5/km
*/
import java.util.Scanner;
public class TaxiFare {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter distance travelled");
		double fare=scanner.nextInt();
		double distance=0;
		if(fare>170) {
			fare-=170;
			distance= 20 + fare/5;
		}
		else if(fare>50) {
			fare-=50;
			distance = 5+fare/8;
		}
		else if(fare>=0) {
			distance=fare/10;
		}
		System.out.println("Your Total Distance is "+distance);
		
	}

}
