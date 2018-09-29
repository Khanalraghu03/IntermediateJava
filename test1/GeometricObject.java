/**
 * 
 */
package test1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;


  /**
  * @author apereira
  *
  */
public class GeometricObject extends JPanel {
	private String color;
	private boolean filled;
	private Date dateCreated;
	private JFrame frame;
	protected Graphics graphics; 
	public static final int SCREEN_RESOLUTION=
			Toolkit.getDefaultToolkit().getScreenResolution();
	public static final int SCREEN_WIDTH=
			Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int SCREEN_HEIGHT=
			Toolkit.getDefaultToolkit().getScreenSize().height;

   /**
   * 
   */
	private static final long serialVersionUID = 1L;

    /**
    * 
    */
	public GeometricObject() {
		this("white", false);
	}

     /**
     * @param color
     * @param filled
     */
	public GeometricObject(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
		this.dateCreated=new Date();
		this.frame= new JFrame(this.getClass().getSimpleName());
		this.frame.add(this);
		this.frame.setSize(100, 100);
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

      /**
      * @return the color
      */
	public String getColor() {
		return color;
	}

       /**
       * @param color the color to set
       */
	public void setColor(String color) {
		this.color = color;
	}

        /**
        * @return the filled
        */
	public boolean isFilled() {
		return filled;
	}

         /**
         * @param filled the filled to set
         */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
/*
	 (non-Javadoc)
          * @see java.lang.Object#toString()
*/
	@Override
	public String toString() {
		return "GeometricObject [color=" + color 
				+ ", filled=" + filled 
				+ ", dateCreated=" + dateCreated 
				+ "]";
	}	
	
	public void paintComponent(Graphics graphics){
		super.paintComponent(graphics);
		this.graphics=graphics;
		drawGeometricObject(this);
	}
	public int getWindowWidth(){
		return 100;
	}
	public int getWindowHeight(){
		return 100;
	}
	
	
	public int getWindowArea() {
		return getWindowWidth() * getWindowHeight();
	}
	
	
	
	public void drawGeometricObject(GeometricObject geomObj){
		int windowWidth = geomObj.getWindowWidth() 
				+ geomObj.frame.getInsets().left 
				+  geomObj.frame.getInsets().right;
		int windowHeight = geomObj.getWindowHeight()
				+ geomObj.frame.getInsets().top 
				+ geomObj.frame.getInsets().bottom;
		if(windowWidth>SCREEN_WIDTH || windowHeight>SCREEN_HEIGHT){
			System.out.println("One or more window dimensions are"
					+ " larger than the screen dimensions. Exiting program...");
			System.exit(0);
		}
		geomObj.frame.setSize(windowWidth, windowHeight);
		if(geomObj.color.equalsIgnoreCase("white"))
			geomObj.graphics.setColor(Color.WHITE);
		else if(geomObj.color.equalsIgnoreCase("blue"))
			geomObj.graphics.setColor(Color.BLUE);
		else if(geomObj.color.equalsIgnoreCase("red"))
			geomObj.graphics.setColor(Color.RED);
		else
			geomObj.graphics.setColor(Color.YELLOW);
	}

	public int getWindowAreaDifference(GeometricObject geometricObject) {
		return geometricObject.getWindowArea() - this.getWindowArea();
	}
}
