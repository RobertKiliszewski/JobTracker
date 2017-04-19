package main;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;


public class Login extends Registration{

	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;

		/*
	 	/* Launch the application.
		 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Login");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Username
		usernameField = new JTextField();
		usernameField.setBounds(165, 85, 120, 20);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		usernameField.setHorizontalAlignment(JTextField.CENTER);
		
		//Password field
		passwordField = new JPasswordField();
		passwordField.setBounds(165, 130, 120, 20);
		frame.getContentPane().add(passwordField);
		passwordField.setHorizontalAlignment(JTextField.CENTER);
		
		//Exit Button
		JButton exitbtn = new JButton("Exit");
		exitbtn.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(exitbtn);
		
		//Exit Button on click
		exitbtn.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
			    System.exit(0);
			  }
			});
		
		//Login
		JButton loginbtn = new JButton("Login");
		/*				Login Action Listener				*/
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 if(usernameField.getText().length()==0)  // Checking for empty field
				      JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
				   else if(passwordField.getPassword().length==0)  // Checking for empty field
				      JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
				   else{
				       String user = usernameField.getText();   // Collecting the input
				       char[] pass = passwordField.getPassword(); // Collecting the input
				       String pwd = String.copyValueOf(pass);  // converting from array to string
				       if(validate_login(user,pwd)){
				          JobTracker j = new JobTracker();
				          j.setVisible(true);
				          }   
				       else{
				          JOptionPane.showMessageDialog(null, "Incorrect Login Credentials");
				       }     
				   }
			}
		});
		/*				Login Action Listener				*/
		loginbtn.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(loginbtn);
		
		//Label	Username
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(165, 60, 120, 14);
		frame.getContentPane().add(lblUsername);
	
		
		//Register Button
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Registration f = new Registration();
				f.setVisible(true);
				
			}
		});
		btnRegister.setBounds(335, 193, 89, 23);
		frame.getContentPane().add(btnRegister);
	}
	

/*	public boolean compare()
	{   
		try{           
		       Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
		       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?" + "user=root&password=");     
		       PreparedStatement pst = conn.prepareStatement("Select username, password from users");
		       String username = null;
		       pst.setString(1, username); 
		       String password = null;
		       pst.setString(2, password);
		       ResultSet rs = pst.executeQuery();                        
		       if(usernameField.getText() == username && passwordField.getText() == password){
		    	   JobTracker j = new JobTracker();
		    	   j.setVisible(true);
		       }
		       
		       else if (usernameField.getText() != username && passwordField.getText() == password)
		       {
		    	   return false;
		    	   
		       }
		       
		       else if (usernameField.getText() == username && passwordField.getText() != password)
		       {
		    	   return false;
		       }
		        
		       else if (usernameField.getText() != username && passwordField.getText() != password)
		       {
		    	   return false;
		       }
		   }
		   catch(Exception e){
		       e.printStackTrace();
		       return false;
		   }
		return false;
		      
	}*/
		
		private boolean validate_login(String username,String password) {
			   try{           
			       Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
			       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?" + "user=root&password=");     
			       PreparedStatement pst = conn.prepareStatement("Select * from users where username=? and password=?");
			       pst.setString(1, username); 
			       pst.setString(2, password);
			       ResultSet rs = pst.executeQuery();                        
			       if(rs.next())            
			           return true;    
			       else
			           return false;            
			   }
			   catch(Exception e){
			       e.printStackTrace();
			       return false;
			   }       
			}

	
}
