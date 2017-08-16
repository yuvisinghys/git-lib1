package librarysystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Return extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Return frame = new Return();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	/**
	 * Create the frame.
	 */
	public Return() {
		connection=sqliteConnection1.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIsbnNo = new JLabel("ISBN No.");
		lblIsbnNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIsbnNo.setBounds(70, 30, 68, 16);
		contentPane.add(lblIsbnNo);
		
		JLabel lblReturnDate = new JLabel("Return Date");
		lblReturnDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblReturnDate.setBounds(70, 88, 79, 16);
		contentPane.add(lblReturnDate);
		
		textField = new JTextField();
		textField.setBounds(238, 28, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(238, 86, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Return Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="select * from BookDetail1 where IsbnNo=? and ReturnDate=? and Duedate=?";
					 PreparedStatement pst=connection.prepareStatement(query);
					 pst.setString(1, textField.getText() );
					 pst.setString(2, textField_1.getText() );
					 pst.setString(3, textField_2.getText() );
                     
					 ResultSet rs=pst.executeQuery();
					 int count =0;
					 while(rs.next() ) {
						 count=count+1;
					 }
					 if(count==1)   
					 {	 
						 JOptionPane.showMessageDialog(null, "Your Book Returned");
					 }
					 else if(count>1)
					 {	 
						 JOptionPane.showMessageDialog(null, "Incorrect Information");
					 }
					 else {
						 JOptionPane.showMessageDialog(null, "Incorrect Information please Try again..");
					 }
					 
					 rs.close();
					 pst.close();
				}catch(Exception e)
				{
				     JOptionPane.showMessageDialog(null, e);
				}
				
			}
			});
	
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(136, 205, 129, 35);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Due Date");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(70, 138, 79, 16);
		contentPane.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(238, 136, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.setVisible(false);
				Issuebook issu = new Issuebook();
				issu.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBounds(335, 210, 97, 25);
		contentPane.add(btnBack);
	}
}
