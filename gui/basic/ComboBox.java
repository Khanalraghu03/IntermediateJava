package gui.basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class ComboBox extends JFrame {
    private JComboBox jComboBox;
    private JLabel pictures;

    private static String[] filename = {"apple_ex.png", "ILTQq.png"};
    private Icon[] pics = {new ImageIcon(getClass().getResource(filename[0])),new ImageIcon(getClass().getResource(filename[1]))};

    public ComboBox() {
        super("ComboBox Title");
        setLayout(new FlowLayout());

        jComboBox = new JComboBox(filename); //filename as options
//        jComboBox.addItemListener(
//                //Anonymous class
//                new ItemListener() {
//                    @Override
//                    public void itemStateChanged(ItemEvent e) {
//                        if(e.getStateChange() == ItemEvent.SELECTED) {
//                            pictures.setIcon(pics[jComboBox.getSelectedIndex()]);
//                        }
//                    }
//                }
//
//        );

        //Replace with Lamda expression
        jComboBox.addItemListener(
                //Anonymous class
                (e) -> {

                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        pictures.setIcon(pics[jComboBox.getSelectedIndex()]);
                    }
                }

        );

        add(jComboBox);
        pictures = new JLabel(pics[0]);
        add(pictures);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,200);
        setVisible(true);
    }

}
