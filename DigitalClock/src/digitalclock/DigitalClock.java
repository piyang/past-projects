package digitalclock;

/**
 * A class that creates a GUI of a 12 hour digital clock
 * @author piyang
 */
import static digitalclock.State.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DigitalClock {
    
    /**
     * Constructs a GUI representation of a digital clock with lock, set time,
     * hour, minute, up, and down buttons.
     */
    public DigitalClock(){
        JFrame frame = new JFrame("Digital Clock");

        JPanel panel1 = new JPanel(new GridLayout(1,3));
        JPanel panel2 = new JPanel(new BorderLayout());
        JPanel panel3 = new JPanel(new GridLayout(1,2));
        
        // creates the various buttons
        JButton lock = new JButton("Lock");
        JButton setTime = new JButton("Set Time");
        JButton hour = new JButton("Hour");
        JButton min = new JButton("Minute");
        JButton up = new JButton(" Up ");
        JButton down = new JButton("Down");
        JButton setAlarm = new JButton("Set Alarm");
        
        //sets the colors of the buttons
        lock.setBackground(BACKGROUND);
        setTime.setBackground(BACKGROUND);
        hour.setBackground(BACKGROUND);
        min.setBackground(BACKGROUND);
        up.setBackground(BACKGROUND);
        down.setBackground(BACKGROUND);
        setAlarm.setBackground(BACKGROUND);
        
        lock.setForeground(FOREGROUND);
        setTime.setForeground(FOREGROUND);
        hour.setForeground(FOREGROUND);
        min.setForeground(FOREGROUND);
        up.setForeground(FOREGROUND);
        down.setForeground(FOREGROUND);
        setAlarm.setForeground(FOREGROUND);
        
        // sets up the textField that will display the time
        JTextField numbers = new JTextField(20);
        numbers.setFont(new Font("TimesRoman", Font.BOLD, 30));
        numbers.setBackground(BACKGROUND);
        numbers.setForeground(Color.WHITE);
        numbers.setEditable(false);
        
        // next six blocks of code set up the actionListeners for the buttons,
        // taking into account the State of the clock and modifying their 
        // actions accordingly
        lock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                setState(LOCKED);
                up.setEnabled(false);
                down.setEnabled(false);
                hour.setEnabled(false);
                min.setEnabled(false);
                
            }
        });

        setTime.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                setState(SET_TIME);
                hour.setEnabled(true);
                min.setEnabled(true);
            }
        });

        hour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                setState(SET_HOURS);
                up.setEnabled(true);
                down.setEnabled(true);
            }
        });

        min.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                setState(SET_MINS);
                up.setEnabled(true);
                down.setEnabled(true);
            }
        });

        up.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (currentState == SET_HOURS) {
                     clock.incHours();
                     clock.clearSeconds();
                }else if (currentState == SET_MINS) {
                   clock.incMins();
                   clock.clearSeconds();
                }
            }
        });

        down.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (currentState == SET_HOURS) {
                    clock.decHours();
                    clock.clearSeconds();
                } else if (currentState == SET_MINS) {
                    clock.decMins();
                    clock.clearSeconds();
                }
            }
        });
        
        setAlarm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                AlarmSet a = new AlarmSet(clock);
            }
        });
        
        // creates the actionListener for the Timer
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                clock.tick();
                if(clock.checkAlarm()){
                    AlarmNotification an = new AlarmNotification();
                }
                
                // sets the period based on the time
                String period;
                if(clock.getHours() > 11) period = "PM";
                else period = "AM";
                
                // modifies the hours to abide by the 12 hr clock standard
                int hours = clock.getHours();
                if(hours%12 == 0) hours = 12;
                else hours = hours % 12;
                
                // sets the time
                numbers.setText("       "
                        +String.format("%02d", hours)
                        +":"+String.format("%02d", clock.getMinutes())
                        +":"+String.format("%02d", clock.getSeconds())
                        +" "+period);
            }
        };
        
        // disables the following buttons so that they cannot be used until
        // the user clicks the Set Time button
        up.setEnabled(false);
        down.setEnabled(false);
        hour.setEnabled(false);
        min.setEnabled(false);
        
        // adds the elements to the appropriate panels
        panel1.add(lock);
        panel1.add(setTime);
        panel1.add(setAlarm);
        panel2.add(up, BorderLayout.WEST);
        panel2.add(down, BorderLayout.EAST);
        panel2.add(numbers, BorderLayout.CENTER);
        panel3.add(hour);
        panel3.add(min);
        
   
        // adds the panels to the frame
        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);
        frame.add(panel3, BorderLayout.SOUTH);

        frame.setSize(500,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        
        Timer t = new Timer(DELAY, listener);
        t.start();
  
    }
    
  
    /**
     * sets the state of the clock
     * @param s the state of the clock
     */
    public void setState(State s){
        currentState = s;
    }
    
    private State currentState;
    private Clock clock = new Clock();
    private final int DELAY = 1000;
    private final Color BACKGROUND = Color.BLACK;
    private final Color FOREGROUND = Color.BLACK;
   
}
    


