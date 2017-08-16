package librarysystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Issuebook extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Issuebook frame = new Issuebook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Issuebook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIssueBook = new JButton("Issue Book");
		btnIssueBook.setBackground(Color.RED);
		btnIssueBook.setForeground(Color.BLACK);
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 this.setVisible(true);
			        new Issuebook1().setVisible(true); 
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnIssueBook.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnIssueBook.setBounds(122, 63, 138, 35);
		contentPane.add(btnIssueBook);
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.setBackground(Color.RED);
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				this.setvisible(true);
		        new Return().setVisible(true); 
			}

			private void setvisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnReturnBook.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReturnBook.setBounds(122, 131, 138, 35);
		contentPane.add(btnReturnBook);
		
		JButton btnLogout = new JButton("LogOut");
		btnLogout.setBackground(Color.RED);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 {	 
					 JOptionPane.showMessageDialog(null, "you have been succesfully logout");
				 }
				
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogout.setBounds(139, 198, 97, 25);
		contentPane.add(btnLogout);
	}
}
