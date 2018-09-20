package review;
public class Square{
    //constructor
    public Square() {
        this.lengthOfSide = 1.0;
        numberOfSquares++;
    }
    public Square(double lengthOfSide) {
        this.lengthOfSide = lengthOfSide;
        numberOfSquares++;
    }

    //Encapsulation: cannot access it outside of a class.
    private double lengthOfSide;
    private static int numberOfSquares;

    //Getter
    public double getLengthOfSide() {
        return lengthOfSide;
    }
    public static int getNumberOfSquares() {
    	return numberOfSquares;
    }

    //Setter
    public void setLengthOfSide(double lengthOfSide) {
        this.lengthOfSide = lengthOfSide;
    }
    public static void setNumberOfSquares(int numberOfSquares){
        Square.numberOfSquares = numberOfSquares;
    }
    
    
   
    /**
     * @return the area of the square
     */
    public double getArea() {
    	return Math.pow(lengthOfSide,2);
    }
    
    /**
     * @return the perimeter of the square
     */
    public double getPerimeter() {
    	return 4*lengthOfSide;
    }
  
  /**
 * @return the diagonal of the sqaure
 */
public double getDiagonal() {
	  return Math.hypot(lengthOfSide, lengthOfSide);
  }  


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Square [lengthOfSide=" + lengthOfSide + "]";
	}
}