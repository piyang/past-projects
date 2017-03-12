package digitalclock;


/**
 * A class that represents a Clock object with hours, minutes, and seconds
 * displayed in military time
 * @author piyang
 */
public class Clock {
    
    /**
     * Constructs a clock with hours, minutes, and seconds
     */
    public Clock(){
        hours = new Counter(HOURS_RANGE);
        minutes = new Counter(MINS_RANGE);
        seconds = new Counter(SECS_RANGE);
        alarm = new Alarm();
        
    }
    
    /**
     * A method that makes the clock tick; increments the seconds by one
     */
    public void tick(){
        seconds.increment();
        if(seconds.getValue()==0){
            minutes.increment();
            if(minutes.getValue()==0){
                hours.increment();
            }
        }
        
    }
    
    /**
     * increments the hours by one
     */
    public void incHours(){
        hours.increment();
    }
    
    /**
     * increments the minutes by one
     */
    public void incMins(){
        minutes.increment();
    }
    
    /**
     * decrements the hours by 1
     */
    public void decHours(){
        hours.decrement();
    }
    
    /**
     * decrements the minutes by 1
     */
    public void decMins(){
        minutes.decrement();
    }
    
    /**
     * sets the value of seconds back to zero
     */
    public void clearSeconds(){
        seconds.setValue(0);
    }
    
    /**
     * Gets the value of the hours
     * @return the value of the hours
     */
    public int getHours(){
        return hours.getValue();
    }
    
    /**
     * Gets the value of the minutes
     * @return the value of the minutes
     */
    public int getMinutes(){
        return minutes.getValue();
    }
    
    /**
     * Gets the value of the seconds
     * @return the value of the seconds
     */
    public int getSeconds(){
        return seconds.getValue();
    }
    
    /**
     * Sets the alarm
     * @param h hours in the form of a String
     * @param m minutes in the form of a String
     */
    public void setAlarm(String h, String m, String p){
        alarm.setAlarm(h, m, p);
    }
    
    /**
     * checks if it is the alarm time
     * @return true if it is the alarm time, false if not
     */
    public boolean checkAlarm(){
        return alarm.getHours() == hours.getValue() 
                && alarm.getMinutes() == minutes.getValue()
                && seconds.getValue() == 0;
    }
    
    private Alarm alarm = null;
    private Counter hours = null;
    private Counter minutes = null;
    private Counter seconds = null;
    private final int HOURS_RANGE = 24;
    private final int MINS_RANGE = 60;
    private final int SECS_RANGE = 60;
    
}
