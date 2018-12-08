package chapter13.temperaturescaleconversion;

import java.util.ArrayList;

public abstract class TemperatureLog {
	protected ArrayList<String> temperatures;
	
	public TemperatureLog() {
		temperatures = new ArrayList<>();
	}
	
	public ArrayList<String> getTemperatures() {
		return temperatures;
	}
	
	public void setTemperatures(ArrayList<String> temperature) {
		this.temperatures = temperature;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TemperatureLog [temperatures=" + temperatures + "]";
	}
	
	public abstract void writeTemperaturesToFile(String filename);
	
	
	
}
