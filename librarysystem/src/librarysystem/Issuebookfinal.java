package librarysystem;
import java.awt.EventQueue;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
public class Issuebookfinal extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtBookName;
	private JTextField textAuthor;
	private JTextField textIssueDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Issuebookfinal frame = new Issuebookfinal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
     Connection connection1=null;
	/**
	 * Create the frame.
	 */
	public Issuebookfinal() {
		connection1=sqliteConnection1.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIsbnNo = new JLabel("ISBN No.");
		lblIsbnNo.setBounds(50, 51, 67, 16);
		contentPane.add(lblIsbnNo);
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setBounds(50, 93, 67, 16);
		contentPane.add(lblBookName);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(50, 137, 56, 16);
		contentPane.add(lblAuthor);
		
		JLabel lblIssueDate = new JLabel("Issue Date");
		lblIssueDate.setBounds(50, 177, 67, 16);
		contentPane.add(lblIssueDate);
		
		JButton btnIssueBook = new JButton("Issue Book");
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {

				try {
					String query="select * from Bookdetail where Isbn No.=? and Book Name=? and Author=? and Issue date=?";
					 PreparedStatement pst=connection1.prepareStatement(query);
					 pst.setString(1, textField.getText() );
					 pst.setString(2, txtBookName.getText() );
					 pst.setString(3, textAuthor.getText() );
					 pst.setString(4, textIssueDate.getText() );
					 
                     
					 ResultSet rs=pst.executeQuery();
					 int count =0;
					 while(rs.next() ) 
						 count++;
					 {
						 int isbnno =rs.getInt("textField");
						 String BookNam =rs.getString(txtBookName);
						 String authNam =rs.getString(textAuthor);
						 String issuedate =rs.getDate(textIssueDate);
						 System.out.println(
								 "textField =" +isbnno
								 + ", txtBookName =" +BookNam
								 + ", authNam =" +authNam
								 + ", textIssueDate =" +issuedate);
					 }
					 rs.close ();
					 s.close ();
					 System.out.println(count + "rows were retrieved");
								 
				}
			}
					 if(count==1)
					 {	 
						 JOptionPane.showMessageDialog(null, "Your book issued");
					 }
					 
					 else {
						 JOptionPane.showMessageDialog(null, "Details are incorrect Try Again..");
					 }
					 
					 rs.close();
					 pst.close();
			}catch(Exception e11)
			{
			     JOptionPane.showMessageDialog(null, e11);
			}
				};
			});
		btnIssueBook.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIssueBook.setBounds(136, 215, 107, 25);
		contentPane.add(btnIssueBook);
		
		textField = new JTextField();
		textField.setBounds(262, 48, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtBookName = new JTextField();
		txtBookName.setBounds(262, 90, 116, 22);
		contentPane.add(txtBookName);
		txtBookName.setColumns(10);
		
		textAuthor = new JTextField();
		textAuthor.setBounds(262, 134, 116, 22);
		contentPane.add(textAuthor);
		textAuthor.setColumns(10);
		
		textIssueDate =new JTextField();
		textIssueDate.setBounds(262, 174, 116, 22);
		contentPane.add(textIssueDate);
		textIssueDate.setColumns(10);
	}
}
