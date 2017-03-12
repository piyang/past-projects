package digitalclock;

/**
 * A class that represents the various states of the clock, in other words,
 * what it is being used for at the present.
 * @author piyang
 */
public enum State {
    LOCKED (0), SET_TIME (1), SET_HOURS (2), SET_MINS (3);
    
    /**
     * initializes the numerical value of the states
     * @param n the number corresponding to the given state
     */
    State(int n){
        this.n = n;
    }
    
    private final int n;
  
    
}
