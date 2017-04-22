package main;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.awt.Color;




public class HoursCalc {

	private JFrame frame;
	private JTextField startField;
	private JTextField finishField;
	private JTextField durationField;
	private JTextField dateField;
	private JTextField amountPaid;
	private JTextField rateField;
	public int user_id;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoursCalc window = new HoursCalc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HoursCalc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Day Calculator");
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		startField = new JTextField();
		startField.setBounds(165, 63, 86, 20);
		frame.getContentPane().add(startField);
		startField.setColumns(10);
		
		finishField = new JTextField();
		finishField.setBounds(165, 94, 86, 20);
		frame.getContentPane().add(finishField);
		finishField.setColumns(10);
		
		JLabel startShift = new JLabel("Start:");
		startShift.setForeground(Color.BLACK);
		startShift.setBounds(70, 66, 46, 14);
		frame.getContentPane().add(startShift);
		
		JLabel finishShift = new JLabel("Finish:");
		finishShift.setForeground(Color.BLACK);
		finishShift.setBounds(70, 97, 46, 14);
		frame.getContentPane().add(finishShift);
		
		durationField = new JTextField();
		durationField.setBounds(70, 151, 86, 20);
		frame.getContentPane().add(durationField);
		durationField.setColumns(10);
		
		
		/*										CheckBox								*/
		
		/*										CheckBox								*/
		
		
		dateField = new JTextField();
		dateField.setBounds(165, 32, 86, 20);
		frame.getContentPane().add(dateField);
		dateField.setColumns(10);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setForeground(Color.BLACK);
		lblDate.setBounds(70, 35, 46, 14);
		frame.getContentPane().add(lblDate);
		
		JLabel lblDuration = new JLabel("Duration:");
		lblDuration.setForeground(Color.BLACK);
		lblDuration.setBounds(10, 154, 89, 14);
		frame.getContentPane().add(lblDuration);
		
		JLabel lblAmountPaid = new JLabel("Amount Paid:");
		lblAmountPaid.setForeground(Color.BLACK);
		lblAmountPaid.setBounds(165, 154, 86, 14);
		frame.getContentPane().add(lblAmountPaid);
		
		amountPaid = new JTextField();
		amountPaid.setBounds(275, 151, 86, 20);
		frame.getContentPane().add(amountPaid);
		amountPaid.setColumns(10);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				hourlyCalc();
				
			}
		});
		btnNewButton.setBounds(70, 203, 291, 47);
		frame.getContentPane().add(btnNewButton);
		
		rateField = new JTextField();
		rateField.setBounds(165, 0, 86, 20);
		frame.getContentPane().add(rateField);
		rateField.setColumns(10);
		
		JLabel lblHourlyRate = new JLabel("Hourly Rate:");
		lblHourlyRate.setForeground(Color.BLACK);
		lblHourlyRate.setBounds(70, 3, 89, 14);
		frame.getContentPane().add(lblHourlyRate);
		
		
	}
	
	public void hourlyCalc()
	{
		String date = dateField.getText();
		
		String rate = rateField.getText();
		double totRate = Double.parseDouble(rate);
		
		String start = startField.getText();
		double totStart = Double.parseDouble(start);
		
		String finish = finishField.getText();
		double totFinish = Double.parseDouble(finish);
		
		String duration = durationField.getText();
		double totDuration = Double.parseDouble(duration);
		
		String bAmount = amountPaid.getText();
		double breakAmount = Double.parseDouble(bAmount);
		
		double total = (((totFinish - totDuration) - totStart) * totRate) + breakAmount;
		
		JOptionPane.showMessageDialog(null, "Total Earned on " + date + " is: " + total);
		
		try{     
			 /*								connection									*/ 
			   Class.forName("com.mysql.jdbc.Driver").newInstance();
			   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=");
			   Statement st = con.createStatement();
		   
			   st.executeUpdate("insert into Hours(date_worked, earned, user_ID) VALUES( '"+date+"','"+total+"','"+user_id+"')");
			   JOptionPane.showConfirmDialog(null, "Added To Your Days", "Days", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
			   st.close();
			   con.close();
		   }
		   catch(Exception e){
		       e.printStackTrace();
		      
		   }       
	}

	public void setVisible(boolean b) {
		this.frame.setVisible(b);
		
	}
}
