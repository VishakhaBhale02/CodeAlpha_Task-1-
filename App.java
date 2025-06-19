import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner (System.in);
        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Double> studentsGrade = new ArrayList<>();

        System.out.println("===== Student Grade Tracker =====");
        boolean running = true;

        while(running) {
            System.out.println("\n1.Add Student \n2.Show Summary Report \n3.Exit");
            System.out.println("Choose an option :");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 : {
                    System.out.println("Enter student name :");
                    String name = scanner.nextLine();
                    System.out.println("Enter grade (0 - 100) :");
                    double grade = scanner.nextDouble();
                    studentNames.add(name);
                    studentsGrade.add(grade);
                    System.out.println("Student added.");
                }
                break;

                case 2 : {
                    if (studentNames.isEmpty()){
                        System.out.println("No student data available.");
                    }else {
                        showSummary(studentNames,studentsGrade);
                    }
                }
                break;

                case 3 : {
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                } 
                break;
                default : {
                    System.out.println("Invalid choice.");
                }
            }
            scanner.close();
        }
    }

    private static void showSummary(ArrayList<String> names, ArrayList<Double> grades) {
        System.out.println("\n ===== Summary Report =====");
        double total = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;
        int highestIndex = 0;
        int lowestIndex = 0;
        
        for (int i = 0; i < grades.size(); i++) {
            double grade = grades.get(i);
            total += grade;

            if (grade > highest) {
                highest = grade;
                highestIndex = i;
            }
            if (grade < lowest) {
                lowest = grade;
                lowestIndex = i;
            }
        }
        double average = total / grades.size();

        System.out.printf("Total Students : %d\n",grades.size());
        System.out.printf("Average Grade : %.2f\n",average);
        System.out.printf("Highest Grade : %.2f(%s\n)",highest,names.get(highestIndex));
        System.out.printf("Lowest Grade : %.2f(%s)\n",lowest,names.get(lowestIndex));

        System.out.println("\n ===== Students Grades =====");
        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%s : %.2f\n",names.get(i),grades.get(i));
        }
    }
}   
