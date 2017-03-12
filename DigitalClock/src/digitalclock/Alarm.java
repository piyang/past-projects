
package digitalclock;

/**
 * A class representing an Alarm with hours and minutes
 * @author piyang
 */
public class Alarm {
    
    /**
     * Creates an alarm whose time has not been set
     */
    public Alarm(){
       
    }
    
    /**
     * Sets the time of the alarm
     * @param h hours in the form of a string
     * @param m minutes in the form of a string
     */
    public void setAlarm(String h, String m, String p){
       if(p.equalsIgnoreCase("PM") && Integer.valueOf(h) != 12 ){
           hours = Integer.valueOf(h) + 12;
       }else if(p.equalsIgnoreCase("AM") && Integer.valueOf(h) == 12) {
           hours = 0;
       } else  hours = Integer.valueOf(h);
      
       minutes = Integer.valueOf(m);  

    }
    
    /**
     * returns the hours
     * @return the hours
     */
    public int getHours(){
        return hours;
    }
    
    /**
     * returns the minutes
     * @return the minutes
     */
    public int getMinutes(){
        return minutes;
    }
    
    private int hours;
    private int minutes;
  
    
    
}
