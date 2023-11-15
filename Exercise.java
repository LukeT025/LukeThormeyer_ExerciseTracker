/*
 * This class is where all the variables, abstracts, getter and setter, and formats are at.
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * has the protected names, date, durtations
 */
public abstract class Exercise implements Comparable<Exercise> {
    protected String name;
    protected Date date;
    protected int duration;

    /**
     * This function does is constructs specified names, dates, and durations
     * @param name
     * @param dateString
     * @param duration
     */
    public Exercise(String name, String dateString, int duration) {
        this.name = name;
        this.duration = duration;
        setDateFromString(dateString);
    }

    
    /**
     * This formats get the date and see if the correct way they did the date into string
     * @param dateString
     */
    private void setDateFromString(String dateString) {
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        try {
            this.date = df.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * This will grab a specific name of the exercise the user put in 
     * @return
     */
    public abstract String getNameOfExercise();
    
    
    /**
     * This will grab a specific calories that were calculated in the exercies the user was doing
     * @return
     */
    public abstract double getCaloriesBurned();

   
    /**
     * Will return the names
     * @return
     */
    public String getName() {
        return name;
    }

   
    /**
     * This is where the specific names are at
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /**
     * Will return the dates
     * @return
     */
    public Date getDate() {
        return date;
    }

   
    /**
     * This is where the specific dates are at
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    
    /**
     * Will return the durations 
     * @return
     */
    public int getDuration() {
        return duration;
    }

    
    /**
     * This is where the specific durations are at
     * @param duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    /**
     * This is where the format of the printed out exercise on screen will be
     */
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        return getNameOfExercise() + "\t" + name + "\t" + df.format(date) + "\t" + duration + "\t" + getCaloriesBurned();
    }

    @Override
    /**
     * This does is compare the dates to the other exercies
     */
    public int compareTo(Exercise other) {
        return this.date.compareTo(other.date);
    }
}