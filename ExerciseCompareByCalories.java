/*
 * This class will compare each exercies by calories
 */
import java.util.Comparator;


public class ExerciseCompareByCalories implements Comparator<Exercise> {
	
    @Override
    /**
     * Will go through each exercise and compare the calories
     */
    public int compare(Exercise e1, Exercise e2) {
        return Double.compare(e1.getCaloriesBurned(), e2.getCaloriesBurned());
    }
}