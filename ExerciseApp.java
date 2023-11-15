/*
 * This class will ask the user for what they want for exercising 
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Has the where the exercies is at and the scanner
 */
public class ExerciseApp {
    private static List<Exercise> exercises = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    
    /**
     * Will ask the user for which option they want and will go through the steps of what they put in
     * If they enter 1 will go through adding an exercise to the list
     * If they enter 2 will ask for a file and will print the exercise in there
     * If they enter 3 will print the exercise by date
     * If they enter 4 will print the exercise by calories
     * If 5 will end the program and thank the user
     * If anything not 1-5 will tell them it not available and re-enter an option
     * If not even a integer they will ask to enter a integer
     * @param args
     */
    public static void main(String[] args) {
    	printWelcomeBanner();
        boolean quit = false;
        while (!quit) {
            printMenu();
            System.out.print("Enter the number of your choice: ");

            while (!sc.hasNextInt()) {
                sc.next(); 
                System.out.print("You needed to enter an integer. Try again. ");
            }
            int userChoice = sc.nextInt();

            if (userChoice == 1) {
                addExercise();
            } else if (userChoice == 2) {
                saveExercisesToFile();
            } else if (userChoice == 3) {
                listExercisesByDate();
            } else if (userChoice == 4) {
                listExercisesByCalories();
            } else if (userChoice == 5) {
                quit = true;
            } else {
                System.out.println("Invalid choice. Try again. ");
            }
        }
        System.out.println("Congratulations on staying in shape!");
    }

    /**
     * Prints the menu out for the user to pick from
     */
    private static void printMenu() {
        System.out.println("These are your choices:");
        System.out.println("1. Add an exercise");
        System.out.println("2. Print exercises to file");
        System.out.println("3. List sorted by date");
        System.out.println("4. List sorted by calories burned");
        System.out.println("5. Exit");
    }
    
    /**
     * Prints the banner that welcomes the user
     */
    public static void printWelcomeBanner(){
		System.out.println("*".repeat(75));
		System.out.println(" ".repeat(30) + "Exercise Tracker");
		System.out.println("*".repeat(75));
		System.out.println();
	}

    
    /**
     * Will ask the user for the type of exercise they want and will ask a serious of question that will relate to what have have picked
     * After that will add that to a list of what they have put in. 
     */
    private static void addExercise() {
        System.out.print("Enter R for run/walk, W for weightlifting, or C for rock climbing: ");
        String userType = sc.next().toUpperCase();
        System.out.print("Enter a name for the workout: ");
        String name = sc.next();
        System.out.print("Enter date of workout (MM/dd/yyyy): ");
        String date = sc.next();
        System.out.print("How long did you work out in minutes: ");
        int duration = sc.nextInt();

        Exercise exercise = null;

        if ("R".equals(userType)) {
            System.out.print("Enter distance you ran or walked in miles: ");
            double distance = sc.nextDouble();
            exercise = new RunWalk(name, date, duration, distance);
        } else if ("W".equals(userType)) {
            System.out.print("Enter total weight lifted in pounds: ");
            double weight = sc.nextDouble();
            exercise = new WeightLifting(name, date, duration, weight);
        } else if ("C".equals(userType)) {
            System.out.print("Enter the height of the wall in feet: ");
            double height = sc.nextDouble();
            System.out.print("Enter number of times you climbed it: ");
            int repetitions = sc.nextInt();
            exercise = new RockClimbing(name, date, duration, height, repetitions);
        } else {
            System.out.println("Invalid exercise type entered!");
            return;
        }

        if (exercise != null) {
            exercises.add(exercise);
            System.out.println("Exercise added.");
        }
    }

    /**
     * This will ask the user for a file and if they can print the file then will tell them they were successful and not will tell them it failed
     */
    private static void saveExercisesToFile() {
        System.out.print("Enter the filename to save exercises: ");
        String fileName = sc.next();
        boolean isSuccess = ExerciseWriter.writeToFile(exercises, fileName);

        if (isSuccess) {
            System.out.println("Your exercises were written to the file.");
        } else {
            System.out.println("Failed to write exercises to file");
        }
    }

    /**
     * Will sort the exercises by dates
     */
    private static void listExercisesByDate() {
        Collections.sort(exercises);
        ExerciseWriter.printOnScreen(exercises);
    }
    
    /**
     * Will sort the exercises by calories
     */
    private static void listExercisesByCalories() {
        Collections.sort(exercises, new ExerciseCompareByCalories());
        ExerciseWriter.printOnScreen(exercises);
    }
}



