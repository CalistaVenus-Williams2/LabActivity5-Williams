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
    private List<JRadioButton> dis;
    private List<JCheckBox> food;

    public FoodOrderGUI(){
        setTitle("Food Ordering System");
        dis = new ArrayList();
        dis.add(rbNone);
        dis.add(rb5);
        dis.add(rb10);
        dis.add(rb15);

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
        //insert exception when no items selected
        if(cPizza.isSelected()){
            sum = sum+100;
        } if(cBurger.isSelected()){
            sum = sum+80;
        } if(cFries.isSelected()){
            sum = sum+65;
        } if(cSoftDrinks.isSelected()){
            sum = sum+55;
        } if(cTea.isSelected()){
            sum = sum+50;
        } if(cSundae.isSelected()){
            sum = sum+40;
        }
        discount(sum);
    }

    public void discount(int sum) {
        double b4 = sum;
        double fin = sum;
        //add exception for no discount selected
        if(rbNone.isSelected()){
            //do nothing
        } else if(rb5.isSelected()){
            fin = b4-(b4*.05);
        } else if(rb10.isSelected()){
            fin = b4-(b4*.10);
        } else if(rb15.isSelected()){
            fin = b4-(b4*.15);
        }
        display(fin);
    }

    public void display(double fin){
        JOptionPane.showMessageDialog(panel1,String.format("The total price is Php %.2f", fin));
    }


}
