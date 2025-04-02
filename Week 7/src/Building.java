import java.util.*;
class BuildingType{
	Scanner sc = new Scanner(System.in);
	BuildingType(){
		System.out.println("Enter number of storeys");
		int st = sc.nextInt();		
		System.out.println("Enter square footage");
		int sq = sc.nextInt();
		this.squareFoots=sq;
		this.storey=st;
	}
	int storey;
	double squareFoots;
	void display() {
		System.out.println("The building has "+storey+" number of storeys and has a square footage of "+squareFoots);
	}
}
class School extends BuildingType{
	int noOfClassrooms;
	String grade;
	School(){
		super();
		System.out.println("Enter number of classrooms");
		int no = sc.nextInt();		
		System.out.println("Enter school grade");
		String grd = sc.next();
		this.noOfClassrooms=no;
		this.grade=grd;		
	}
	void display() {
		System.out.println("The building has "+storey+" number of storeys and has a square footage of "+squareFoots+".");
		System.out.println("The building has "+noOfClassrooms+" number of classrooms and cater to students of "+grade+" grade.");
	}
}
class House extends BuildingType{
	int noOfBedrooms;
	int noOfBathrooms;
	House(){
		super();
		System.out.println("Enter number of bedrooms");
		int no1 = sc.nextInt();		
		System.out.println("Enter number of bathrooms");
		int no2 = sc.nextInt();
		this.noOfBedrooms=no1;
		this.noOfBathrooms=no2;		
	}
	void display() {
		System.out.println("The building has "+storey+" number of storeys and has a square footage of "+squareFoots+".");
		System.out.println("The building has "+noOfBedrooms+" number of bedrooms and has "+noOfBathrooms+" number of bathrooms.");
	}
}

class Building {
	public static void main(String[] args) {
		System.out.println("Enter Building Details");
		BuildingType bldtype = new BuildingType();
		System.out.println("Enter House Details");
		House house = new House();
		System.out.println("Enter School Details");
		School school = new School();
		BuildingType temp;
		temp = bldtype;
		temp.display();
		System.out.println();
		temp = house;
		temp.display();
		System.out.println();
		temp = school;
		temp.display();
	}
}
