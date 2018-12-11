package gui.basic;
import javax.swing.*;
import java.awt.*;


public class GUIJFrame extends JFrame {
    private JLabel item1;

    public GUIJFrame() {
        super("The title");
        setLayout(new FlowLayout());

        item1 = new JLabel("This is a JLabel");
        item1.setToolTipText("Hover text");
        add(item1);
    }
}
