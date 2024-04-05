import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Reservation {
    private static int reservationCounter = 1;
    private int reservationId;
    private String passengerName;
    private String trainNumber;
    private String classType;
    private String journeyDate;
    private String source;
    private String destination;

    public Reservation(String passengerName, String trainNumber, String classType, String journeyDate, String source, String destination) {
        this.reservationId = reservationCounter++;
        this.passengerName = passengerName;
        this.trainNumber = trainNumber;
        this.classType = classType;
        this.journeyDate = journeyDate;
        this.source = source;
        this.destination = destination;
    }

    public int getReservationId() {
        return reservationId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getClassType() {
        return classType;
    }

    public String getJourneyDate() {
        return journeyDate;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }
}

public class OnlineReservationSystem {
    private List<Reservation> reservations = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        OnlineReservationSystem system = new OnlineReservationSystem();
        system.run();
    }

    public void run() {
        while (true) {
            System.out.println("Online Reservation System");
            System.out.println("1. Make a Reservation");
            System.out.println("2. List Reservations");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    makeReservation();
                    break;
                case 2:
                    listReservations();
                    break;
                case 3:
                    cancelReservation();
                    break;
                case 4:
                    System.out.println("Thank You for using the program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void makeReservation() {
        System.out.print("Passenger Name: ");
        String passengerName = sc.nextLine();
        System.out.print("Train Number: ");
        String trainNumber = sc.nextLine();
        System.out.print("Class Type: ");
        String classType = sc.nextLine();
        System.out.print("Journey Date: ");
        String journeyDate = sc.nextLine();
        System.out.print("Source: ");
        String source = sc.nextLine();
        System.out.print("Destination: ");
        String destination = sc.nextLine();

        Reservation reservation = new Reservation(passengerName, trainNumber, classType, journeyDate, source, destination);
        reservations.add(reservation);
        System.out.println("Reservation created with ID: " + reservation.getReservationId());
    }

    public void listReservations() {
        System.out.println("List of Reservations:");
        for (Reservation reservation : reservations) {
            System.out.println("Reservation ID: " + reservation.getReservationId());
            System.out.println("Passenger Name: " + reservation.getPassengerName());
            System.out.println("Train Number: " + reservation.getTrainNumber());
            System.out.println("Class Type: " + reservation.getClassType());
            System.out.println("Journey Date: " + reservation.getJourneyDate());
            System.out.println("Source: " + reservation.getSource());
            System.out.println("Destination: " + reservation.getDestination());
            System.out.println("------------------------------------------------");
        }
    }

    public void cancelReservation() {
        System.out.print("Enter Reservation ID to cancel: ");
        int reservationId = sc.nextInt();
        sc.nextLine();  
        boolean removed = false;

        for (Reservation reservation : reservations) {
            if (reservation.getReservationId() == reservationId) {
                reservations.remove(reservation);
                removed = true;
                System.out.println("Reservation with ID " + reservationId + " has been canceled.");
                break;
            }
        }

        if (!removed) {
            System.out.println("Reservation not found with ID " + reservationId);
        }
    }
}
