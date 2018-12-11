package gui.basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIJButton extends JFrame implements ActionListener {
    private JButton reg;
    private JButton appleButton;

    public GUIJButton() {
        super("The title"); //call JFrame default constructor: takes title
        setLayout(new FlowLayout());

        reg = new JButton("Regular Button");
        add(reg);

        Icon apple = new ImageIcon(getClass().getResource("apple_ex.png"));
        Icon penguin = new ImageIcon(getClass().getResource("ILTQq.png"));

        appleButton = new JButton("Apple", apple);
        appleButton.setRolloverIcon(penguin);
        add(appleButton);

        reg.addActionListener(this);
        appleButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s;
        if(e.getSource() == reg) {
            s = String.format("%s", e.getActionCommand());
        }
        else {
            s = "Penguin";
        }
        JOptionPane.showMessageDialog(null, String.format("%s", s));
    }
}