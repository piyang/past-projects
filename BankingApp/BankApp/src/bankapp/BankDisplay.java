package bankapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Date;

/**
 * A GUI representing a bank with a BankSystem (ListOfAccounts) of accounts of
 * various types
 * @author piperyang
 */
public class BankDisplay {
    
    public BankDisplay(){
        accounts = new BankingSystem();
        JFrame frame = new JFrame("Bank Application");
        
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new GridLayout(2,3));
        
        //creates the welcome text that will be at the top of the app
        JTextField welcomeText = new JTextField();
        welcomeText.setText("\t"
                + "Welcome! What would you like to do today?");
        welcomeText.setFont(new Font(FONT, Font.BOLD, FONT_SIZE));
        welcomeText.setEditable(false);
        
        //creates the necessary buttons
        JButton newSAcct = new JButton("Create A New Savings Account");
        JButton newCAcct = new JButton("Create A New Checking Account");
        JButton findAcct = new JButton("View an Existing Account");
        JButton displayAll = new JButton("View All Accounts");
        JButton displayChecking = new JButton("View All Checking Accounts");
        JButton displaySavings = new JButton("View All Savings Accounts");
        
        
        //makes the buttons perform their corresponding actions
        newSAcct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFrame newSAcctFrame = new JFrame();
                JPanel instruction = new JPanel(new GridLayout(2,1));
                JPanel button = new JPanel(new GridLayout(1,1));
                
                
                JTextField instruct = new JTextField();
                instruct.setText("Please enter you full name, initial "
                        + "deposit, and today's date seperated by commas. "
                        + "Ex: Jane Doe, 1000.00, mm/dd/yyyy");
                instruct.setEditable(false);
                JTextField input = new JTextField();
                
                instruction.add(instruct);
                instruction.add(input);
                
                JButton submit = new JButton("Submit");
                submit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event){
                        String name = "";
                        double balance = 0.0;
                        Date d = new Date();
                        int commas = 0;
                        int firstComma = 0;
                        String userInput = input.getText();
                        
                        for(int i = 0; i < userInput.length(); i++){
                            if(userInput.charAt(i) == ',' && commas == 0){
                                name = userInput.substring(0,i).trim();
                                firstComma = i;
                                commas++; 
                            }
                            else if(userInput.charAt(i) == ',' && commas == 1){
                                balance = Double.valueOf(
                                        userInput.substring(firstComma + 1, i).trim());
                                int month = Integer.valueOf(
                                        userInput.substring(i+2,i+4)) - 1;
                                int day = Integer.valueOf(
                                        userInput.substring(i+5, i+7));
                                int year = Integer.valueOf(
                                        userInput.substring(i+8)) - 1900;
                                d = new Date(year, month, day);
                            }
                        }
                        SavingsAccount sA = new SavingsAccount(name, balance, d);
                        accounts.addAccount(sA);
                        
                        DecimalFormat df = new DecimalFormat("#.00"); 
                        instruct.setText("Thank you, a savings account for "
                                + name
                                +" with a balance of $" 
                                + df.format(balance)
                                + " has been created.");
                       
                        JButton back = new JButton("Back");
                        back.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent event) {
                                newSAcctFrame.dispose();
                            }
                        });
                        submit.setVisible(false);
                        button.add(back);
                    }
                });
                
                button.add(submit);
                
                newSAcctFrame.add(instruction, BorderLayout.CENTER);
                newSAcctFrame.add(button, BorderLayout.SOUTH);
                
                newSAcctFrame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
                newSAcctFrame.setVisible(true);
                newSAcctFrame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
               
            }
        });
        
        newCAcct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFrame newCAcctFrame = new JFrame();
                JPanel instruction = new JPanel(new GridLayout(2,1));
                JPanel button = new JPanel(new GridLayout(1,1));
                
                
                JTextField instruct = new JTextField();
                instruct.setText("Please enter you full name and initial"
                        + " deposit seperated by a comma. "
                        + "Ex: Jane Doe, 1000.00, mm/dd/yyyy");
                instruct.setEditable(false);
                JTextField input = new JTextField();
                
                instruction.add(instruct);
                instruction.add(input);
                
                JButton submit = new JButton("Submit");
                submit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event){
                        String name = "";
                        double balance = 0.0;
                        Date d = new Date();
                        int commas = 0;
                        int firstComma = 0;
                        String userInput = input.getText();
                        
                        for(int i = 0; i < userInput.length(); i++){
                            if(userInput.charAt(i) == ',' && commas == 0){
                                name = userInput.substring(0,i).trim();
                                firstComma = i;
                                commas++; 
                            }
                            else if(userInput.charAt(i) == ',' && commas == 1){
                                balance = Double.valueOf(
                                        userInput.substring(firstComma+1, i).trim());
                                int month = Integer.valueOf(
                                        userInput.substring(i+2,i+4)) - 1;
                                int day = Integer.valueOf(
                                        userInput.substring(i+5, i+7));
                                int year = Integer.valueOf(
                                        userInput.substring(i+8)) - 1900;
                                d = new Date(year, month, day);
                            }
                        }
                        CheckingAccount cA = new CheckingAccount(name, balance, d);
                        accounts.addAccount(cA);
                        
                        DecimalFormat df = new DecimalFormat("#.00"); 
                        instruct.setText("Thank you, a checking account for "
                                + name
                                +" with a balance of $" 
                                + df.format(balance)
                                + " has been created.");
                       
                        JButton back = new JButton("Back");
                        back.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent event) {
                                newCAcctFrame.dispose();
                            }
                        });
                        submit.setVisible(false);
                        button.add(back);
                    }
                });
                
                button.add(submit);
                
                newCAcctFrame.add(instruction, BorderLayout.CENTER);
                newCAcctFrame.add(button, BorderLayout.SOUTH);
                
                newCAcctFrame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
                newCAcctFrame.setVisible(true);
                newCAcctFrame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
               
            }
        });
        
        findAcct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFrame findFrame = new JFrame();
                JPanel instruction = new JPanel(new GridLayout(2,1));
                JPanel button = new JPanel(new GridLayout(1,3));
                
                
                JTextArea instruct = new JTextArea();
                instruct.setText("\n\n\n\n\n"
                        + "Please enter the name of the account holder and "
                        + "today's date seperated by a comma. "
                        + "Ex: Jane Doe, mm/dd/yyyy");
                //instruct.setFont(new Font("TimesRoman", Font.BOLD, 30));
                instruct.setEditable(false);
                JTextField input = new JTextField();
                
                instruction.add(instruct);
                instruction.add(input);
                
                JButton submit = new JButton("Submit");
                submit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event){
                        JButton withdraw = new JButton("Withdraw");
                        JButton deposit = new JButton("Deposit");
                        
                        String userInput = input.getText();
                        String name ="";
                        Date d = new Date();
                        for(int i = 0; i < userInput.length(); i++){
                            if(userInput.charAt(i) == ','){
                                name = userInput.substring(0,i).trim();
                                int month = Integer.valueOf(
                                        userInput.substring(i+2,i+4)) - 1;
                                int day = Integer.valueOf(
                                        userInput.substring(i+5, i+7));
                                int year = Integer.valueOf(
                                        userInput.substring(i+8)) - 1900;
                                d = new Date(year, month, day);
                            }
                        }
                        BankAccount acctFound = accounts.findAcct(name);
                        if(acctFound != null){
                            if(acctFound instanceof SavingsAccount){
                                acctFound.setBalance(
                                        ((SavingsAccount) acctFound).interest(d));
                            }
                            instruct.setText(acctFound.toString());
                        }
                        else{
                            instruct.setText("No accounts found under that name.");
                            withdraw.setVisible(false);
                            deposit.setVisible(false);
                        }
                       
                        JButton back = new JButton("Back");
                        back.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent event) {
                                findFrame.dispose();
                            }
                        });
            
                        withdraw.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent event) {
                                withdraw.setVisible(false);
                                deposit.setVisible(false);
                                input.setText("");
                                String instructText ="";
                                if (acctFound instanceof CheckingAccount) {
                                    instructText = "\n\n\n\n\n"
                                            + "How much would you "
                                            + "like to withdraw?\n"
                                            + "Note there is $0.10 fee per"
                                            + " withdrawal.";
                                }
                                else {
                                    instructText = "\n\n\n\n\n"
                                        + "How much would you"
                                        + " like to withdraw?";
                                }
                                instruct.setText(instructText);
                                
                                JButton submit2 = new JButton("Submit");
                                button.add(submit2);
                                submit2.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent event) {
                                        DecimalFormat df = new DecimalFormat("#.00"); 
                                        double amt = Double.valueOf(input.getText());
                                        acctFound.withdraw(amt);
                                       
                                        instruct.setText("\n\n\n\n\n"
                                                + "Thank you! "
                                                + "The remaining balance "
                                                + "in "+acctFound.getName()+"'s "
                                                + "account is $"
                                                + df.format(acctFound.getBalance()));
                                        submit2.setVisible(false);
                                    }
                                });
                            }
                        });
                        
                        deposit.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent event) {
                                withdraw.setVisible(false);
                                deposit.setVisible(false);
                                input.setText("");
                                
                                instruct.setText("\n\n\n\n\n"
                                        + "How much would you"
                                        + " like to deposit?");
                                JButton submit2 = new JButton("Submit");
                                button.add(submit2);
                                submit2.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent event) {
                                        DecimalFormat df = new DecimalFormat("#.00"); 
                                        double amt = Double.valueOf(input.getText());
                                        acctFound.deposit(amt);
                                        instruct.setText("\n\n\n\n\n"
                                                + "Thank You! "
                                                + "The remaining balance "
                                                + "in "+acctFound.getName()+"'s "
                                                + "account is $"
                                                + df.format(acctFound.getBalance()));
                                        submit2.setVisible(false);
                                    }
                                });
                                
                            }
                        });
                        
                        submit.setVisible(false);
                        button.add(withdraw);
                        button.add(deposit);
                        button.add(back);
                    }
                });
                
                button.add(submit);
                
                findFrame.add(instruction, BorderLayout.CENTER);
                findFrame.add(button, BorderLayout.SOUTH);
                
                findFrame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
                findFrame.setVisible(true);
                findFrame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
               
            }
        });
        
        displayAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFrame displayFrame = new JFrame();
                JPanel display = new JPanel(new BorderLayout());
                JPanel button = new JPanel(new BorderLayout());

                JTextField header = new JTextField();
                header.setText("\t\tAll Accounts:");
                header.setFont(new Font(FONT, Font.BOLD, FONT_SIZE));
                header.setEditable(false);
                JTextArea allAccounts = new JTextArea(500, 300);
       
                allAccounts.setText(accounts.toString());
                
                JButton back = new JButton("Back");
                back.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        displayFrame.dispose();
                    }
                });
                
                display.add(header, BorderLayout.NORTH);
                display.add(allAccounts, BorderLayout.CENTER);
                button.add(back);
                
                displayFrame.add(display, BorderLayout.CENTER);
                displayFrame.add(button, BorderLayout.SOUTH);
                
                displayFrame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
                displayFrame.setVisible(true);
                displayFrame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);              
            }     
        });
        
        displayChecking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFrame displayFrame = new JFrame();
                JPanel display = new JPanel(new BorderLayout());
                JPanel button = new JPanel(new BorderLayout());

                JTextField header = new JTextField();
                header.setText("\t\tChecking Accounts:");
                header.setFont(new Font(FONT, Font.BOLD, FONT_SIZE));
                header.setEditable(false);
                JTextArea allAccounts = new JTextArea(500, 300);
                
                String result="";
                for(int i = 0; i < accounts.numAccounts(); i++){
                    BankAccount acct = accounts.getAccount(i);
                    if(acct instanceof CheckingAccount){
                        result += acct.toString()+"\n";
                    }
                }
                allAccounts.setText(result);
                
                JButton back = new JButton("Back");
                back.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        displayFrame.dispose();
                    }
                });
                
                display.add(header, BorderLayout.NORTH);
                display.add(allAccounts, BorderLayout.CENTER);
                button.add(back);
                
                displayFrame.add(display, BorderLayout.CENTER);
                displayFrame.add(button, BorderLayout.SOUTH);
                
                displayFrame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
                displayFrame.setVisible(true);
                displayFrame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);              
            }     
        });
        
        displaySavings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFrame displayFrame = new JFrame();
                JPanel display = new JPanel(new BorderLayout());
                JPanel button = new JPanel(new BorderLayout());

                JTextField header = new JTextField();
                header.setText("\t\tSavings Accounts:");
                header.setFont(new Font(FONT, Font.BOLD, FONT_SIZE));
                header.setEditable(false);
                JTextArea allAccounts = new JTextArea(500, 300);
                
                String result="";
                for(int i = 0; i < accounts.numAccounts(); i++){
                    BankAccount acct = accounts.getAccount(i);
                    if(acct instanceof SavingsAccount){
                        result += acct.toString()+"\n\n";
                    }
                }
                allAccounts.setText(result);
                
                JButton back = new JButton("Back");
                back.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        displayFrame.dispose();
                    }
                });
                
                display.add(header, BorderLayout.NORTH);
                display.add(allAccounts, BorderLayout.CENTER);
                button.add(back);
                
                displayFrame.add(display, BorderLayout.CENTER);
                displayFrame.add(button, BorderLayout.SOUTH);
                
                displayFrame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
                displayFrame.setVisible(true);
                displayFrame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);              
            }     
        });
        
        //adds the components to the appropriate panels
        panel1.add(welcomeText);
        panel2.add(newSAcct);
        panel2.add(newCAcct);
        panel2.add(findAcct);
        panel2.add(displaySavings);
        panel2.add(displayChecking);
        panel2.add(displayAll);
        
        //adds the panels to the frame
        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);

        
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        

    }
    
    private BankingSystem accounts;
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 400;
    private static final int FONT_SIZE = 20;
    private static final String FONT = "TimesRoman";
    
}
