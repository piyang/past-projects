package digitalclock;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * A class that allows a user to set an alarm through a GUI
 * @author piyang
 */
public class AlarmSet {
    
    /**
     * Creates a pop-up window that allows the user to set an alarm
     * @param c 
     */
    public AlarmSet(Clock c){
       JFrame frame = new JFrame("Alarm");
        
       JPanel panel = new JPanel(new GridLayout(1,4));
       JPanel panel2 = new JPanel(new GridLayout());
       
       // creates the text fields
       JTextField hours = new JTextField();
       JTextField minutes = new JTextField();
       JTextField userHours = new JTextField();
       JTextField userMinutes = new JTextField();
       JTextField amOrPm = new JTextField();
       JTextField userAmOrPm = new JTextField();
       hours.setBackground(BACKGROUND);
       minutes.setBackground(BACKGROUND);
       userHours.setBackground(BACKGROUND);
       userMinutes.setBackground(BACKGROUND);
       amOrPm.setBackground(BACKGROUND);
       userAmOrPm.setBackground(BACKGROUND);
       hours.setForeground(FOREGROUND);
       minutes.setForeground(FOREGROUND);
       userHours.setForeground(FOREGROUND);
       userMinutes.setForeground(FOREGROUND);
       amOrPm.setForeground(FOREGROUND);
       userAmOrPm.setForeground(FOREGROUND);
       
       // creates the set alarm button
       JButton setAlarm = new JButton("Set Alarm");
       setAlarm.setBackground(BACKGROUND);
       setAlarm.setForeground(FOREGROUND);
       
       // creates the actionListener for the set alarm button
       setAlarm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                aHours = userHours.getText();
                aMinutes = userMinutes.getText();
                period = userAmOrPm.getText();
                c.setAlarm(aHours, aMinutes, period);
                frame.dispose();
            }
        });
       
       hours.setText("Hours: ");
       minutes.setText("Minutes: ");
       amOrPm.setText("AM or PM: ");
       hours.setEditable(false);
       minutes.setEditable(false);
       amOrPm.setEditable(false);
       
       panel.add(hours);
       panel.add(userHours);
       panel.add(minutes);
       panel.add(userMinutes);
       panel.add(amOrPm);
       panel.add(userAmOrPm);
       panel2.add(setAlarm);
       
       frame.add(panel, BorderLayout.CENTER);
       frame.add(panel2, BorderLayout.SOUTH);
       frame.setSize(500, 200);
       frame.setVisible(true);
       frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }
    
    /**
     * returns the hour of the alarm
     * @return the hour of the alarm
     */
    public String getHours(){
        return aHours;
    }
    
    /**
     * returns the minute of the alarm
     * @return the minute of the alarm
     */
    public String getMinutes(){
        return aMinutes;
    }
    
    private String aHours = null;
    private String aMinutes = null;
    private String period = null;
    private final Color BACKGROUND = Color.WHITE;
    private final Color FOREGROUND = Color.BLACK;
    
}
