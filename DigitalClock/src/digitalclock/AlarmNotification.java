package digitalclock;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * A class representing the pop up notification of the alarm
 * @author piyang
 */
public class AlarmNotification {
    
    /**
     * creates an Alarm notification pop up
     */
    public AlarmNotification(){
        JFrame frame = new JFrame("ALARM!!!");
        JPanel panel = new JPanel(new BorderLayout());
        
        // creates the alarm textField
        JTextField alarm = new JTextField(50);
        alarm.setFont(new Font("TimesRoman", Font.BOLD, 50));
        alarm.setText("      WAKE UP");
        alarm.setEditable(false);
        alarm.setForeground(Color.black);
        alarm.setBackground(Color.red);
        
        // adds the components the panel and adds the panel to the frame
        panel.add(alarm);
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(500, 200);
        frame.setVisible(true);
        //frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        
        // creates an actionListener for the timer so that the alarm
        // message flashes before the user
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent event){
                if (counter % 2 == 0) {
                    alarm.setForeground(Color.red);
                } else {
                    alarm.setForeground(Color.black);
                }
                counter++;
            }
        };
        
        // creates the timer and starts it
        Timer t = new Timer(DELAY, listener);
        t.start();
    }
    
    private final int DELAY = 500;
    private int counter = 0;
    
}
