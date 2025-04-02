import java.util.Scanner;
public class ElectricityBill {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the daily consumption of 7 days");
		int arr[] = new int[7];
		for(int i=0;i<7;i++) {
			arr[i]=scanner.nextInt();
		}
		double bill=0;
		for(int i=0;i<7;i++) {
			int rem=arr[i]/100;
			 switch(rem) {
			 	case 0:
			 		bill+=arr[i]*7;
			 		break;
			 	case 1:
			 		bill+=(arr[i]-100)*8+100*7;
			 		break;
			 	default:
			 		bill+=(arr[i]-200)*10+100*8+10*7;
			 		break;
			 }
		}
		System.out.println("Your Bill is "+bill);
	}

}
