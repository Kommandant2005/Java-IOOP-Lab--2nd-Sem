import java.util.*;

class Student{
	Scanner sc = new Scanner(System.in);
	String sname;
	String formattedSname;
	int sid;
	Subject[] subjects;
	int subjectCount;
	String initials;
	int num_studs;

	Student(String sname, int sid, int maxSubject,int num_studs){
		this.sname = sname;
		this.sid = sid;
		this.num_studs=num_studs;
		subjects = new Subject[maxSubject];

	}
	class Subject{
		String subjectName;
		int marks;
		Subject(String subjectName,int marks){
			this.subjectName=subjectName;
			this.marks=marks;
		}
		void setMarks(int marks) {
			this.marks=marks;
		}
		void displaySubject() {
			System.out.println("Subject: "+subjectName);
			System.out.println("Subject: "+marks);
		}	
	}
	void AddSubject() {
		System.out.println("Enter Subject Name: ");
		String subjectName=sc.next();
		System.out.println("Enter Subject Marks: ");
		int marks=sc.nextInt();
		if(subjectCount<subjects.length) {
			subjects[subjectCount]=new Subject(subjectName,marks);
			subjectCount++;
		}
		else {
			System.out.println("Can't Add Anymore Subjects");
		}
	}
	double total;
	double avg;
	void assign(String s,int maxSubject,int sid) {
		sname=s;
		subjects = new Subject[maxSubject];
		this.sid=sid;
	}
	void display() {
		System.out.println(sname+" has scored a total of "+total+" with an average amounting to "+avg);	
		System.out.println("Initials: " + initials );	
		System.out.println("Formatted Name: " + formattedSname );		
	}
	void compute() {
		total = 0;
		for(int i=0;i<subjects.length;i++) {
			total+=subjects[i].marks;
		}
		avg=total/subjects.length;
	}
	void removeWhitespace() {
		String temp ="";
		String name = sname.trim();
		String[] words = name.split(" ");
		for(String word:words) {
			temp+=word;
		}
		formattedSname=temp;
	}
	void extractInitials() {
		String temp="";
		String[] words = this.sname.toLowerCase().split(" ");
		for(String word:words) {
			char ch[] = word.toCharArray();
		 	temp+=(char)(ch[0]-32);
		}
		this.initials = temp;
	}
}
public class StdDetails {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of students");
		int num = sc.nextInt();
		sc.nextLine();
		Student[] std = new Student[num];
		for(int i=0;i<num;i++) {
			System.out.println("Enter Student Name: ");
			String sname=sc.nextLine();
			System.out.println("Enter Student Id: ");
			int sid=sc.nextInt();
			System.out.println("Enter Number of Subjects: ");
			int maxSubject=sc.nextInt();
			std[i] = new Student(sname,sid,maxSubject,num);	
			for(int j=0;j<maxSubject;j++) {
				std[i].AddSubject();			
			}
			std[i].extractInitials();
			std[i].removeWhitespace();
			std[i].compute();
			std[i].display();
			for(int j=0;j<maxSubject;j++) {
				std[i].subjects[j].displaySubject();			
			}
			System.out.println();
		}
		for(int k=0;k<num;k++) {
			System.out.println("Enter String");
			String search=sc.nextLine();
			boolean x = std[k].sname.contains(search);	
			if(x) {
				System.out.println("String Found");
				System.out.println("The String is found in "+std[k].sname);
			}
			else {
				System.out.println("String not found");
			}
		}

		sc.close();
	}
}
