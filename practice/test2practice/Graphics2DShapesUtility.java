package practice.test2practice;

import java.io.File;
import java.util.ArrayList;

public class Graphics2DShapesUtility <E> {
    private ArrayList<WhiteSpaceArea> list;
    private File file;

    public Graphics2DShapesUtility(ArrayList<WhiteSpaceArea> list,
                                   File file) {
        this.list = list;
        this.file = file;
    }

    //Setters


    public void setList(ArrayList<WhiteSpaceArea> list) {
        this.list = list;
    }

    public void setFile(File file) {
        this.file = file;
    }

    //Getters
    public ArrayList<WhiteSpaceArea> getList() {
        return list;
    }

    public File getFile() {
        return file;
    }

    //ToString
    @Override
    public String toString() {
        return "Graphics2DShapesUtility{" +
                "list=" + list +
                ", file=" + file +
                '}';
    }

    public double totalWhiteSpaceArea(double[] values, int lengthOfArray) {
        int vLength = values.length;
        double total = 0;
        if(lengthOfArray == 0) {
            return total;
        }
        else {
//            for(int i = 0; i < lengthOfArray -1; i++) {
//                total += values[i];
//            }
            return 0;
//                    (totalWhiteSpaceArea(values,lengthOfArray);
        }

    }

    public double totalWhiteSpaceArea() {
        return 0;
    }

    public void writeGraphic2dShapesToFile(ArrayList<WhiteSpaceArea> list) {
        //file; //Write color, filled & lengthOfSide of all obj. to text file
        //appers on separate line in text file(look on page 3)
//        totalWhiteSpaceArea();

    }


}
