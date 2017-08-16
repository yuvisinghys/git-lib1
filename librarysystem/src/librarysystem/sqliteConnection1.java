package librarysystem;
import java.sql.*;
import javax.swing.*;
public class sqliteConnection1 {
	 Connection conn=null;
		public static Connection dbconnector ()
		{
			try {
				Class.forName("org.sqlite.JDBC");
				Connection connection=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\yuvraj singh\\eclipse-workspace\\Bookdetail.sqlite");
				JOptionPane.showMessageDialog(null, "connection is succesful");
				return connection;
				
			}catch(Exception e)
			{
			     JOptionPane.showMessageDialog(null, e);
			     return null;
			}
		
		}

		
	}

