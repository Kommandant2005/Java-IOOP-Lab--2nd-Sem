import java.util.*;
class Account{
	Scanner sc = new Scanner(System.in);
	String cname;
	long accNo;
	String typeOfAcc;
	double balance;
	Account(){
		System.out.println("Enter Customer Name");
		String cname = sc.nextLine();
		this.cname = cname;
		System.out.println("Enter Account Number");
		long accNo = sc.nextInt();
		this.accNo = accNo;
		System.out.println("Enter Starting Balance");
		double balance = sc.nextDouble();
		this.balance = balance;
	}
	void deposit() {
		System.out.println("Enter Amount to Deposit");
		double amnt = sc.nextDouble();
		balance+=amnt;
		display();
	}
	void withdraw() {
		System.out.println("Enter Amount to Withdraw");
		double amnt = sc.nextDouble();
		if(balance-amnt>=0) {
			balance-=amnt;	
			display();
		}
		else {
			System.out.println("Not Enough Balance");
			display();
		}
	}
	void display() {
		System.out.println("Current Balance is "+balance);
	}
	
}
class Currents extends Account{
	double minBalance = 1000;
	double serviceTax = 7.5;
	String typeOfAcc = "Currents";
	Currents(){
		super();
	}
	void checkBalance() {
		if(balance<minBalance) {
			balance = (100-serviceTax)*balance;
			System.out.println("Warning! Minimum Balance Threshold Crossed. Service Tax Applied");
			display();
		}
	}
	void withdraw() {
		System.out.println("Enter Amount to Withdraw");
		double amnt = sc.nextDouble();
		if(balance-amnt>=0) {
			balance-=amnt;
			display();
		}
		else {
			System.out.println("Not Enough Balance");
			display();
		}
		checkBalance();
	}
}
class Savings extends Account{
	double interest;
	String typeOfAcc = "Savings";
	Savings(){
		super();
		System.out.println("Enter Interest");
		double interest = sc.nextDouble();
		this.interest = interest;
	}
}
public class AccDetails {
	public static void main(String[] args) {
		Savings sav = new Savings();
		Currents curr = new Currents();	
		sav.deposit();
		curr.deposit();
		sav.withdraw();
		curr.withdraw(); 
	}
}
