package librarysystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Caret;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Issuebook1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtIsbnnum;
	private JTextField txtbooknam;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
		
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Issuebook1 frame = new Issuebook1();
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
	public Issuebook1() {
		connection=sqliteConnection1.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIsbnNo = new JLabel("Isbn No.:");
		lblIsbnNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIsbnNo.setBounds(52, 32, 68, 16);
		contentPane.add(lblIsbnNo);
		
		JLabel lblBookName = new JLabel("Book Name:");
		lblBookName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookName.setBounds(52, 82, 91, 16);
		contentPane.add(lblBookName);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAuthor.setBounds(52, 126, 68, 16);
		contentPane.add(lblAuthor);
		
		JLabel lblIssueDate = new JLabel("Issue Date:");
		lblIssueDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIssueDate.setBounds(52, 168, 78, 16);
		contentPane.add(lblIssueDate);
		
		txtIsbnnum = new JTextField();
		txtIsbnnum.setBounds(236, 29, 116, 22);
		contentPane.add(txtIsbnnum);
		txtIsbnnum.setColumns(10);
		
		txtbooknam = new JTextField();
		txtbooknam.setBounds(236, 79, 116, 22);
		contentPane.add(txtbooknam);
		txtbooknam.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(236, 123, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(236, 165, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnIssueBook = new JButton("Issue book");
		btnIssueBook.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					try {
						String query="select * from BookDetail1 where IsbnNo=?";
						 PreparedStatement pst=connection.prepareStatement(query);
						 pst.setString(1, txtIsbnnum.getText() );					 
	                     
						 ResultSet rs=pst.executeQuery();
						 int count =0;
						 while(rs.next() ) {
							 count=count+1;
							 txtbooknam.setText(rs.getString(2));
							 textField_2.setText(rs.getString(3));
							 textField_3.setText(rs.getString(4));
						 }
						 if(count==1)   
						 {	 
//							
							 
							 JOptionPane.showMessageDialog(null, "Your Book Issued");
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
		btnIssueBook.setBounds(124, 215, 116, 25);
		contentPane.add(btnIssueBook);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				Issuebook issue =new Issuebook();
				issue.setVisible(true);
				
			}
		});
		btnBack.setBounds(323, 216, 97, 25);
		contentPane.add(btnBack);
	}
}

