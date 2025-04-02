import java.util.*;

class Student{
	Scanner sc = new Scanner(System.in);
	String sname;
	int sid;
	int cMarks,pMarks,mMarks;
	
	Student(String sname, int sid,int cMarks , int mMarks , int pMarks){
		this.sname = sname;
		this.sid = sid;
		this.cMarks=cMarks;
		this.pMarks=pMarks;
		this.mMarks=mMarks;
	}
	double total;
	double avg;
	void display() {
		System.out.println(sname+" has scored a total of "+total+" with an average amounting to "+avg);		
	}
	void compute() {
		total = 0;
		total+= mMarks;
		total+=pMarks;
		total+=cMarks;
		avg=total/3;
	}
}
class ScienceStudent extends Student{
	int practicalMarks ; 
	ScienceStudent(String sname, int sid,int pracMarks,int cMarks , int mMarks , int pMarks) {
		super(sname, sid,cMarks ,mMarks,pMarks);
		this.practicalMarks = pracMarks;
	}
	void compute() {
		total = 0;
		total+= mMarks;
		total+=pMarks;
		total+=cMarks;
		total+=practicalMarks;
		avg=total/4;
	}
	void displayPracticalMarks() {
		System.out.println(sname+" has scored "+practicalMarks+" in practicals");			
	}
}
class ArtsStudent extends Student{
	String electiveSubject ; 
	ArtsStudent(String sname, int sid, String elective,int cMarks , int mMarks , int pMarks) {
		super(sname, sid, cMarks, mMarks, pMarks);
		this.electiveSubject = elective;
 	}
	void displayElective() {
		System.out.println(sname+" has opted for "+electiveSubject);					
	}
}
public class StdDetails {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student std = new Student("Shreya",106,10,20,30);
		ScienceStudent scistud = new ScienceStudent("Param",102,90,20,30,40);
		ArtsStudent artstud = new ArtsStudent("Manish",104,"Psychology",30,40,50);
		std.compute();
		scistud.compute();
		artstud.compute();
		std.display();
		scistud.display();
		artstud.display();
		sc.close();
	}
}