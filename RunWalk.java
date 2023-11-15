/*
 * This is where the Run/Walk variables are at
 */
public class RunWalk extends Exercise {
    private double distance;
/**
 * These are where the specific other data is located at
 * @param name
 * @param dateStr
 * @param duration
 * @param distance
 */
    public RunWalk(String name, String dateString, int duration, double distance) {
        super(name, dateString, duration);
        this.distance = distance;
    }

    /**
     * will return that specific distance
     * @return
     */
    public double getDistance() {
        return distance;
    }

    
    /**
     * This will get the specific distance
     * @param distance
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    /**
     * This is where the name will be grabbed from
     */
    public String getNameOfExercise() {
        return "Run/Walk";
    }

    @Override
    /**
     * This calculate the calories burned in running/walking
     */
    public double getCaloriesBurned() {
        return (distance / getDuration()) * 9000;
    }
}