/*
 * For given a 9-digit registration number of a CSE student, identify the year of 
joining. Assuming the first two digits specify the year of joining
 */
import java.util.Scanner;
public class YearOfJoining {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Your Registration Number");
		long reg_no=scanner.nextLong();
		while(reg_no>100) {
			reg_no/=10;
		}
		if(reg_no<25) {
			reg_no+=2000;
		}
		else {
			reg_no+=1900;
		}
		System.out.println("The year of joining is "+reg_no);
	}

}
