import java.util.Scanner;

class Passenger {
    int passengerID;
    int age;
    double fare;

    Passenger(int passengerID, int age, double fare) {
        this.passengerID = passengerID;
        this.age = age;
        this.fare = fare;
    }
}

interface TrainOperations {
    void bookTicket(Passenger p) throws TrainFullException;
    void cancelTicket(int passengerID) throws PassengerNotFoundException;
    void displayTrainDetails();
}

class TrainFullException extends Exception {
    TrainFullException(String message) {
        super(message);
    }
}

class PassengerNotFoundException extends Exception {
    PassengerNotFoundException(String message) {
        super(message);
    }
}

abstract class Train implements TrainOperations {
    int trainNumber;
    String trainType;
    String source;
    String destination;
    String departureTime;
    Passenger[] passengers;
    int passengerCount = 0;

    Train(int trainNumber, String trainType, String source, String destination, String departureTime, int capacity) {
        this.trainNumber = trainNumber;
        this.trainType = trainType;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.passengers = new Passenger[capacity];
    }

    public void displayTrainDetails() {
        System.out.println("Train No: " + trainNumber + ", Type: " + trainType + ", From: " + source + " To: " + destination + " At: " + departureTime);
        System.out.println("Passengers:");
        for (int i = 0; i < passengerCount; i++) {
            System.out.println("  ID: " + passengers[i].passengerID + ", Age: " + passengers[i].age + ", Fare: " + passengers[i].fare);
        }
    }
}

class ExpressTrain extends Train {
    ExpressTrain(int trainNumber, String source, String destination, String departureTime, int capacity) {
        super(trainNumber, "Express", source, destination, departureTime, capacity);
    }

    public void bookTicket(Passenger p) throws TrainFullException {
        if (passengerCount >= passengers.length) {
            throw new TrainFullException("Train is full!");
        }
        passengers[passengerCount++] = p;
    }

    public void cancelTicket(int passengerID) throws PassengerNotFoundException {
        for (int i = 0; i < passengerCount; i++) {
            if (passengers[i].passengerID == passengerID) {
                for (int j = i; j < passengerCount - 1; j++) {
                    passengers[j] = passengers[j + 1];
                }
                passengers[--passengerCount] = null;
                return;
            }
        }
        throw new PassengerNotFoundException("Passenger not found!");
    }
}
class LocalTrain extends Train {
    LocalTrain(int trainNumber, String source, String destination, String departureTime, int capacity) {
        super(trainNumber, "Local", source, destination, departureTime, capacity);
    }

    public void bookTicket(Passenger p) {
        if (passengerCount < passengers.length) {
            passengers[passengerCount++] = p;
        } else {
            System.out.println("Train is full. Cannot book ticket.");
        }
    }

    public void cancelTicket(int passengerID) throws PassengerNotFoundException {
        for (int i = 0; i < passengerCount; i++) {
            if (passengers[i].passengerID == passengerID) {
                for (int j = i; j < passengerCount - 1; j++) {
                    passengers[j] = passengers[j + 1];
                }
                passengers[--passengerCount] = null;
                return;
            }
        }
        throw new PassengerNotFoundException("Passenger not found!");
    }
}
public class TrainReservationSystem {
    static Train[] trains = new Train[10];
    static int trainCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nTrain Reservation System");
            System.out.println("1. Add Train");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Display Train Details");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter train number: ");
                        int tno = sc.nextInt();
                        sc.nextLine();
                        boolean exists = false;
                        for (int i = 0; i < trainCount; i++) {
                            if (trains[i].trainNumber == tno) {
                                exists = true;
                                break;
                            }
                        }
                        if (exists) {
                            System.out.println("Train already exists with number: " + tno);
                            break;
                        }

                        System.out.print("Enter type (Express/Local): ");
                        String type = sc.nextLine();
                        System.out.print("Enter source: ");
                        String src = sc.nextLine();
                        System.out.print("Enter destination: ");
                        String dest = sc.nextLine();
                        System.out.print("Enter departure time: ");
                        String time = sc.nextLine();
                        System.out.print("Enter capacity: ");
                        int cap = sc.nextInt();

                        trains[trainCount++] = type.equalsIgnoreCase("Express") ?
                                new ExpressTrain(tno, src, dest, time, cap) :
                                new LocalTrain(tno, src, dest, time, cap);

                        System.out.println("Train added successfully.");
                        break;

                    case 2:
                        System.out.print("Enter train number: ");
                        int trainNo = sc.nextInt();
                        Train t = null;
                        for (int i = 0; i < trainCount; i++) {
                            if (trains[i].trainNumber == trainNo) {
                                t = trains[i];
                                break;
                            }
                        }
                        if (t == null) {
                            System.out.println("Train not found!");
                            break;
                        }
                        System.out.print("Enter passenger ID: ");
                        int pid = sc.nextInt();
                        System.out.print("Enter age: ");
                        int age = sc.nextInt();
                        System.out.print("Enter fare: ");
                        double fare = sc.nextDouble();
                        t.bookTicket(new Passenger(pid, age, fare));
                        break;

                    case 3:
                        System.out.print("Enter train number: ");
                        int trNo = sc.nextInt();
                        Train tr = null;
                        for (int i = 0; i < trainCount; i++) {
                            if (trains[i].trainNumber == trNo) {
                                tr = trains[i];
                                break;
                            }
                        }
                        if (tr == null) {
                            System.out.println("Train not found!");
                            break;
                        }
                        System.out.print("Enter passenger ID to cancel: ");
                        int cancelId = sc.nextInt();
                        tr.cancelTicket(cancelId);
                        break;

                    case 4:
                        for (int i = 0; i < trainCount; i++) {
                            trains[i].displayTrainDetails();
                        }
                        break;

                    case 5:
                        System.out.println("Exiting system.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (TrainFullException | PassengerNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
                sc.nextLine(); // clear buffer
            }
        }
    }
}
