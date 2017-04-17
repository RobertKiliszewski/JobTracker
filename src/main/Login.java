package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login {

	private JFrame frame;
	private JTextField username;
	private JTextField password;

	
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Username
		username = new JTextField();
		username.setBounds(175, 85, 86, 20);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		//Password
		password = new JTextField();
		password.setBounds(175, 130, 86, 20);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
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
	}
}
