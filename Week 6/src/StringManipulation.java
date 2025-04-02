import java.util.*;

class StringFunctions{
	Scanner sc = new Scanner(System.in);
	String mainString;
	String revString;
	String totalString;
	String sortedString;
	StringFunctions(){
		System.out.println("Enter String");
		mainString = sc.next();
		System.out.println("Original String: " +mainString);
	}
	void reverse() {
		revString="";
		char ch[] = mainString.toLowerCase().toCharArray();
		for(int i=ch.length-1;i>=0;i--) {
			revString += ch[i];
		}
		System.out.println("Reversed String: " +revString);
	}
	boolean checkPalindrome() {
		revString="";
		char ch[] = mainString.toLowerCase().toCharArray();
		for(int i=ch.length-1;i>=0;i--) {
			revString += ch[i];
		}
		if(mainString.toLowerCase().equals(revString)) {
			return true;
		}
		return false;
	}
	void concatenate() {
		totalString = mainString + revString;
		System.out.println("Concatenated String: " +totalString);
	}
	void sort() {
		int len = mainString.length();
		char ch[] = mainString.toCharArray();
		for(int i = 0 ; i<len-1 ; i++) {
			for( int j = 0 ;j<len-i-1;j++) {
				if(ch[j]>ch[j+1]) {
					char temp = ch[j];
					ch[j] = ch[j+1];
					ch[j+1]=temp;
				}
			}
		}
		sortedString = new String(ch);
		System.out.println("Sorted String: " +sortedString);
	}	
}
public class StringManipulation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringFunctions str = new StringFunctions();
		while(true) {
			System.out.println("1. Check Palindrome");
			System.out.println("2. Reverse String");
			System.out.println("3. Sort String");
			System.out.println("4. Concatenate");
			System.out.println("5. Exit");
			int choice = sc.nextInt();
			switch(choice) {
				case 1:
					boolean x = str.checkPalindrome();
					if(x) {
						System.out.println("Palindrome");
					}
					else {
						System.out.println("Not a Palindrome");
					}
					break;
				case 2:
					str.reverse();
					break;
				case 3:
					str.sort();
					break;
				case 4:
					str.concatenate();
					break;
				case 5:
					System.exit(0);
				default:
					System.out.println("Enter Valid Choice");
			}
		}
	}
}
