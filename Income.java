import java.io.*;
import java.sql.*;  
import java.util.*;

class Income extends DBmanager
{
	public ResultSet rs;
	public PreparedStatement ps;
	
	public void main()
	{
		DBmanager db = new DBmanager();
		try 
		{
			Connection con = db.getCon();
			System.out.println("INCOME / PROFIT");
			System.out.println("pid \t pname \t sqty \t pprice \t tpprice \t sprice \t tsprice \t profit");
			System.out.println("-----------------------------------------------------------------------------------------------");
			ps = con.prepareStatement("select a.pid,a.pname,c.sqty,b.pprice,(c.sqty*b.pprice),b.sprice,(c.sqty*b.sprice),((c.sqty*b.sprice)-(c.sqty*b.pprice)) from prodinfo a,proddet b,prodsal c  where b.pid=c.pid && a.pid=c.pid");  
			rs=ps.executeQuery();
			while(rs.next())  
				System.out.println(rs.getInt(1)+" \t "+rs.getString(2)+" \t "+rs.getInt(3)+" \t "+rs.getInt(4)+" \t "+rs.getInt(5)+" \t "+rs.getInt(6)+" \t "+rs.getInt(7)+" \t "+rs.getInt(8));
			System.out.println("\n\n\nINCOME");
			System.out.println("--------------");
			ps = con.prepareStatement("select sum((b.sqty*a.sprice)-(b.sqty*a.pprice)) from proddet a, prodsal b where a.pid=b.pid");
			rs=ps.executeQuery();
			while(rs.next())  
				System.out.println(rs.getInt(1));
		}
		catch (Exception e) 
		{
            e.printStackTrace();
        }
	}
}