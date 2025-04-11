import java.util.*;
class CourseFullException extends Exception
{
 private String courseName; private int capacity;
 public CourseFullException(String courseName,int capacity)
 {this.courseName=courseName; this.capacity=capacity;}
 public String toString()
 {return "CourseFullException: Course '"+courseName+"' is full. Capacity: "+capacity;}
}

class Course
{
 private String courseName; private int capacity; private int enrolledStudents;
 public Course(String courseName, int capacity)
 {
   this.courseName=courseName; this.capacity=capacity;
   enrolledStudents=0;
 }
 public void enrollStudent() throws CourseFullException
 {
  if(enrolledStudents>=capacity) throw new CourseFullException(courseName,capacity);
  enrolledStudents++;
  System.out.println("Student enrolled in "+courseName+". Total enrolled: "+enrolledStudents+"\n");
 }
}

class CourseCapacityDemo
{
 public static void main(String args[])
 {
   Scanner sc=new Scanner(System.in);
   System.out.print("Enter course name: "); String name=sc.nextLine();
   System.out.print("Enter capacity of course: "); int c=sc.nextInt();
   Course co=new Course(name,c);
   for(int i=0;i<c+2;i++)
   {
     try{co.enrollStudent();}
     catch(CourseFullException x)
     {
       System.out.println("Capacity of "+c+" reached. Further enrollment not possible.");
       System.exit(0);
     }
   }
 }
}
