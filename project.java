import java.util.ArrayList;
import java.util.Scanner;

class Feedback {

    int id;
    String customerName;
    String message;
    int rating;

    Feedback(int id, String customerName, String message, int rating) {
        this.id = id;
        this.customerName = customerName;
        this.message = message;
        this.rating = rating;
    }

    public String toString() {
        return "\nFeedback ID : " + id +
               "\nCustomer    : " + customerName +
               "\nRating      : " + rating +
               "\nMessage     : " + message + "\n";
    }
}

public class project{

    static ArrayList<Feedback> feedbacks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n========== Customer Feedback System ==========");
            System.out.println("1. Add Feedback");
            System.out.println("2. View Feedbacks");
            System.out.println("3. Generate Report");
            System.out.println("4. Search Customer");
            System.out.println("5. Exit");
            System.out.print("Choose Option : ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addFeedback();
                    break;

                case 2:
                    showFeedbacks();
                    break;

                case 3:
                    generateReport();
                    break;

                case 4:
                    searchCustomer();
                    break;

                case 5:
                    System.out.println("Program Closed.");
                    break;

                default:
                    System.out.println("Invalid Option.");
            }

        } while (choice != 5);
    }

    static void addFeedback() {

        System.out.print("Enter Feedback ID : ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Customer Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Feedback Message : ");
        String msg = sc.nextLine();

        System.out.print("Enter Rating (1-5) : ");
        int rating = sc.nextInt();

        feedbacks.add(new Feedback(id, name, msg, rating));

        System.out.println("Feedback Added Successfully.");
    }

    static void showFeedbacks() {

        if (feedbacks.isEmpty()) {
            System.out.println("No Feedback Available.");
            return;
        }

        System.out.println("\n========== Feedback Records ==========");

        for (Feedback f : feedbacks) {
            System.out.println(f);
        }
    }

    static void generateReport() {

        if (feedbacks.isEmpty()) {
            System.out.println("No Data Available.");
            return;
        }

        int total = 0;

        for (Feedback f : feedbacks) {
            total += f.rating;
        }

        double average = (double) total / feedbacks.size();

        System.out.println("\n========== Feedback Report ==========");
        System.out.println("Total Feedbacks : " + feedbacks.size());
        System.out.println("Average Rating  : " + average);

        if (average >= 4) {
            System.out.println("Overall Review  : Excellent");
        } else if (average >= 3) {
            System.out.println("Overall Review  : Good");
        } else {
            System.out.println("Overall Review  : Needs Improvement");
        }
    }

    static void searchCustomer() {

        System.out.print("Enter Customer Name : ");
        String name = sc.nextLine();

        boolean found = false;

        for (Feedback f : feedbacks) {

            if (f.customerName.equalsIgnoreCase(name)) {
                System.out.println(f);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Customer Feedback Not Found.");
        }
    }
}