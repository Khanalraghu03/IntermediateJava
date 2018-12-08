package chapter13.temperaturescaleconversion;

import java.awt.event.ActionEvent;

public interface TemperatureScaleConverter  {

	/*6 methods to convert from
	 *  Celsius to Fahrenheit, 
	 * Celsius to Kelvin,
	 *  Fahrenheit to Celsius, 
	 *  Fahrenheit to Kelvin, 
	 *  Kelvin to Celsius 
	 *  and Kelvin to Fahrenheit
	 * */
	
	public double celsiusToFahrenheit(double temperature);
	public double celsiusToKelvin(double temperature);
	public double fahrenheitToCelsius(double temperature);
	public double fahrenheitToKelvin(double temperature);
	public double kelvinToCelsius(double temperature);
	public double kelvinToFahrenheit(double temperature);
	

}
