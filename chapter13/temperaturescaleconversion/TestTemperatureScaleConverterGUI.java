package chapter13.temperaturescaleconversion;

public class TestTemperatureScaleConverterGUI {
	public static void main(String[] args) {
		TemperatureScaleConverterGUI test = new TemperatureScaleConverterGUI(26.5, true);
		test.writeTemperaturesToFile("");
	}
}
