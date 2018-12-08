package chapter13.temperaturescaleconversion;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TemperatureScaleConverterGUI extends TemperatureLog implements TemperatureScaleConverter, ActionListener {
	private double temperature;
	private boolean makeGUI;
	private File path;
	
	//TextField
	private JTextField textField;
	private JFrame frame;
	//Button of size 180 X 30
	//Window 250 X 350
	private JButton cToFButton;
	private JButton cToKButton;
	private JButton fToCButton;
	private JButton fToKButton;
	private JButton kToCButton;
	private JButton kToFButton;
	private JButton clearButton;
	private JButton writeToFileButton;
	private JLabel labelOutput;
	private JPanel panel;
	
	public TemperatureScaleConverterGUI(double temperature, boolean makeGUI) {
		this.temperature = temperature;
		this.makeGUI = makeGUI;
		this.path = new File("c:/users/khana/desktop/Temperatures_Log/temperatures_log.txt");
		
		if(makeGUI) 
		{

			this.textField = new JTextField(10);
			textField.setText(temperature + "");

			this.frame = new JFrame();
			this.cToFButton = new JButton("Celsius to Fahrenheit");
			this.cToKButton = new JButton("Celsius to Kelvin");
			this.fToCButton = new JButton("Fahrenheit to Celsius");
			this.fToKButton = new JButton("Fahrenheit to Kelvin");
			this.kToCButton = new JButton("Kelvin to Celsius");
			this.kToFButton = new JButton("Kelvin to Fahrenheit");
			this.clearButton = new JButton("Clear");
			this.writeToFileButton = new JButton("Write To File");
			this.labelOutput = new JLabel();
			labelOutput.setText(String.format("Input: %.2f "+(char)176+"C; Output: %.2f "+(char)176+"F", temperature, celsiusToFahrenheit(temperature)));
			this.panel = new JPanel();
			
			panel.add(textField);
			panel.add(cToFButton);
			panel.add(cToKButton);
			panel.add(fToCButton);
			panel.add(fToKButton);
			panel.add(kToCButton);
			panel.add(kToFButton);
			panel.add(clearButton);
			panel.add(writeToFileButton);
			panel.add(labelOutput);
			frame.add(panel);
			
			cToFButton.setPreferredSize(new Dimension(180, 30));
			cToKButton.setPreferredSize(new Dimension(180, 30));
			fToCButton.setPreferredSize(new Dimension(180, 30));
			fToKButton.setPreferredSize(new Dimension(180, 30));
			kToCButton.setPreferredSize(new Dimension(180, 30));
			kToFButton.setPreferredSize(new Dimension(180, 30));
			clearButton.setPreferredSize(new Dimension(180, 30));
			writeToFileButton.setPreferredSize(new Dimension(180, 30));
			
			labelOutput.setPreferredSize(new Dimension(200, 30));
			labelOutput.setHorizontalAlignment(JLabel.CENTER);
		
			frame.setSize(250,400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			frame.setResizable(false);
			
			textField.addActionListener(this);
			cToFButton.addActionListener(this);
			cToKButton.addActionListener(this);
			fToCButton.addActionListener(this);
			fToKButton.addActionListener(this);
			kToCButton.addActionListener(this);
			kToFButton.addActionListener(this);
			clearButton.addActionListener(this);
			writeToFileButton.addActionListener(this);
		
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		try{
			temperature = Double.parseDouble(textField.getText());
			if(e.getSource() == cToFButton) {
				celsiusToFahrenheit(temperature);
				labelOutput.setText(String.format("Input: %.2f"+(char)176 + "C; Output: %.2f"+(char)176+" F ",
						temperature, celsiusToFahrenheit(temperature)));
			}
			else if(e.getSource() == cToKButton) {
				celsiusToKelvin(temperature);
				labelOutput.setText(String.format("Input: %.2f"+(char)176+ "C; Output: %.2f"+" K ",
						temperature, celsiusToKelvin(temperature)));
			}
			else if(e.getSource() == fToCButton) {
				fahrenheitToCelsius(temperature);
				labelOutput.setText(String.format("Input: %.2f"+(char)176 + "F; Output: %.2f"+(char)176+" C ",
						temperature, fahrenheitToCelsius(temperature)));
			}
			else if(e.getSource() == fToKButton) {
				fahrenheitToKelvin(temperature);
				labelOutput.setText(String.format("Input: %.2f"+ (char)176+"F; Output: %.2f"+" K ",
						temperature, fahrenheitToKelvin(temperature)));
			}
			else if(e.getSource() == kToCButton) {
				kelvinToCelsius(temperature);
				labelOutput.setText(String.format("Input: %.2f"+ "K; Output: %.2f"+(char)176+" C ",
						temperature, kelvinToCelsius(temperature)));
			}
			else if(e.getSource() == kToFButton) {
				kelvinToFahrenheit(temperature);
				labelOutput.setText(String.format("Input: %.2f" + "K; Output: %.2f"+(char)176+" F ",
						temperature, kelvinToFahrenheit(temperature)));
			} 
			else if(e.getSource() == writeToFileButton) {
				writeTemperaturesToFile("20,40,77,39");
				temperatures.clear();
				temperatures.add(""+labelOutput);
				//labelOutput.setText(String.format());
				//Add the labelOutput to the file
				
				
			} 
			
			else {
				labelOutput.setText(String.format("No Input"));
			}
		} catch (NumberFormatException ex) {
			labelOutput.setText(String.format("No Input"));
		}
	}


	@Override
	public double celsiusToFahrenheit(double temperature) {
		return (temperature * 9/5) + 32;
	}

	@Override
	public double celsiusToKelvin(double temperature) {
		return temperature + 273.15;
	}

	@Override
	public double fahrenheitToCelsius(double temperature) {
		return (temperature - 32) * 5/9;
	}

	@Override
	public double fahrenheitToKelvin(double temperature) {
		return (temperature + 459.67) * 5/9;
	}

	@Override
	public double kelvinToCelsius(double temperature) {
		return temperature - 273.15;
	}

	@Override
	public double kelvinToFahrenheit(double temperature) {
		return (temperature * 9/5) - 459.67;
	}

	@Override
	public void writeTemperaturesToFile(String filename) {

		boolean fileCreated = false;
		String writer = filename;
		PrintWriter pWriter;
		temperatures.add(""+temperature);
		
		while(!fileCreated) {
			try {
				if(path.createNewFile()) {
					System.out.println("File created in folder "+ "Temperatures_Log");
				}
				else {
					System.out.println("The file already exists");
				}
				fileCreated = true;
				
			} catch (IOException ex) {
				System.out.print("File doesn't exist! \nCreating a new file...");
				
				path.getParentFile().mkdir(); 	//obtain the path up to the folder, and will not include the file
				System.out.println("Folder Temperatures_Log created");
			}
		}
		
		
		try {
			pWriter = new PrintWriter(new FileWriter(path));
			pWriter.write(""+labelOutput);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
	}

}
