import java.io.*;
import java.sql.*;  
import java.util.*;

class Login extends DBmanager
{  
	public static ResultSet rs;
	public static PreparedStatement ps;
	
	public void main()
	{
		DBmanager db = new DBmanager();
        try 
		{
			Connection con = db.getCon();
			Scanner sc = new Scanner(System.in);
			System.out.println("ENTER USERNAME = ");
			String user = sc.nextLine();
			System.out.println("ENTER PASSWORD = ");
			Console console = System.console();
			char[] password = console.readPassword();
			String pass = new String(password);
			ps = con.prepareStatement("select * from users where name=? and pass=?");
			ps.setString(1,user);
			ps.setString(2,pass);
			rs=ps.executeQuery();
			int count=0;
			while(rs.next()){
			count++;
			}
			if(count==1)
			{
				System.out.println("welcome  " + user);
				Products prod= new Products();
				prod.main();
			}
			else
			{
				System.out.println("INVALID USERNAME AND PASSWORD\n CLOSED");
			}
			db.close();
		} 
		catch (Exception e) 
		{
            e.printStackTrace();
        }
		
	}
	
}