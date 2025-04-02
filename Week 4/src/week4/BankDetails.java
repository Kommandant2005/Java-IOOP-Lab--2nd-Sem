package week4;
import java.util.Scanner;
class BankAcc{
	Scanner sc = new Scanner(System.in);
	String name;
	int AccNo;
	String type;
	double balance;
	static double interest=10.45;
	BankAcc(){
		name=null;
		AccNo=-1;
		type=null;
		balance=0;
	}
	BankAcc(String sname,int sAccNo,String stype,double sbalance){
		name=sname;
		AccNo=sAccNo;
		type=stype;
		balance=sbalance;
	}
	static void display_rate() {
		System.out.println("The interest rate is "+interest);
	}
	void Deposit() {
		System.out.println("Enter Amount to Deposit");
		double amnt = sc.nextDouble();
		balance += amnt;
		System.out.println("The new balance is "+balance);
	}
	void Withdraw() {
		System.out.println("The current balance is "+balance);
		System.out.println("Enter Amount to be Withdrawn: ");
		double amnt = sc.nextDouble();
		if(amnt>balance) {
			System.out.println("Insufficient Balance");
		}
		else {
			balance-=amnt;
			System.out.println("Withdrawal Successful!");
			System.out.println("New Balance is "+balance);
		}
	}
	void display() {
		System.out.println("Account Holder Name: "+name);
		System.out.println("Account Number: "+AccNo);
		System.out.println("Account Type: "+type);
		System.out.println("Account Balance: "+balance);
		
	}
}
public class BankDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		//BankAcc acc = new BankAcc();
		BankAcc acc = new BankAcc("Param",243445,"PF",23000);
		while(true) {
			System.out.println("1.Deposit");
			System.out.println("2.Withdraw");
			System.out.println("3.Display Account Details");
			System.out.println("4.Display Interest Rate");
			System.out.println("5.Exit");
			System.out.println("Enter Choice");
			int choice=scanner.nextInt();
			switch(choice) {
				case 1:
					acc.Deposit();
					break;
				case 2:
					acc.Withdraw();
					break;
				case 3:
					acc.display();
					break;
				case 4:
					BankAcc.display_rate();
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
