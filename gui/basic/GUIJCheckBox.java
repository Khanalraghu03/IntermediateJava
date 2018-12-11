package gui.basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class GUIJCheckBox extends JFrame implements ItemListener {
    private JTextField textField;
    private JCheckBox boldBox;
    private JCheckBox italicBox;

    public GUIJCheckBox() {
        super("JTextLabel");
        setLayout(new FlowLayout());

        textField = new JTextField("Sentence this is.", 20);
        textField.setFont(new Font("Serif", Font.PLAIN, 14));
        add(textField);

        boldBox = new JCheckBox("Bold");
        italicBox = new JCheckBox("Italic");
        add(boldBox);
        add(italicBox);

        boldBox.addItemListener(this);
        italicBox.addItemListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,200);
        setVisible(true);

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Font font = null;

        if (boldBox.isSelected() && italicBox.isSelected()) {
            font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);

        } else if (boldBox.isSelected()) {
            font = new Font("Serif", Font.BOLD, 14);

        } else if (italicBox.isSelected()) {
            font = new Font("Serif", Font.ITALIC, 14);
        }
        else {
            font = new Font("Serif", Font.PLAIN, 14);
        }
        textField.setFont(font);
    }


}
