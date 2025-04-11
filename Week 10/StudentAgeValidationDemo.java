import java.util.*;
class Student
{
 private String name; private int age;
 public Student(String name, int age)
 {this.name=name; this.age=age;}

 public void registerStudent(String name, int age)
 {
   if(!(age>18 && age<60)) throw new IllegalArgumentException();
 }
}

public class StudentAgeValidationDemo
{
 public static void main(String args[])
 {
   Scanner sc=new Scanner(System.in);
   System.out.print("Enter student name: "); String n=sc.nextLine();
   System.out.print("\nEnter student age: "); int a=sc.nextInt();
   Student s=new Student(n,a);
   try{s.registerStudent(n,a);}
   catch(IllegalArgumentException A)
  {
    System.out.println("Invalid age input! Must be between 18 and 60.\nRegistration failed.");
    System.exit(0);
  }
  System.out.println("Registration successful.");
 }
}
