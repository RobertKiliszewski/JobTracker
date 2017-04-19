package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class Registration {

	private JFrame registrationframe;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.registrationframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		registrationframe = new JFrame();
		registrationframe.setBounds(100, 100, 450, 300);
		registrationframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		registrationframe.getContentPane().setLayout(null);
		
		
		textField = new JTextField();
		textField.setBounds(80, 11, 86, 20);
		registrationframe.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(80, 42, 86, 20);
		registrationframe.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(80, 73, 86, 20);
		registrationframe.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(80, 104, 86, 20);
		registrationframe.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(24, 14, 46, 14);
		registrationframe.getContentPane().add(lblName);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setBounds(24, 45, 46, 14);
		registrationframe.getContentPane().add(lblSurname);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(24, 76, 57, 14);
		registrationframe.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(24, 107, 57, 14);
		registrationframe.getContentPane().add(lblPassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{  
					Class.forName("com.mysql.jdbc.Driver").newInstance();  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB","root",""); 
					
							Statement stmt=con.createStatement(); 
							
							ResultSet rs=stmt.executeQuery("insert into users (id, name, surname, username, password) values (1001, 'Test', 'test', 'test', 'test')");  
							
							while(rs.next())  
								System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4) +"  "+rs.getString(5));  
							con.close();  
							}
				catch(Exception e)
				{ 
					  System.err.println("Got an exception!");
				      System.err.println(e.getMessage());
				}  
			}
		});
		btnRegister.setBounds(215, 175, 89, 23);
		registrationframe.getContentPane().add(btnRegister);
		
	}

	public void setVisible(boolean b) {
		this.registrationframe.setVisible(b);
		
	}
}
