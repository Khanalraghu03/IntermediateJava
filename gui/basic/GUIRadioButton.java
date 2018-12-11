package gui.basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class GUIRadioButton extends JFrame {
    private JTextField textField;
    private Font plainFont;
    private Font boldFont;
    private Font italicFont;
    private Font boldItalicFont;
    private JRadioButton plainButton;
    private JRadioButton boldButton;
    private JRadioButton italicButton;
    private JRadioButton boldItalicButton;
    //establish a relationship so that only one button
        //can be selected at once
    //If not related,
        //there would be 4 separate button on the screen
        //each acting independently
        //we want them as a family so they know when each other are clicked or not
    private ButtonGroup group; //

    public GUIRadioButton() {
        super("Title");
        setLayout(new FlowLayout());

        textField = new JTextField("Rg is cool", 25);
        add(textField);

        plainButton = new JRadioButton("Plain", true); //true is checked/ false is unchecked
        boldButton = new JRadioButton("Bold", false);
        italicButton = new JRadioButton("Italic", false);
        boldItalicButton = new JRadioButton("Bold and Italic", false);
        add(plainButton);
        add(boldButton);
        add(italicButton);
        add(boldItalicButton);

        group = new ButtonGroup();
        group.add(plainButton);
        group.add(boldButton);
        group.add(italicButton);
        group.add(boldItalicButton);

        plainFont = new Font("Serif", Font.PLAIN, 14);
        boldFont= new Font("Serif", Font.BOLD, 14);
        italicFont = new Font("Serif", Font.ITALIC, 14);
        boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
        textField.setFont(plainFont);

        plainButton.addItemListener(new ItemHandler(plainFont));
        boldButton.addItemListener(new ItemHandler(boldFont));
        italicButton.addItemListener(new ItemHandler(italicFont));
        boldItalicButton.addItemListener(new ItemHandler(boldItalicFont));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,200);
        setVisible(true);
    }

    private class ItemHandler implements ItemListener {
        private Font font;
        public ItemHandler(Font f) {
            font = f;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            textField.setFont(font);
        }
    }
}
