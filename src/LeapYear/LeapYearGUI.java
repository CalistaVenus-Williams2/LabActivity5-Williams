package LeapYear;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeapYearGUI extends JFrame{
    private JPanel panel1;
    private JTextField tfYear;
    private JButton btnCheckYear;

    public LeapYearGUI() {
        btnCheckYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display(determineLeapYear());
            }
        });
    }

    public static void main(String[] args){
        LeapYearGUI app = new LeapYearGUI();
        app.setContentPane(app.panel1);
        app.setSize(250,250);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    public boolean determineLeapYear(){
        int year = Integer.parseInt(tfYear.getText());
        if(year%4==0){
            if(year%100==0){
                if(year%400==0){
                    return true;
                } return false;
            } return true;
        } return false;
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


