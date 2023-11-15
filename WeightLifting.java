/*
 * This is where the Weight Lifting variables are at
 */
public class WeightLifting extends Exercise {
    private double totalWeight;
    
    
    /**
     * These are where the specific other data is located at
     * @param name
     * @param dateStr
     * @param duration
     * @param totalWeight
     */
    public WeightLifting(String name, String dateString, int duration, double totalWeight) {
        super(name, dateString, duration);
        this.totalWeight = totalWeight;
    }

    @Override
    /**
     * This is where the name will be grabbed from
     */
    public String getNameOfExercise() {
        return "WeightLifting";
    }

    @Override
    /**
     * This calculate the calories burned in weight lifting
     */
    public double getCaloriesBurned() {
        return (totalWeight / duration) * 50;
    }

    /**
     * will return the total weight
     * @return
     */
    public double getTotalWeight() {
        return totalWeight;
    }
    /**
     * will get the specific total weight
     * @param totalWeight
     */
    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }
}