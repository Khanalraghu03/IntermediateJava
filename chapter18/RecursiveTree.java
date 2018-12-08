package chapter18;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Raghu Khanal
 *
 */

public class RecursiveTree extends JPanel implements ActionListener{
	private int order;
	private JFrame frame;
	private JLabel label;
	private JTextField textField;
	private JPanel outerPanel;
	private JPanel innerPanel;
	private volatile boolean wait;
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public RecursiveTree(int order) {
		this.order = order;
		this.frame = new JFrame("Recursive Tree");
		this.outerPanel = new JPanel(new BorderLayout());
		this.outerPanel.add(this);
		this.setBackground(Color.CYAN);
		
		this.label = new JLabel("Enter an order: ");
		this.textField = new JTextField(5);
		this.textField.setText(order+"");
		this.innerPanel = new JPanel();
		this.innerPanel.setBackground(Color.YELLOW);
		
		this.innerPanel.add(label);
		this.innerPanel.add(textField);
		this.outerPanel.add(innerPanel, BorderLayout.SOUTH);
		this.frame.add(outerPanel);
		this.frame.setSize(330,330);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setVisible(true);
		this.frame.setResizable(false);
		this.textField.addActionListener(this);
		
		wait = true;
		while(true) {

			while(wait);	
			int limit = this.order;
			this.order = 0;
			while(this.order <= limit) 
			{
				repaint();
		
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.order++;
			}

			wait = true;	
	
		}

	}
	


	/**
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}


	/**
	 * @param order the order to set
	 */
	public void setOrder(int order) {
		this.order = order;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RecursiveTree [order=" + order + "]";
	}


	public void drawTree(Graphics g, int order, 
			double x, double y, double branchAngle, 
			double branchLength) {
		
		double cx = x + Math.cos(branchAngle) * branchLength;
		double cy = y - Math.sin(branchAngle) * branchLength;
		
		g.drawLine((int)x, (int)y, (int)cx, (int) cy);
		
		if(order == 0)
			return;
		
		double changeBranchAngle = Math.toRadians(35);
		double changeBranchLength = 0.569;
		
		drawTree(g, order - 1, cx, cy, branchAngle + changeBranchAngle, branchLength * changeBranchLength);
		drawTree(g, order - 1, cx, cy, branchAngle - changeBranchAngle, branchLength * changeBranchLength);
		
	}
	
	

	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		g2D.setStroke(new BasicStroke(2.5f));
		g2D.setColor(Color.BLUE);
		drawTree((Graphics)g, order, 150,220,Math.PI / 2 , 60);
		
	}
	


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Assign order from the text field 
		this.order = Integer.parseInt(textField.getText());
		//Declare an instance variable -wait: boolean and assign
			//false
		wait = false;
	}

}
