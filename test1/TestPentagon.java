/**
 * 
 */
package test1;

import java.util.ArrayList;

/*
 * @author: Raghu Khanal
 */

public class TestPentagon 
{
	public static void main(String[] args) 
	{
		Pentagon penta1 = new Pentagon();
		System.out.println(penta1.toString());
		
		Pentagon penta2 = new Pentagon("blue",true,220,80,150,310,380,30,
				200,350,350,200,5,5);
		System.out.println(penta2.toString());
		
		ArrayList<GeometricObject> pentaArray = new ArrayList<>();
		pentaArray.add(penta1);
		pentaArray.add(penta2);
		
		System.out.println("\n"+pentaArray.toString());
		
		System.out.println("The window area of Pentagon 1 is "+penta1.getWindowArea());
		System.out.println("The window area of Pentagon 2 is "+penta2.getWindowArea());
		
		GeometricObject geoObj = new GeometricObject();
		System.out.println("The area difference of Pentagon 1 and geometric object is "+penta1.getWindowAreaDifference(geoObj));
		System.out.println("The area difference of Pentagon 2 and geometric object is "+penta2.getWindowAreaDifference(geoObj));
	
		for(int i = 0; i < pentaArray.size(); i++) {
			pentaArray.get(i).setColor("RED");
			pentaArray.get(i).repaint();
			try {
				Thread.sleep(1000);  //1000milli second = 1 sec
			}
			 catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
}