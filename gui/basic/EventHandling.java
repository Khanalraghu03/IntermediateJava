package gui.basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandling extends JFrame implements ActionListener{
    private JTextField item1;
    private JTextField item2;
    private JTextField item3;
    private JPasswordField passwordField;

    public EventHandling() {
        super("My Title"); //title on window
        setLayout(new FlowLayout()); //layout on window

        item1 = new JTextField(10);
        item2 = new JTextField("Enter text here");
        item3 = new JTextField("Not for Edit", 20);
        item3.setEditable(false);
        passwordField = new JPasswordField("mypass");

        add(item1);
        add(item2);
        add(item3);
        add(passwordField);

//        TheHandler handler = new TheHandler();
        item1.addActionListener(this); //no need for passing handler
        item2.addActionListener(this); //handler instead of this
        item3.addActionListener(this); //handler
        passwordField.addActionListener(this); //handler

    }
    //Class inside inherits the class outside
//    private class TheHandler implements ActionListener { //extends EventHandling

        @Override
        public void actionPerformed(ActionEvent event) {
            String string = "";
            if(event.getSource() == item1) {
                string = String.format("field 1: %s", event.getActionCommand()); //get the text from that location(text1)
            }
            else if(event.getSource() == item2) {
                string = String.format("field 2: %s", event.getActionCommand());
            }
            else if(event.getSource() == item3) {
                string = String.format("field 3: %s", event.getActionCommand());
            }
            else {
                string = String.format("Password field is: %s" ,event.getActionCommand() );
            }

            //show the message when pressed enter
            JOptionPane.showMessageDialog(null, string);

        }

//    }
}

