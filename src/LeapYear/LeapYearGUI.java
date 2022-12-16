package LeapYear;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

public class LeapYearGUI extends JFrame{
    private JPanel panel1;
    private JTextField tfYear;
    private JButton btnCheckYear;

    public LeapYearGUI() {
        setTitle("Leap Year Checker");
        btnCheckYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                determineLeapYear();
            }
        });
    }

    public static void main(String[] args){
        LeapYearGUI app = new LeapYearGUI();
        app.setContentPane(app.panel1);
        app.setSize(300,250);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    public void determineLeapYear(){
        try {
            int year = Integer.parseInt(tfYear.getText());
            boolean leap=false;
            if(year>=1582){
                if (year % 4 == 0) {
                    if (year % 100 == 0) {
                        if (year % 400 == 0) {
                            leap= true;
                        }
                        leap = false;
                    }
                    leap = true;
                } display(leap);
            } else {
                throw (new Exception());
            }
        }catch (NumberFormatException e){
            System.err.println("Input is not a number");
        } catch(Exception e){
            System.err.println("Input is not a valid year");
        }
    }

    public void display(boolean leap){
        JFrame huh = new JFrame();
        if(leap){
            JOptionPane.showMessageDialog(huh,"Leap Year");
        } else {
            JOptionPane.showMessageDialog(huh,"Not a leap year");
        }
    }
}


