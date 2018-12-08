package practice.test2practice;

public class RegularHexagon extends Graphics2DShape implements WhiteSpaceArea {

    private double lengthOfSide;


    public RegularHexagon(double x, double y,double width,
                          double height,String color,boolean filled,double lengthOfSide) {
        super(x,y,width,height,color,filled);
        this.lengthOfSide = lengthOfSide;
    }

    public double getLengthOfSide() {
        return lengthOfSide;
    }

    public void setLengthOfSide(double lengthOfSide) {
        this.lengthOfSide = lengthOfSide;
    }

    @Override
    public String toString() {
        return super.toString() + "\nRegularHexagon{" +
                "lengthOfSide=" + lengthOfSide +
                '}';
    }


    @Override
    public double getAreaOf2DShape() {
        return 1.5 * Math.sqrt(3.0) * Math.pow(lengthOfSide, 2);
    }

    @Override
    public double getPerimeterOf2DShape() {
        return 6.0 * lengthOfSide;
    }

    @Override
    public double getWhiteSpaceArea() {

//        double WhiteSpaceArea = getX() - getAreaOf2DShape();
        return 0;
    }
}
