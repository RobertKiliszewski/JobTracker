package main;

/*				Imports					*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
/*				Imports					*/

public class Registration {

	private JFrame registrationframe;
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField usernameField;
	private JTextField passwordField;

	
	
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
		registrationframe.setLocationRelativeTo(null);
		
		
		/*									Name						*/
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(74, 122, 96, 14);
		registrationframe.getContentPane().add(lblName);
		
		nameField = new JTextField();
		nameField.setBounds(180, 119, 86, 20);
		registrationframe.getContentPane().add(nameField);
		nameField.setColumns(10);
		/*									Name						*/
		
		
		/*									Surname						*/
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setBounds(74, 153, 96, 14);
		registrationframe.getContentPane().add(lblSurname);
		
		surnameField = new JTextField();
		surnameField.setBounds(180, 150, 86, 20);
		registrationframe.getContentPane().add(surnameField);
		surnameField.setColumns(10);
		/*									Surname						*/
		
		
		/*									Username						*/
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(74, 60, 96, 14);
		registrationframe.getContentPane().add(lblUsername);
		
		usernameField = new JTextField();
		usernameField.setBounds(180, 57, 86, 20);
		registrationframe.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		/*									Username						*/
		
		
		/*									Password						*/
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(74, 91, 96, 14);
		registrationframe.getContentPane().add(lblPassword);
		
		passwordField = new JTextField();
		passwordField.setBounds(180, 88, 86, 20);
		registrationframe.getContentPane().add(passwordField);
		passwordField.setColumns(10);
		/*									Password						*/
		
		
		/*								Register BTN							*/
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insert();
			}	
		});
		btnRegister.setBounds(335, 193, 89, 23);
		registrationframe.getContentPane().add(btnRegister);
		/*								Register BTN							*/
		
		/*								Cancel BTN							*/
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrationframe.setVisible(false);
			}
		});
		btnCancel.setBounds(335, 227, 89, 23);
		registrationframe.getContentPane().add(btnCancel);
		/*								Cancel BTN							*/
	}
	
	
	/*									This Allows the Frame to be visible if called from another frame via a button				*/
	public void setVisible(boolean b) {
		this.registrationframe.setVisible(b); 
	}
	
	/*										INSERT FUNCTION FOR BUTTON 											*/
	public void insert()
	{   
	    try {
	    	  if(usernameField.getText().length()==0){  // Checking for empty field
			      JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
	    	  }
			   else if(passwordField.getText().length()==0){  // Checking for empty field
				  JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
			   }
			   else if(nameField.getText().length()==0){  // Checking for empty field
				  JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
			   }
			   else if(surnameField.getText().length()==0){  // Checking for empty field
				  JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
			   }
			   else{
				   String username = usernameField.getText();
				   String password = passwordField.getText();
				   String name = nameField.getText();
				   String surname = surnameField.getText();
				  
				   /*		If username exists then username has to be changed in order to create a user 		*/
				   if(userExists(username)){
					   JOptionPane.showMessageDialog(null, "Username Already In use! Please Choose Another Username");
				   }
				   
				   /*									Otherwise create the user							*/
				   else{
				 
					   /*								connection									*/ 
					   Class.forName("com.mysql.jdbc.Driver").newInstance();
					   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=");
					   Statement st = con.createStatement();
				   
			

					   st.executeUpdate("insert into users(username, password, name, surname) VALUES( '"+username+"','"+password+"' ,'"+name+"','"+surname+"')");

					   JOptionPane.showConfirmDialog(null, "User Created!", "User", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
					   
					   st.close();
					   con.close();
					   registrationframe.setVisible(false);
				   }
			 }
	    	  
	    }//try
	    catch (Exception e1)

	    {
	        System.out.println("Exception:" + e1);
	    }
	  
	}//Insert
	
	private boolean userExists(String username) {
		   try{           
			   
		       Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
		       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?" + "user=root&password=");     
		       PreparedStatement pst = conn.prepareStatement("Select username from users where username = ?");
		       pst.setString(1, username); 
		       pst.executeQuery();                        
		       ResultSet rs = pst.executeQuery();                        
		       if(rs.next()){            
		           return true;    
		       }
		   }
		   catch(Exception e){
		       e.printStackTrace();
		       return false;
		   }
		return false;
      
		}
}//Registration

