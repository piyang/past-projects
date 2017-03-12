package digitalclock;



/**
 * A class that represents a Counter object, which simply keeps track of a
 * count in a given range
 * @author piyang
 */
public class Counter {
    
    /**
     * Constructs a Counter object
     * @param r the range of the counter
     */
    public Counter(int r){
        range = r;
        value = 0;
    }
    
    /**
     * Sets the value of the Counter
     * @param v the value
     */
    public void setValue(int v){
        value = v;
    }
    
    /**
     * Gets the value of the counter
     * @return the value of the counter
     */
    public int getValue(){
        return value;
    }
    
    /**
     * increments the value by one, making sure it does not go over
     * the range
     */
    public void increment(){
        value = (value + 1) % range;
    }
    
    /**
     * decrements the value by one, making sure it does not go below 0
     */
    public void decrement(){
        if(value == 0){
            value = range - 1;
        }else{
            value = value - 1;
        }
    }
    
    private int range;
    private int value;
    
}
