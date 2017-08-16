package librarysystem;
import java.sql.*;
import javax.swing.*;
public class sqliteConnection {
    Connection conn=null;
	public static Connection dbconnector ()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\yuvraj singh\\eclipse-workspace\\librarysystem.sqlite");
			JOptionPane.showMessageDialog(null, "connection is succesful");
			return conn;
			
		}catch(Exception e)
		{
		     JOptionPane.showMessageDialog(null, e);
		     return null;
		}
	
	}

	
}



