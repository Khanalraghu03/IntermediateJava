package review;

public class TestSquare{
    public static void main(String[] args){
    	System.out.println("Number of squares before creatig " + "object = " + Square.getNumberOfSquares());
    	
        Square square1 = new Square();
        System.out.println("Number of squares after creating + square1 = + " + Square.getNumberOfSquares());
        Square square2 = new Square(5.0);
        System.out.println("Number of squares after creating + square2 = + " + Square.getNumberOfSquares());
        Square square3 = new Square(10.5);
        System.out.println("Number of squares after creating + square3 = + " + Square.getNumberOfSquares());

        System.out.println();
        
       /* square1.setNumberOfSquares(2);
        square2.setNumberOfSquares(2);
        
        System.out.println();
        
        System.out.println("Number of squares after setting the num of square " + square1.getNumberOfSquares());
        System.out.println("Number of squares after setting the num of square " + square2.getNumberOfSquares());
        
        System.out.println();*/
        
        /*System.out.println("Length of side of square1 = " + square1.getLengthOfSide());
        System.out.println("Length of side of square2 = " + square2.getLengthOfSide());
        System.out.println("Length of side of square3 = " + square3.getLengthOfSide());*/
        
        System.out.println(square1);
        System.out.println("The area of the square 1 = "+ square1.getArea());
        System.out.println("The perimeter of the square 1 = " + square1.getPerimeter());
        System.out.printf("The diagonal of the square 1 = %.2f \n",square1.getDiagonal());
        
        System.out.println();
        
        System.out.println(square2);
        System.out.println("The area of the square 2 = "+ square2.getArea());
        System.out.println("The perimeter of the square 2 = " + square2.getPerimeter());
        System.out.printf("The diagonal of the square 2 = %.2f \n",square2.getDiagonal());
        
        System.out.println();
        
        System.out.println(square3);
        System.out.println("The area of the square 3 = "+ square3.getArea());
        System.out.println("The perimeter of the square 3 = " + square3.getPerimeter());
        System.out.printf("The diagonal of the square 3 = %.2f \n",square3.getDiagonal());

    }
}