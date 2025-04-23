import java.util.*;
interface Bookable {
    void bookTickets(String customerName, int numberOfSeats) throws SeatsNotAvailableException;
}
class SeatsNotAvailableException extends Exception {
    public SeatsNotAvailableException(String message) {
        super(message);
    }
}
class CinemaScreen implements Bookable {
    protected int screenNumber;
    protected String movieName;
    protected int totalSeats;
    protected int availableSeats;

    public CinemaScreen(int screenNumber, String movieName, int totalSeats) {
        this.screenNumber = screenNumber;
        this.movieName = movieName;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public void bookTickets(String customerName, int numberOfSeats) throws SeatsNotAvailableException {
        if (numberOfSeats > availableSeats) {
            throw new SeatsNotAvailableException("Booking failed for " + customerName +
                    " as mentioned no of seats aren't available");
        } else {
            availableSeats -= numberOfSeats;
            System.out.println("Booking confirmed for " + customerName + " on Screen " + screenNumber +
                    " (" + movieName + "). Seats booked = " + numberOfSeats);
        }
    }

    public void display() {
        System.out.println("Screen " + screenNumber + " - Movie: " + movieName +
                " | Total Seats: " + totalSeats + " | Available Seats : " + availableSeats);
    }
}
class ScreenOne extends CinemaScreen {
    public ScreenOne(String movieName, int totalSeats) {
        super(1, movieName, totalSeats);
    }
}
class ScreenTwo extends CinemaScreen {
    public ScreenTwo(String movieName, int totalSeats) {
        super(2, movieName, totalSeats);
    }
}
public class CinemaScreenSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter movie name for Screen 1: ");
        String movie1 = sc.nextLine();
        System.out.print("Enter total seats for Screen 1: ");
        int seats1 = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter movie name for Screen 2: ");
        String movie2 = sc.nextLine();
        System.out.print("Enter total seats for Screen 2: ");
        int seats2 = sc.nextInt();
        sc.nextLine();

        ScreenOne screen1 = new ScreenOne(movie1, seats1);
        ScreenTwo screen2 = new ScreenTwo(movie2, seats2);

        System.out.println();
        screen1.display();
        screen2.display();
        System.out.println();

        try {
            screen1.bookTickets("Alice", 10);
        } catch (SeatsNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        try {
            screen2.bookTickets("John", 30);
        } catch (SeatsNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        try {
            screen2.bookTickets("Tom", 60);
        } catch (SeatsNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        screen1.display();
        screen2.display();

        sc.close();
    }
}
