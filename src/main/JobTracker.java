package main;

/*				Imports					*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*				Imports					*/

public class JobTracker {

	private JFrame jobTrackerFrame;
	private JTextField rateField;
	private JTextField taxField;
	private JTextField hoursField;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JobTracker window = new JobTracker();
					window.jobTrackerFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JobTracker() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		jobTrackerFrame = new JFrame("JobTracker");
		jobTrackerFrame.setBounds(200, 200, 650, 500);
		jobTrackerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jobTrackerFrame.setLocationRelativeTo(null);
		jobTrackerFrame.getContentPane().setLayout(null);
		
		
		
		/*						 Rate Field							 */
		JLabel lblRate = new JLabel("Rate/h:");
		lblRate.setBounds(10, 38, 80, 14);
		jobTrackerFrame.getContentPane().add(lblRate);
		
		rateField = new JTextField();
		rateField.setBounds(100, 35, 86, 20);
		jobTrackerFrame.getContentPane().add(rateField);
		rateField.setColumns(10);
		
		
		/*						 Rate Field							 */
		
		
		/*						 Tax Field							 */
		JLabel lblTax = new JLabel("Tax/%:");
		lblTax.setBounds(10, 93, 80, 14);
		jobTrackerFrame.getContentPane().add(lblTax);
		
		taxField = new JTextField();
		lblTax.setLabelFor(taxField);
		taxField.setBounds(100, 90, 86, 20);
		jobTrackerFrame.getContentPane().add(taxField);
		taxField.setColumns(10);
		
		/*						 Tax Field							 */
		
		/*						 Hours Field							 */
		JLabel lblHours = new JLabel("Hours:");
		lblHours.setBounds(10, 148, 46, 14);
		jobTrackerFrame.getContentPane().add(lblHours);
		
		hoursField = new JTextField();
		hoursField.setBounds(100, 145, 86, 20);
		jobTrackerFrame.getContentPane().add(hoursField);
		hoursField.setColumns(10);
		
		/*						 Hours Field							 */
		
		
		/*				Calculate button						*/
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			/*			Button Click Action Listener			*/
			public void actionPerformed(ActionEvent e) {
				//String rateAmount = rateField.getText(); 
				//String taxAmount = taxField.getText();
				
			}
		});
		
		/*			Button Click Action Listener			*/
		
		btnCalculate.setBounds(535, 427, 89, 23);
		jobTrackerFrame.getContentPane().add(btnCalculate);
		
		/*				Calculate button						*/
		
		/*						Exit button								*/
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(10, 427, 89, 23);
		jobTrackerFrame.getContentPane().add(btnExit);
		/*						Exit button								*/
		
	}
	/*									This Allows the Frame to be visible if called from another frame via a button				*/
	public void setVisible(boolean b) {
		this.jobTrackerFrame.setVisible(b);
	}
}

	
