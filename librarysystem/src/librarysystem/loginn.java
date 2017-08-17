package librarysystem;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
public class loginn {

	private JFrame frame;
	private JTextField textFieldUN;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginn window = new loginn();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	private JTextField txtSample;
	/**
	 * Create the application.
	 */
	public loginn() {
		initialize ();
		connection=sqliteConnection.dbconnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.setBounds(100, 100, 507, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(69, 81, 103, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(69, 204, 83, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		textFieldUN = new JTextField();
		textFieldUN.setBackground(Color.WHITE);
		textFieldUN.setBounds(279, 78, 163, 34);
		frame.getContentPane().add(textFieldUN);
		textFieldUN.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query="select * from librarysystem where Username=? and Password=?";
					 PreparedStatement pst=connection.prepareStatement(query);
					 pst.setString(1, textFieldUN.getText() );
					 pst.setString(2, passwordField.getText() );
                     
					 ResultSet rs=pst.executeQuery();
					 int count = 0;
					 while(rs.next() ) {
						 count = count+1;
					 }
					 if(count==1)   
					 {	 
						 JOptionPane.showMessageDialog(null, "Username and Password is correct");
						 frame.dispose();
						 Issuebook Issbook=new Issuebook();
						 Issbook.setVisible(true);
					 }
					 else if(count>1)
					 {	 
						 JOptionPane.showMessageDialog(null, "Duplicate Username and Password");
					 }
					 else {
						 JOptionPane.showMessageDialog(null, "Username and Password is incorrect Try again..");
					 }
					 
					
					 rs.close();
					 pst.close();
				}catch(Exception e)
				{
				     JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		btnLogin.setBounds(156, 292, 120, 34);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(279, 195, 163, 34);
		frame.getContentPane().add(passwordField);
		
		JLabel lblEnterYourUsername = new JLabel("Enter your Username and Password");
		lblEnterYourUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterYourUsername.setBounds(107, 13, 279, 34);
		frame.getContentPane().add(lblEnterYourUsername);
		
		txtSample = new JTextField();
		txtSample.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		txtSample.setBounds(326, 279, 116, 22);
		frame.getContentPane().add(txtSample);
		txtSample.setColumns(10);
	}
}
