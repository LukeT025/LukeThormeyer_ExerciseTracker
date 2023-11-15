/*
 * This is where the Rock Climbing variables are at
 */
public class RockClimbing extends Exercise {
    private double wallHeight;
    private int repetitions;

    
    /**
     * These are where the specific other data is located at
     * @param name
     * @param dateStr
     * @param duration
     * @param wallHeight
     * @param repetitions
     */
    public RockClimbing(String name, String dateString, int duration, double wallHeight, int repetitions) {
        super(name, dateString, duration);
        this.wallHeight = wallHeight;
        this.repetitions = repetitions;
    }

    @Override
    /**
     * This is where the name will be grabbed from
     */
    public String getNameOfExercise() {
        return "RockClimbing";
    }

    @Override
    /**
     * This calculate the calories burned in rock climbing
     */
    public double getCaloriesBurned() {
        return (wallHeight * repetitions / duration) * 100;
    }

    
    /**
     * This is return the wall height
     * @return
     */
    public double getWallHeight() {
        return wallHeight;
    }

    
    /**
     * This will get the specific wall heights
     * @param wallHeight
     */
    public void setWallHeight(double wallHeight) {
        this.wallHeight = wallHeight;
    }

    
    /**
     * This will return the repetitions 
     * @return
     */
    public int getRepetitions() {
        return repetitions;
    }

    
    /**
     * This will get the specific repetiitons
     * @param repetitions
     */
    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }
}