package main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Settings {
	
	private float rate;

	JFrame settingsFrame;
	private JTextField prsiField;
	private JTextField uscField;
	private JTextField payeField;
	private JTextField rateField;
	private JButton btnSave;
	private JRadioButton partTimeRadioBtn;
	private JRadioButton fullTimeRadioBtn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Settings window = new Settings();
					window.settingsFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Settings() {
		initialize();
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */

	public void initialize() {
		
		settingsFrame = new JFrame();
		settingsFrame.setBounds(100, 100, 450, 300);
		settingsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		settingsFrame.getContentPane().setLayout(null);
				
		partTimeRadioBtn = new JRadioButton("Part Time");
		partTimeRadioBtn.setBounds(6, 7, 109, 23);
		settingsFrame.getContentPane().add(partTimeRadioBtn);
		
		fullTimeRadioBtn = new JRadioButton("Full Time");
		fullTimeRadioBtn.setBounds(117, 7, 109, 23);
		settingsFrame.getContentPane().add(fullTimeRadioBtn);
		
		

		
		partTimeRadioBtn.setActionCommand(partTimeRadioBtn.getText());
		fullTimeRadioBtn.setActionCommand(fullTimeRadioBtn.getText());
		
		/*												PRSI																	*/
		JLabel lblPrsi = new JLabel("PRSI");
		lblPrsi.setBounds(10, 73, 46, 14);
		settingsFrame.getContentPane().add(lblPrsi);
		
		prsiField = new JTextField();
		prsiField.setBounds(100, 70, 86, 20);
		settingsFrame.getContentPane().add(prsiField);
		prsiField.setColumns(10);
		/*												PRSI																	*/
		
		
		/*												USC																	*/
		JLabel lblUsc = new JLabel("USC");
		lblUsc.setBounds(10, 104, 46, 14);
		settingsFrame.getContentPane().add(lblUsc);
		
		uscField = new JTextField();
		uscField.setBounds(100, 101, 86, 20);
		settingsFrame.getContentPane().add(uscField);
		uscField.setColumns(10);
		/*												USC																	*/
		
		
		/*												PAYE																	*/
		JLabel lblPaye = new JLabel("PAYE");
		lblPaye.setBounds(10, 135, 46, 14);
		settingsFrame.getContentPane().add(lblPaye);
		
		payeField = new JTextField();
		payeField.setBounds(100, 132, 86, 20);
		settingsFrame.getContentPane().add(payeField);
		payeField.setColumns(10);
		/*												PAYE																	*/
		
		
		/*												RATE																	*/
		JLabel lblRate = new JLabel("Rate");
		lblRate.setBounds(10, 203, 46, 14);
		settingsFrame.getContentPane().add(lblRate);
		
		rateField= new JTextField();
		rateField.setBounds(100, 200, 86, 20);
		settingsFrame.getContentPane().add(rateField);
		rateField.setColumns(10);
		
		
		/*												RATE																	*/
		
		
		/*												Save BTN																	*/
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selection();
			}
		});
		btnSave.setBounds(335, 227, 89, 23);
		settingsFrame.getContentPane().add(btnSave);
	
		/*												Save BTN																	*/
	}

	public void setVisible(boolean b) {
		this.settingsFrame.setVisible(b);
		

	}
	public void selection(){
		if(partTimeRadioBtn.isSelected()){
			JOptionPane.showMessageDialog(null, "part");
		}
		
		else if (fullTimeRadioBtn.isSelected()){
			JOptionPane.showMessageDialog(null, "full");
		}
		
	}
	
	public void setRate(){
		String rateValue = rateField.getText();
		this.rate = Integer.parseInt(rateValue);	
	}
	public float getRate(){
		return rate ;
	}
	
	
}
