import java.io.*;
import java.sql.*;  
import java.util.*;

class Add extends DBmanager
{
	public ResultSet rs;
	public PreparedStatement ps;
	public int pid;
	
	public void main()
	{	
		DBmanager db = new DBmanager();
		Connection con = db.getCon();
		try 
		{
            Scanner sc1 = new Scanner(System.in); 
			System.out.println("ENTER PRODUCT NAME");
			String name = sc1.nextLine();
			System.out.println("ENTER PRODUCT DESCRIPTION");
			String desp = sc1.nextLine();
			System.out.println("ENTER PRODUCT QUANTITY");
			int qty = sc1.nextInt();
			System.out.println("ENTER PRODUCT PURCHASE PRICE");
			int pprice = sc1.nextInt();
			System.out.println("ENTER PRODUCT SALES PRICE");
			int sprice = sc1.nextInt();
			ps = con.prepareStatement("insert into prodinfo (pname,pdesp)values (?,?)");
			ps.setString(1,name);
			ps.setString(2,desp);
			ps.executeUpdate();
			ps = con.prepareStatement("select * from prodinfo ORDER BY pid DESC LIMIT 1");
			rs = ps.executeQuery();
			while(rs.next())
				pid = rs.getInt(1);
			ps = con.prepareStatement("insert into proddet (pid,pqty,pprice,sprice)values (?,?,?,?)");
			ps.setInt(1,pid);
			ps.setInt(2,qty);
			ps.setInt(3,pprice);
			ps.setInt(4,sprice);
			ps.executeUpdate();
			System.out.println("STOCK ADDED");
		}
		catch (Exception e) 
		{
            e.printStackTrace();
        }
        
	}
}