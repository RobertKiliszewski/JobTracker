package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class Registration {

	private JFrame registrationframe;
	private JTextField nameText;
	private JTextField surnameText;
	private JTextField usernameText;
	private JTextField passwordText;

	
	
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
		
		nameText = new JTextField();
		nameText.setBounds(80, 11, 86, 20);
		registrationframe.getContentPane().add(nameText);
		nameText.setColumns(10);
		
		surnameText = new JTextField();
		surnameText.setBounds(80, 42, 86, 20);
		registrationframe.getContentPane().add(surnameText);
		surnameText.setColumns(10);
		
		usernameText = new JTextField();
		usernameText.setBounds(80, 73, 86, 20);
		registrationframe.getContentPane().add(usernameText);
		usernameText.setColumns(10);
		
		passwordText = new JTextField();
		passwordText.setBounds(80, 104, 86, 20);
		registrationframe.getContentPane().add(passwordText);
		passwordText.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(24, 14, 46, 14);
		registrationframe.getContentPane().add(lblName);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setBounds(24, 48, 46, 14);
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
				insert();
			}	
		});
		btnRegister.setBounds(215, 175, 89, 23);
		registrationframe.getContentPane().add(btnRegister);
		
		

	}
	
	public void setVisible(boolean b) {
		this.registrationframe.setVisible(b);
		 
		
	}
	
	public void insert()
	{   
	    try {
	    	String name = nameText.getText();
			String surname = surnameText.getText();
			String username = usernameText.getText();
			String password = passwordText.getText();
	    // connection string
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=");
	        Statement st = con.createStatement();

	        st.executeUpdate("insert into users(name, surname, username, password) VALUES( '"+name+"','"+surname+"' ,'"+username+"','"+password+"')");

	        JOptionPane.showConfirmDialog(null, "Your Data Has been Inserted", "users", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);

	        st.close();
	        con.close();

	    }

	    catch (Exception e1)

	    {
	        System.out.println("Exception:" + e1);
	    }

	}
	
}

