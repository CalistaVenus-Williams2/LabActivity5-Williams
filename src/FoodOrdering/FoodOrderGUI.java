package FoodOrdering;

import LeapYear.LeapYearGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FoodOrderGUI extends JFrame{
    private JPanel panel1;
    private JCheckBox cPizza;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rbNone;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    private JButton btnOrder;

    public FoodOrderGUI(){
        setTitle("Food Ordering System");

        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input();
            }
        });
    }

    public static void main (String[] args){
        FoodOrderGUI app = new FoodOrderGUI();
        app.setContentPane(app.panel1);
        app.setSize(600,500);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    public void input(){
        int sum =0;
        int count = 0;
        try{
            if(cPizza.isSelected()){
                sum = sum+100;
                count++;
            } if(cBurger.isSelected()){
                sum = sum+80;
                count++;
            } if(cFries.isSelected()){
                sum = sum+65;
                count++;
            } if(cSoftDrinks.isSelected()){
                sum = sum+55;
                count++;
            } if(cTea.isSelected()){
                sum = sum+50;
                count++;
            } if(cSundae.isSelected()){
                sum = sum+40;
                count++;
            } if(count==0){
                throw (new Exception());
            } else {
                discount(sum);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(panel1,"No items selected.");
        }
    }

    public void discount(int sum) {
        double b4 = sum;
        double fin = sum;
        int count = 0;
        try{
            if(rbNone.isSelected()){
                //do nothing
                count++;
            } else if(rb5.isSelected()){
                fin = b4-(b4*.05);
                count++;
            } else if(rb10.isSelected()){
                fin = b4-(b4*.10);
                count++;
            } else if(rb15.isSelected()){
                fin = b4-(b4*.15);
                count++;
            } if (count==0){
                throw (new Exception());
            } else {
                display(fin);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(panel1,"No discount selected.");
        }
    }

    public void display(double fin){
        JOptionPane.showMessageDialog(panel1,String.format("The total price is Php %.2f", fin));
    }


}
