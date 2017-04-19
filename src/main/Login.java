package main;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;


public class Login extends Registration{

	private JFrame frame;
	private JTextField username;
	private JPasswordField passwordField;

	/*                                             DB CONNECTION                                                                                  */
	class MysqlCon{  
		
		public void main(String args[]){  
			try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root"); 
				
						//here sonoo is database name, root is username and password  
						Statement stmt=con.createStatement(); 
						
						ResultSet rs=stmt.executeQuery("select * from Users");  
						
						while(rs.next())  
							System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
						con.close();  
						}
			catch(Exception e)
			{ 
				System.out.println(e);
			}  
		}  
	}  

	/*                                             DB CONNECTION                                                                                  */
	/**
	 * Launch the application.
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
		username = new JTextField();
		username.setBounds(165, 85, 120, 20);
		frame.getContentPane().add(username);
		username.setColumns(10);
		username.setHorizontalAlignment(JTextField.CENTER);
		
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
		loginbtn.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(loginbtn);
		
		//Label	Username
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(165, 60, 120, 14);
		frame.getContentPane().add(lblUsername);
		
		//Label Password
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(165, 105, 120, 14);
		frame.getContentPane().add(lblPassword);
		
		//Password field
		passwordField = new JPasswordField();
		passwordField.setBounds(165, 130, 120, 20);
		frame.getContentPane().add(passwordField);
		
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
}
