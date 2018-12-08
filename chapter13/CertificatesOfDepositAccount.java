/**
 * 
 */
package chapter13;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableColumnModel;

/**
 * @author Raghu Khanal
 *
 */
//Interface is a construct similar to an abstract class except that it can contain only constants and
	//abstract methods
//Because in java, a class can extend only one other class, interfaces are used to provide
	//additional behavior that must be implemented in the class using the interface.
//In java, a class can implement multiple interfaces

public class CertificatesOfDepositAccount extends SavingsAccount
	implements ActionListener, IncomeTaxDeduction {
	
	private int numberOfMonths;
	private boolean accountOpen;
	
	private JFrame frame;
	private JButton addInterestButton;
	private JButton deductFeeButton;
	private JButton closeAccount;
	private JLabel outputLabel;
	/* Component to control the layout of the buttons and label
	 * Default layout is called FlowLayout. This layout orders
	 * 		components in the sequence they are added to a container
	 * This means the components will appear one after the other
	 * 		in the same sequence that they are added*/	
	private JPanel panel = new JPanel();
	
	
	
	public CertificatesOfDepositAccount(int bankAccountNumber,double balance, 
			double accountMaintendenceFee, int numberOfMonths,boolean accountOpen) {
		super(bankAccountNumber, balance, accountMaintendenceFee);
		this.numberOfMonths = numberOfMonths;
		this.accountOpen = accountOpen;
		
		this.frame = new JFrame();
		this.addInterestButton = new JButton("Add Interest");
		this.deductFeeButton = new JButton("Deduct Fee");
		this.closeAccount = new JButton("Close Account");
		this.outputLabel = new JLabel("Balance: " + this.getBalance());
		this.panel = new JPanel();
		
		//Add buttons to the panel
		panel.add(addInterestButton);
		panel.add(deductFeeButton);
		panel.add(closeAccount);
		panel.add(outputLabel);
		
		//Add panel to the frame
		frame.add(panel);
		/*
		 * Set the size of a button to 480 X 110 pixels
		 * Exit the program when the window is closed
		 * Make the window visible, but nor resizable
		 * Make this object the event handler. */
		addInterestButton.setPreferredSize(new Dimension(150, 30));
		deductFeeButton.setPreferredSize(new Dimension(150, 30));
		closeAccount.setPreferredSize(new Dimension(150, 30));
		frame.setSize(480,110); //480,110
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		
		addInterestButton.addActionListener(this); //when you call it in the main method by calling
		deductFeeButton.addActionListener(this);
		closeAccount.addActionListener(this);
	}

	
	public CertificatesOfDepositAccount(int bankAccountNumber, double balance, double accountMaintendenceFee) {
		// TODO Auto-generated constructor stub
		super(bankAccountNumber, balance, accountMaintendenceFee);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == addInterestButton) {
			addMonthlyInterest();
			outputLabel.setText(String.format("Balance: %.2f;"
					+ "Add Interest", this.getBalance()));
			
		} else if  (e.getSource() == deductFeeButton) {
			deductAccountMaintenanceFee();
			outputLabel.setText(String.format("Balance: %.2f;"
					+ "Deduct Fee", this.getBalance()));
					
		} else {
			outputLabel.setText(String.format("Balance: %.2f;"
					+ "Close Account", this.getBalance()));
			closeAccount();
				
			}
	}

	@Override
	public double deductIncomeTax() {
		double incomeTax = this.getBalance() * TAX_RATE * this.numberOfMonths/ 1200.0;

		return super.withdraw(incomeTax);
	}
	
	
	@Override 
	public double addMonthlyInterest() {
		if(numberOfMonths > 0 && accountOpen) {
			numberOfMonths--;
			super.addMonthlyInterest();
			outputLabel.setText(String.format("Balance: %.2f; " 
			+ "Added monthly interest.", this.getBalance()));
			return this.getBalance(); 
		}
		else if (numberOfMonths <= 0 && accountOpen) {
			outputLabel.setText(String.format("Balance: %.2f; " 
					+ "Close Account.", this.getBalance()));
					return this.getBalance();
		}
		else {
			outputLabel.setText(String.format("Account is closed on the label"));
			return this.getBalance();
		}
	}
	
	
	public double deductAccountMaintenanceFee() {
		if(numberOfMonths > 0 && accountOpen) {
			numberOfMonths = 0;
			super.withdraw(this.getAccountMaintendenceFee());
			outputLabel.setText(String.format("Balance: %.2f; Close account.", this.getBalance()));
			
		}
		else if(numberOfMonths <= 0 && accountOpen) {
			outputLabel.setText(String.format("Balance: %.2f; Close account.", this.getBalance()));
			
		}
		else {
			outputLabel.setText("Close account.");
		}
		return this.getBalance();
	}
	
	
	//Implement
	public double closeAccount() {
		deductAccountMaintenanceFee();
		accountOpen = false;
		super.withdraw(this.getBalance());
		outputLabel.setText("Account is closed");
		return this.getBalance();
	}

}
