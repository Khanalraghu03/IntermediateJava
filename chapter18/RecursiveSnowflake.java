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


public class RecursiveSnowflake extends JPanel implements ActionListener {
	private int order;
	
	JFrame frame;
	JLabel label;
	JTextField textField;
	JPanel outerPanel;	
	JPanel innerPanel;
	//A volatile variable is one whose value can be 
		//changed from a process other than the current
		//	program
	private volatile boolean wait;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public RecursiveSnowflake(int order) {

		this.order = order; //sets order

		this.frame = new JFrame("Recursive Snowflake");
		this.outerPanel = new JPanel(new BorderLayout());
		this.outerPanel.add(this);
		this.setBackground(Color.CYAN);

		this.label = new JLabel("Enter an order: ");
		this.textField = new JTextField(5);
		this.textField.setText(order + "");
		this.innerPanel = new JPanel();
		this.innerPanel.setBackground(Color.YELLOW);

		this.innerPanel.add(label);
		this.innerPanel.add(textField);
		this.outerPanel.add(innerPanel, BorderLayout.SOUTH);
		this.frame.add(outerPanel);
		this.frame.setSize(450, 580);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setVisible(true);
		this.frame.setResizable(false);
		this.textField.addActionListener(this);


//		Assign true to the instance variable wait
		wait = true;
//		Loop infinitely:
//		Loop until wait becomes false
		while (true) {
			//Loop until wait becomes false, so the process restarts
			//when a new order is entered
			while (wait);
//				Declare a local variable limit:int and assign to it the 
			//value of the instance variable order
			//This will allow the graphics to be drawn from order 0
			//to the limit

			int limit = order;
//				Assign zero to order
			this.order = 0;
			//		Loop until order is greater than limit
			while (this.order <= limit) {
//					Draw the graphic by calling repaint()
				repaint();
				//		Delay for one second. Handle the Exception by printing the stack trace
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//		Increment order by one
				this.order++;
				//		End loop


			}
//				Assign true to wait	so that the program waits for
			//the next order to be entered
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
		return "RecursiveSnowflake [order=" + order + "]";
		
	}

	
	public void drawSnow(Graphics g, int order, int x1, int y1, int x5, int y5) {
//	Write the base case
		g.drawLine(x1, y1, x5, y5);
		if(order == 0)
//			g.drawLine(x1, y1, x5, y5);
			return;

//	use the following formulae to compute the points for the higher order lines:
		int deltaX = x5 - x1;
		int deltaY = y5 - y1;
		int x2 = x1 + deltaX / 3;
		int y2 = y1 + deltaY / 3;
		int x3 = (int) (0.5 * (x1+x5) + Math.sqrt(3) * (y1-y5)/6);
		int y3 = (int) (0.5 * (y1+y5) + Math.sqrt(3) * (x5-x1)/6);
		int x4 = x1 + 2 * deltaX /3;
		int y4 = y1 + 2 * deltaY /3;
//	drawSnow calls itself recursively
		//Reduce order by 1 so that the recursive will taper to 
			//the base case
		this.drawSnow(g, order - 1, x1, y1, x2, y2);
		this.drawSnow(g, order - 1, x2, y2, x3, y3);
		this.drawSnow(g, order - 1, x3, y3, x4, y4);
		this.drawSnow(g, order - 1, x4, y4, x5, y5);

	
	
	}
	
	//Implement this method to start recursive process and 
	//override the method paintComponent in the superclass
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		g2D.setStroke(new BasicStroke(2.5f));
		g2D.setColor(Color.BLUE);
		this.drawSnow(g, order, 20, 366,420, 366);
		this.drawSnow(g, order, 420, 366, 220, 20);
		this.drawSnow(g, order, 220, 20, 20, 366);
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
