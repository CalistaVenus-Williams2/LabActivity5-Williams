package SimpleCalc;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SimpleCalcGUI extends JFrame {
    private JPanel panel1;
    private JTextField tfNumber1;
    private JTextField tfNumber2;
    private JComboBox cbOperations;
    private JButton btnCompute;
    private JLabel lblResult;

    SimpleCalcGUI(){
        setTitle("Simple Calculator");
        String[] op={"+", "-", "*", "/"};
        for(int i = 0; i<4; i++){
            cbOperations.addItem(op[i]);
        }
        //cbOperations = new JComboBox(op);
        //i dont know why this doesnt fuckign work but okay
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input();
            }
        });
    }
    public static void main(String[] args){
        SimpleCalcGUI app = new SimpleCalcGUI();
        app.setContentPane(app.panel1);
        app.setSize(600,250);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    public void input(){
//        try{
            int x = Integer.parseInt(tfNumber1.getText());
            int y = Integer.parseInt(tfNumber2.getText());
            calc(x, y);
//        } catch (NumberFormatException e){
//            System.err.println("Input is not a number.");
//        }
    }
    public void calc(int a, int b){
        int z;
        //try {
            if(cbOperations.getSelectedItem()=="+"){
                z = a+b;
            } else if (cbOperations.getSelectedItem()=="-"){
                z = a-b;
            } else if (cbOperations.getSelectedItem()=="*"){
                z = a*b;
            } else {
                z = a/b;
            } display(z);
//        } catch (Exception e){
//            System.err.println("Cannot divide by zero.");
//        }
    }

    public void display(int z){
        lblResult.setText(String.valueOf(z));
    }
}
