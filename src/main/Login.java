package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	private JTextField username;
	private JPasswordField passwordField;

	
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
		
		//Exit
		JButton exitbtn = new JButton("Exit");
		exitbtn.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(exitbtn);
	
		exitbtn.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
			    System.exit(0);
			  }
			});
		
		//Login
		JButton loginbtn = new JButton("Login");
		loginbtn.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(loginbtn);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(165, 60, 120, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(165, 105, 120, 14);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(165, 130, 120, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			
			//click register
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnRegister.setBounds(335, 193, 89, 23);
		frame.getContentPane().add(btnRegister);
	}
}
