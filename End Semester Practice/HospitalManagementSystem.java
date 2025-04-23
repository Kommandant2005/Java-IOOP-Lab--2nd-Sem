import java.util.*;

abstract class Persons {
    String name;
    int id;

    Persons(String name, int id) {
        this.name = name;
        this.id = id;
    }

    abstract void showDetails();
}

interface Contactable {
    String contactInfo();
}

class Patient extends Persons implements Contactable {
    String illness;
    int admittedDays;
    boolean isDischarged;

    Patient(String name, int id, String illness, int admittedDays, boolean isDischarged) {
        super(name, id);
        this.illness = illness;
        this.admittedDays = admittedDays;
        this.isDischarged = isDischarged;
    }

    public void showDetails() {
        System.out.println("Patient ID: " + id + ", Name: " + name + ", Illness: " + illness + ", Admitted Days: " + admittedDays + ", Discharged: " + isDischarged);
    }

    public String contactInfo() {
        return "Contact patient: " + name + " via hospital reception.";
    }
}

class Doctor extends Persons implements Contactable {
    String specialization;
    boolean availability;

    Doctor(String name, int id, String specialization, boolean availability) {
        super(name, id);
        this.specialization = specialization;
        this.availability = availability;
    }

    public void showDetails() {
        System.out.println("Doctor ID: " + id + ", Name: " + name + ", Specialization: " + specialization + ", Available: " + availability);
    }

    public String contactInfo() {
        return "Contact doctor: " + name + " via medical department.";
    }
}

class DuplicateIdException extends Exception {
    public DuplicateIdException(String message) {
        super(message);
    }
}

class Hospital {
    Patient[] patients = new Patient[100];
    Doctor[] doctors = new Doctor[50];
    int patientCount = 0;
    int doctorCount = 0;

    public void addPatient(Patient p) throws DuplicateIdException {
        for (int i = 0; i < patientCount; i++) {
            if (patients[i].id == p.id) {
                throw new DuplicateIdException("Patient with ID " + p.id + " already exists.");
            }
        }
        if (patientCount < patients.length) {
            patients[patientCount++] = p;
        } else {
            System.out.println("Patient list is full.");
        }
    }

    public void dischargePatient(int id) {
        for (int i = 0; i < patientCount; i++) {
            if (patients[i].id == id) {
                patients[i].isDischarged = true;
                System.out.println("Patient with ID " + id + " discharged.");
                return;
            }
        }
        System.out.println("Patient with ID " + id + " not found.");
    }

    public Patient[] getPatientsByIllness(String illness) {
        Patient[] result = new Patient[patientCount];
        int count = 0;
        for (int i = 0; i < patientCount; i++) {
            if (patients[i].illness.equalsIgnoreCase(illness)) {
                result[count++] = patients[i];
            }
        }
        return Arrays.copyOf(result, count);
    }

    public void sortPatientsByAdmittedDays() {
        Arrays.sort(patients, 0, patientCount, Comparator.comparingInt(p -> p.admittedDays));
        System.out.println("Patients sorted by admitted days.");
    }

    public Patient[] getAllPatients() {
        return Arrays.copyOf(patients, patientCount);
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hospital hospital = new Hospital();

        while (true) {
            System.out.println("\nMenu:\n1. Add Patient\n2. Discharge Patient\n3. View Patients by Illness\n4. Sort Patients by Admitted Days\n100. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name, ID, Illness, AdmittedDays, Discharged (true/false): ");
                    String name = sc.next();
                    int id = sc.nextInt();
                    String illness = sc.next();
                    int days = sc.nextInt();
                    boolean discharged = sc.nextBoolean();
                    try {
                        hospital.addPatient(new Patient(name, id, illness, days, discharged));
                        System.out.println("Patient added successfully.");
                    } catch (DuplicateIdException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter Patient ID to discharge: ");
                    hospital.dischargePatient(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter illness to filter: ");
                    Patient[] filtered = hospital.getPatientsByIllness(sc.next());
                    for (Patient p : filtered) p.showDetails();
                    break;
                case 4:
                    hospital.sortPatientsByAdmittedDays();
                    for (Patient p : hospital.getAllPatients()) p.showDetails();
                    break;
                case 100:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
