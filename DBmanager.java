import java.sql.*; 

public class DBmanager 
{
	public static Connection con;
	public  Connection getCon()
	{
		if(con==null)
		{
			try
			{
				con=DriverManager.getConnection("jdbc:mysql://localhost:8080/store?useSSL=false","root","12345");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return con;
		}
		else
		{
			return con;
		}
	}
	public Connection close()
	{
		try
		{
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con=null;
	}
	public static void main(String args[])
	{
		Login lo = new Login();
		lo.main();
	}
}