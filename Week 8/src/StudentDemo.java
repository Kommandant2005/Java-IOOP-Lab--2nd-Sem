import java.util.Scanner;

class Student{
	Scanner sc = new Scanner(System.in);
	int RollNum;
	double marks[] = new double[5];
	public double[] getMarks() {
		return marks;
	}

	public void setMarks() {
		System.out.println("Enter The Marks");
		for(int i=0;i<5;i++) {
			marks[i] = sc.nextDouble();
		}
	}

	public int getRollNum() {
		return RollNum;
	}

	public void setRollNum() {
		System.out.println("Enter Roll Number");
		this.RollNum = sc.nextInt();
	}
}
interface Sports{
	void putSportsScore(double score);
}

class Result extends Student implements Sports{
	double sportsScore;
	@Override
	public void putSportsScore(double score) {
		this.sportsScore=score;
	}
	void displayResult() {
		double total=0;
		for(double mark:marks) {
			total+=mark;
		}
		total+=sportsScore;
		System.out.println("The total of the student at roll no "+ RollNum + " is "+total);
	}
}
public class StudentDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Result res = new Result();
		res.setRollNum();
		res.setMarks();
		System.out.println("Enter Sports Marks");
		double score = sc.nextDouble();
		res.putSportsScore(score);
		res.displayResult();
		sc.close();
	}
}
