package main;

/*				Imports					*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*				Imports					*/

public class JobTracker extends Settings {

	private JFrame jobTrackerFrame;
	private JTextField hoursField;

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
	public void initialize() {
		jobTrackerFrame = new JFrame("JobTracker");
		jobTrackerFrame.setBounds(200, 200, 450, 400);
		jobTrackerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jobTrackerFrame.setLocationRelativeTo(null);
		jobTrackerFrame.getContentPane().setLayout(null);
		
		/*						 Hours Field							 */
		hoursField = new JTextField();
		hoursField.setBounds(98, 93, 232, 49);
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
		
		btnCalculate.setBounds(50, 267, 333, 83);
		jobTrackerFrame.getContentPane().add(btnCalculate);
		
		
		/*								Settings BTN						*/
		JButton btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Settings s = new Settings();
				s.setVisible(true);
			}
		});
		btnSettings.setBounds(335, 11, 89, 23);
		jobTrackerFrame.getContentPane().add(btnSettings);
		/*								Settings BTN						*/
		
		
		
		
		
	}
	/*									This Allows the Frame to be visible if called from another frame via a button				*/
	public void setVisible(boolean b) {
		this.jobTrackerFrame.setVisible(b);
	}
}

	
