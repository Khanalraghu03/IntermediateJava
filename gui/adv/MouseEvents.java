package gui.adv;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseEvents extends JFrame implements MouseListener, MouseMotionListener {
    private JPanel mousePanel;
    private JLabel statusBar;

    public MouseEvents() {
        super("Mouse Event Title");
//        setLayout(new FlowLayout());

        mousePanel = new JPanel();
        mousePanel.setBackground(Color.WHITE);
        add(mousePanel, BorderLayout.CENTER);

        statusBar = new JLabel("Default Status");
        add(statusBar, BorderLayout.SOUTH);


        mousePanel.addMouseListener(this);
        mousePanel.addMouseMotionListener(this);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,200);
        setVisible(true);
    }


    //Mouse Listener
    @Override
    public void mouseClicked(MouseEvent e) {
        statusBar.setText(String.format("Clicked at %d,%d", e.getX(), e.getY())); //works
    }

    @Override
    public void mousePressed(MouseEvent e) {
        statusBar.setText("You pressed down the button"); //works
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        statusBar.setText("You released the button"); //works
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        statusBar.setText("You entered the area"); //works
        mousePanel.setBackground(Color.RED);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        statusBar.setText("The mouse has left the window"); //works
        mousePanel.setBackground(Color.BLUE);
    }

    //Mouse Motion Listener
    @Override
    public void mouseDragged(MouseEvent e) {
        statusBar.setText("You are dragging the mouse");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        statusBar.setText("You moved the mouse");
    }

}
