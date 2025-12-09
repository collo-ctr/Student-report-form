import java.util.Scanner;
/*
 * Student Grade Tracker.
 * Its primary function is to
 *  collect
 *  process
 *  display academic records
 * for a class of 15 students, calculating their overall performance and class statistics.
 *
 *  */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //School details
        System.out.print("Enter  the school name: ");
        String schoolName = sc.nextLine();

        System.out.print("Enter  the teacher's name: ");
        String teacherName = sc.nextLine();

        System.out.print("Enter your grade: ");
        String grade = sc.nextLine();

        System.out.print("Enter year of study: ");
        int year = sc.nextInt();
        sc.nextLine();

        // Arrays for 15 Students
        int n = 15;

        String[] names = new String[n]; // array for student names

        //arrays for each of the six subjects
        double[] english = new double[n];
        double[] math = new double[n];
        double[] history = new double[n];
        double[] geography = new double[n];
        double[] science = new double[n];
        double[] programming = new double[n];


        double[] totals = new double[n]; //array to store the totals
        char[] ranks = new char[n]; //array to store the final ranks

        // initialize the totals per subject to 0
        double totalEnglish = 0, totalMath = 0, totalHistory = 0;
        double totalGeography = 0, totalScience = 0, totalProgramming = 0;

        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;


        //  Input Student Records
        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Name: ");
            names[i] = sc.nextLine();

            System.out.print("English: ");
            english[i] = sc.nextDouble();

            System.out.print("Math: ");
            math[i] = sc.nextDouble();

            System.out.print("History: ");
            history[i] = sc.nextDouble();

            System.out.print("Geography: ");
            geography[i] = sc.nextDouble();

            System.out.print("Science: ");
            science[i] = sc.nextDouble();

            System.out.print("Programming: ");
            programming[i] = sc.nextDouble();

            sc.nextLine(); // clear buffer

            // Keeping track of totals per subject so that we be able to calculate the average per subject later on
            totalEnglish += english[i];
            totalMath += math[i];
            totalHistory += history[i];
            totalGeography += geography[i];
            totalScience += science[i];
            totalProgramming += programming[i];

            //  Computation
            totals[i] = english[i] + math[i] + history[i] + geography[i] + science[i] + programming[i];

            if (totals[i] >= 540.0) {
                ranks[i] = 'A';
            } else if (totals[i] >= 480.0) {
                ranks[i] = 'B';
            } else if (totals[i] >= 420.0) {
                ranks[i] = 'C';
            } else if (totals[i] >= 360.0) {
                ranks[i] = 'D';
            } else {
                ranks[i] = 'F';
            }
            // switch statement to increment the class counters, to track the overall grade distribution
            switch (ranks[i]) {
                case 'A': countA++; break;
                case 'B': countB++; break;
                case 'C': countC++; break;
                case 'D': countD++; break;
                case 'F': countF++; break;
            }


        }

        // Average per subject
        double avgEnglish = totalEnglish / n;
        double avgMath = totalMath / n;
        double avgHistory = totalHistory / n;
        double avgGeography = totalGeography / n;
        double avgScience = totalScience / n;
        double avgProgramming = totalProgramming / n;


        // Formatted output
        System.out.println("\n" + "-".repeat(90));
        System.out.println("                    School Name: " + schoolName);
        System.out.println("                    Teacher: " + teacherName);
        System.out.println("                    Grade: " + grade);
        System.out.println("                    Year: " + year);
        System.out.println("=".repeat(90));

        // For header part
        System.out.printf("%-15s %8s %8s %8s %8s %8s %12s %8s %6s%n",
                "Student", "English", "Math", "History", "Geography", "Science", "Programming", "Total", "Rank");
        System.out.println("=".repeat(90));

        // Student Records
        for (int i = 0; i < n; i++) {
            System.out.printf("%-15s %8.2f %8.2f %8.2f %8.2f %8.2f %12.2f %8.2f %6c%n",
                    names[i], english[i], math[i], history[i], geography[i],
                    science[i], programming[i], totals[i], ranks[i]);
        }

        // Totals for the subjects
        System.out.println("-".repeat(90));
        System.out.printf("%-15s %8.2f %8.2f %8.2f %8.2f %8.2f %12.2f %8.2f%n",
                "", totalEnglish, totalMath, totalHistory,
                totalGeography, totalScience, totalProgramming,
                (totalEnglish + totalMath + totalHistory + totalGeography + totalScience + totalProgramming));

        // Average for the subjects
        System.out.println("-".repeat(90));
        System.out.printf("%-15s %8.2f %8.2f %8.2f %8.2f %8.2f %12.2f %8.2f%n",
                "", avgEnglish, avgMath, avgHistory,
                avgGeography, avgScience, avgProgramming,
                (avgEnglish + avgMath + avgHistory + avgGeography + avgScience + avgProgramming));

        //How the grades are distributed
        System.out.println("-".repeat(90));
        System.out.printf("                    Ranks       A's: %d     B's: %d     C's: %d     D's: %d     F's: %d%n",
                countA, countB, countC, countD, countF);
        System.out.println("-".repeat(90));

        sc.close();



    }
}