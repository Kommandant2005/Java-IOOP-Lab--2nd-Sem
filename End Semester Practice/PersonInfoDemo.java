import java.util.Scanner;
interface PersonInfo{
    void displayInfo();
}
abstract class Person {
    String name;
    int id;
    String rollInfo;
    Person(String name,int id){
        this.name=name;
        this.id=id;
    }
    abstract void showRole();
}
class Student extends Person implements PersonInfo{
    int year;
    String course;
    Student(String name, int id,String course,int year) {
        super(name, id);
        this.course=course;
        this.year=year;
        rollInfo="Student";
    }
    @Override
    void showRole() {
        System.out.println("Roll Info: "+rollInfo);
    }
    @Override
    public void displayInfo() {
        System.out.println("Name : "+name);
        System.out.println("Id: "+id);
        System.out.println("Course: "+course);
        System.out.println("Year: "+year);
        showRole();
    }
}
class Faculty extends Person implements PersonInfo{
    String designation;
    String specialisation;
    Faculty(String name, int id,String designation,String specialisation) {
        super(name, id);
        this.specialisation=specialisation;
        this.designation=designation;
        rollInfo="Faculty";
    }

    @Override
    void showRole() {
        System.out.println("Roll Info: "+rollInfo);
    }

    @Override
    public void displayInfo() {
        System.out.println("Name : "+name);
        System.out.println("Id: "+id);
        System.out.println("Designation: "+designation);
        System.out.println("Specialisation: "+specialisation);
        showRole();
    }
}
class Department{
    String departmentName;
    Student[] student;
    Faculty[] faculty;
    Department(Student[] student,Faculty[] faculty) {
        this.student = student;
        this.faculty = faculty;
    }
}
class PersonInfoDemo{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students");
        int ns = sc.nextInt();
        System.out.println("Enter number of faculties");
        int nf = sc.nextInt();
        Student[] students = new Student[ns];
        Faculty[] faculties = new Faculty[nf];
        for(int i=0;i<ns;i++){
            System.out.println("Enter Student Name");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Enter Student ID");
            int id = sc.nextInt();
            System.out.println("Enter Student Course");
            sc.nextLine();
            String course = sc.nextLine();
            System.out.println("Enter Year");
            int year = sc.nextInt();
            students[i]=new Student(name,id,course,year);
        }
        for(int i=0;i<nf;i++){
            System.out.println("Enter Faculty Name");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Enter Faculty ID");
            int id = sc.nextInt();
            System.out.println("Enter Faculty Designation");
            sc.nextLine();
            String designation = sc.nextLine();
            System.out.println("Enter Faculty Specialisation");
            sc.nextLine();
            String spec = sc.nextLine();
            faculties[i]=new Faculty(name,id,designation,spec);
        }
        Department dept = new Department(students,faculties);

        System.out.println("--------Students--------");
        for(Student std:dept.student){
            std.displayInfo();
        }
        System.out.println("--------Faculties--------");
        for(Faculty fac : dept.faculty){
            fac.displayInfo();
        }
    }
}