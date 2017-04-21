package main;

/*				Imports					*/
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;
/*				Imports					*/

public class JobTracker extends Settings {

	private JFrame jobTrackerFrame;
	private JTextField hoursField;
	private JTextField weekNoField;
	private JTextField rateField;
	private JTextField uscField;
	private JTextField prsiField;
	private JTextField payeField;
	public int user_id;

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
		JLabel lblHoursWorked = new JLabel("Hours Worked ");
		lblHoursWorked.setBounds(192, 192, 208, 14);
		jobTrackerFrame.getContentPane().add(lblHoursWorked);
		
		hoursField = new JTextField();
		hoursField.setBounds(192, 207, 232, 49);
		jobTrackerFrame.getContentPane().add(hoursField);
		hoursField.setColumns(10);
		/*						 Hours Field							 */
		
		
		/*						Week Number Field						*/
		weekNoField = new JTextField();
		weekNoField.setBounds(50, 207, 86, 49);
		jobTrackerFrame.getContentPane().add(weekNoField);
		weekNoField.setColumns(10);
		
		JLabel lblWeekNo = new JLabel("Week No.(Eg.24)");
		lblWeekNo.setBounds(50, 192, 125, 14);
		jobTrackerFrame.getContentPane().add(lblWeekNo);
		/*						Week Number Field						*/
		
		
		/*				Calculate button						*/
		JButton btnCalculate = new JButton("After Tax");
		btnCalculate.addActionListener(new ActionListener() {
			/*			Button Click Action Listener			*/
			public void actionPerformed(ActionEvent e) {
				totalCalc();
				
			}
		});
		
		/*			Button Click Action Listener			*/
		
		btnCalculate.setBounds(233, 267, 191, 83);
		jobTrackerFrame.getContentPane().add(btnCalculate);
		
		JRadioButton partTimeRadio = new JRadioButton("Part Time");
		partTimeRadio.setBounds(6, 11, 109, 23);
		jobTrackerFrame.getContentPane().add(partTimeRadio);
		
		JRadioButton fullTimeRadio = new JRadioButton("Full Time");
		fullTimeRadio.setBounds(117, 11, 109, 23);
		jobTrackerFrame.getContentPane().add(fullTimeRadio);
		
		rateField = new JTextField();
		rateField.setBounds(117, 41, 86, 20);
		jobTrackerFrame.getContentPane().add(rateField);
		rateField.setColumns(10);
		
		uscField = new JTextField();
		uscField.setBounds(117, 72, 86, 20);
		jobTrackerFrame.getContentPane().add(uscField);
		uscField.setColumns(10);
		
		prsiField = new JTextField();
		prsiField.setBounds(338, 41, 86, 20);
		jobTrackerFrame.getContentPane().add(prsiField);
		prsiField.setColumns(10);
		
		payeField = new JTextField();
		payeField.setBounds(338, 72, 86, 20);
		jobTrackerFrame.getContentPane().add(payeField);
		payeField.setColumns(10);
		
		JLabel lblRate = new JLabel("Rate");
		lblRate.setBounds(26, 41, 46, 14);
		jobTrackerFrame.getContentPane().add(lblRate);
		
		JLabel lblUsc = new JLabel("Usc");
		lblUsc.setBounds(26, 75, 46, 14);
		jobTrackerFrame.getContentPane().add(lblUsc);
		
		JLabel lblPrsi = new JLabel("Prsi");
		lblPrsi.setBounds(250, 41, 46, 14);
		jobTrackerFrame.getContentPane().add(lblPrsi);
		
		JLabel lblPaye = new JLabel("Paye");
		lblPaye.setBounds(250, 75, 46, 14);
		jobTrackerFrame.getContentPane().add(lblPaye);
		
		
		
		JButton button = new JButton("Before Tax");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beforeDeducCalc();
			}
		});
		button.setBounds(6, 267, 191, 83);
		jobTrackerFrame.getContentPane().add(button);
		/*								Settings BTN						*/
		
		
	}
	/*									This Allows the Frame to be visible if called from another frame via a button				*/
	public void setVisible(boolean b) {
		this.jobTrackerFrame.setVisible(b);
	}
	
	public void totalCalc(){
		String rate = rateField.getText();
		double rateValue = Double.parseDouble(rate);
		
		String hours = hoursField.getText();
		double hoursWorked = Double.parseDouble(hours); 
		
		String usc = uscField.getText();
		double uscValue = Double.parseDouble(usc); 
		
		String prsi = prsiField.getText();
		double prsiValue = Double.parseDouble(prsi); 
		
		String paye = prsiField.getText();
		double payeValue = Double.parseDouble(paye); 
		
		String week = weekNoField.getText();
		int weekNo = Integer.parseInt(week);
		
		double totalEarnings = rateValue * hoursWorked;
		double usersEarnings =  totalEarnings - ((totalEarnings * payeValue) + (totalEarnings *  prsiValue) + (totalEarnings * uscValue)) ;
		try{
			JOptionPane.showMessageDialog(null, usersEarnings);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=");
			Statement st = con.createStatement();
			
			st.executeUpdate("insert into Earnings(week_no, earnings, user_ID) VALUES( '"+weekNo+"','"+usersEarnings+"','"+user_id+"')");
			JOptionPane.showConfirmDialog(null, "Saved", "Earnings", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
			st.close();
			con.close();
		}
		catch(Exception e1)
		{
			 System.out.println("Exception:" + e1);
		}
	}
	
	public void beforeDeducCalc(){
		String rate = rateField.getText();
		double rateValue = Double.parseDouble(rate);
		
		String hours = hoursField.getText();
		double hoursWorked = Double.parseDouble(hours); 
		
		double totalEarnings = rateValue * hoursWorked;
		
		JOptionPane.showMessageDialog(null, String.format("Your monthly payment is $%.2f") + totalEarnings);
	}
	
	public void setUserID(int id){
		this.user_id = id;
	}
}

	
