package main;

/*				Imports					*/
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
/*				Imports					*/


public class Login extends Registration{

	private JFrame loginFrame;
	private JTextField usernameField;
	private JPasswordField passwordField;
	public int user_id;


		/*
	 	/* Launch the application.
		 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.loginFrame.setVisible(true);
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
		loginFrame = new JFrame("Login");
		loginFrame.getContentPane().setBackground(Color.DARK_GRAY);
		loginFrame.setBounds(100, 100, 350, 150);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.getContentPane().setLayout(null);
		loginFrame.setLocationRelativeTo(null);
		
		
		/*											Username								 */
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setBounds(10, 11, 120, 14);
		loginFrame.getContentPane().add(lblUsername);
		
		usernameField = new JTextField();
		usernameField.setBounds(100, 8, 120, 20);
		loginFrame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		usernameField.setHorizontalAlignment(JTextField.CENTER);
		/*											Username								 */
		
		
		/*											Password								 */
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setBounds(10, 39, 120, 14);
		loginFrame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 36, 120, 20);
		loginFrame.getContentPane().add(passwordField);
		passwordField.setHorizontalAlignment(JTextField.CENTER);
		/*											Password								 */
		
		
		/*											Login BTN								 */
		JButton loginbtn = new JButton("Login");
		loginbtn.setBackground(Color.LIGHT_GRAY);
		/*				Login Action Listener				*/
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 if(usernameField.getText().length()==0){  // Checking for empty field
				      JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
				 }
				 
				   else if(passwordField.getPassword().length==0){  // Checking for empty field
				      JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
				   }
				 
				   else{
				       String user = usernameField.getText();   // Collecting the input
				       char[] pass = passwordField.getPassword(); // Collecting the input
				       String pwd = String.copyValueOf(pass);// converting from array to string
				       
				       if(validate_login(user,pwd)){
				    	   
				    	  loginFrame.dispose();
				    	  JobTracker j = new JobTracker();
				          j.setVisible(true);
				          j.setUserID(user_id);
				          
				       }   
				       else{
				          JOptionPane.showMessageDialog(null, "Incorrect Details!");
				       }     
				   }
			}
		});		
		/*								Login Action Listener								*/
		loginbtn.setBounds(230, 35, 89, 23);
		loginFrame.getContentPane().add(loginbtn);
		/*											Login BTN								 */
		
		/*											Exit BTN								 */
		JButton exitbtn = new JButton("Exit");
		exitbtn.setBackground(Color.LIGHT_GRAY);
		exitbtn.setBounds(10, 64, 89, 23);
		loginFrame.getContentPane().add(exitbtn);
		
		//Exit Button on click
		exitbtn.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
			    System.exit(0);
			  }
			});
		/*											Exit BTN								 */
		

		/*								Register BTN											*/
		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(Color.LIGHT_GRAY);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Registration f = new Registration();
				f.setVisible(true);
				
			}
		});
		btnRegister.setBounds(230, 7, 89, 23);
		loginFrame.getContentPane().add(btnRegister);
		/*								Register BTN											*/
		
	}
	
	/*		This function does login validation while connection to the database, it checks if the fields are filled out, then proceeds to check the database for the same username and same password */
		private boolean validate_login(String username,String password) {
			   try{     
			       Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
			       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?" + "user=root&password=");     
			       PreparedStatement pst = conn.prepareStatement("Select * from users where username=? and password=?");
			       pst.setString(1, username); 
			       pst.setString(2, password);
			       ResultSet rs = pst.executeQuery();                        
			       if(rs.next()){
			    	   user_id = rs.getInt("id");
			    	   return true;   
			       }
			       else
			           return false;            
			   }
			   catch(Exception e){
			       e.printStackTrace();
			       return false;
			   }       
			}
}
