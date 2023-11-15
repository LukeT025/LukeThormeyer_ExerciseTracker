/*
 * This class is used for print out the exercise for users or printing them to a file
 */
import java.io.FileWriter;
import java.util.List;


public class ExerciseWriter {
	
	/**
	 * This will go through each exercises and will right them out in the file give my user in Exerciseapp
	 * if they can find the file will return there was a problem
	 * @param exercises
	 * @param fileName
	 */
    public static boolean writeToFile(List<Exercise> exercises, String fileName) {
    	boolean success = false;
        try (FileWriter fw = new FileWriter(fileName)) {
            for (Exercise exercise : exercises) {
                fw.write(exercise.toString() + "\n");
                success = true;
            }
        } catch (Exception ex) {
            success = false;
        }
		return success;
		
    }
    /**
     * Will go through each exercises and print them out in the format of the toSting in the Exercise class
     * @param exercises
     */
    public static void printOnScreen(List<Exercise> exercises) {
        for (Exercise exercise : exercises) {
            System.out.println(exercise.toString());
        }
    }
}