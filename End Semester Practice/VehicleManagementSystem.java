//Question 1: Vehicle System (Moderate)
//Topics: Interface, Abstract Class, Inheritance, Exception Handling
//Design a Java application for a Vehicle Management System.
//- Create an interface Serviceable with method void serviceDetails().
//- Create an abstract class Vehicle with fields String model, int year, and an abstract method void
//displayDetails().
//- Create classes Car and Bike that extend Vehicle and implement Serviceable.
//- Each class should override methods and display full info.
//- In the main class, create an array of Vehicle objects and use try-catch blocks to handle invalid
//input (e.g., year cannot be negative).

import java.util.Scanner;

interface Serviceable{
    void serviceDetails() throws YearCannotBeNegative;
}
abstract class Vehicle{
    String model;
    int year;

    public Vehicle(int year, String model) {
        this.year = year;
        this.model = model;
    }

    void displayDetails(){
        System.out.println("Model Name: "+model);
        System.out.println("Year Of Manufacturing: "+year);
    }
}
class Car extends Vehicle implements Serviceable{
    int gears;
    boolean servicedBefore;

    public Car(int year, String model, boolean servicedBefore, int gears) {
        super(year, model);
        this.servicedBefore = servicedBefore;
        this.gears = gears;
    }

    @Override
    public void serviceDetails() throws YearCannotBeNegative {
        if(year<=0){
            throw new YearCannotBeNegative("Years Can't be negative ");
        }
        displayDetails();
        System.out.println("Gears: "+gears);
        System.out.println("Serviced Before: "+servicedBefore);
    }
}
class Bike extends Vehicle implements Serviceable{
    int gears;
    boolean servicedBefore;
    public Bike(int year, String model, int gears, boolean servicedBefore) {
        super(year, model);
        this.gears = gears;
        this.servicedBefore = servicedBefore;
    }
    @Override
    public void serviceDetails() throws YearCannotBeNegative {
        if(year<=0){
            throw new YearCannotBeNegative("Years Can't be negative ");
        }
        displayDetails();
        System.out.println("Gears: "+gears);
        System.out.println("Serviced Before: "+servicedBefore);
    }
}
class YearCannotBeNegative extends Exception{
    public YearCannotBeNegative(String message){
        super(message);
    }
}
public class VehicleManagementSystem {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Cars");
        int noc = sc.nextInt();
        System.out.println("Enter number of Bikes");
        int nob = sc.nextInt();
        Car[] car = new Car[noc];
        Bike[] bike = new Bike[nob];
        for(int i=0;i<noc;i++){
            System.out.println("Enter Car Name");
            String model = sc.nextLine();
            System.out.println("Enter Car Year");
            int year = sc.nextInt();
            System.out.println("Enter Car Gear");
            int gears = sc.nextInt();
            System.out.println("Is Car Serviced Before");
            boolean servicedBefore = sc.nextBoolean();
            car[i] = new Car(year,model,servicedBefore,gears);
        }
        for(int i=0;i<nob;i++){
            System.out.println("Enter Car Name");
            String model = sc.nextLine();
            System.out.println("Enter Car Year");
            int year = sc.nextInt();
            System.out.println("Enter Car Gear");
            int gears = sc.nextInt();
            System.out.println("Is Car Serviced Before");
            boolean servicedBefore = sc.nextBoolean();
            bike[i] = new Bike(year,model,gears,servicedBefore);
        }
        for(Car c:car){
            try {
                c.serviceDetails();
            } catch (YearCannotBeNegative e) {
                System.out.println("\nException on invalid year: " + e.getMessage());
            }
        }
        for(Bike b:bike){
            try {
                b.serviceDetails();
            } catch (YearCannotBeNegative e) {
                System.out.println("\nException on invalid year: " + e.getMessage());
            }
        }
    }
}
