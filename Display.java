import java.io.*;
import java.sql.*;  
import java.util.*;

class Display extends DBmanager
{
	public ResultSet rs;
	public PreparedStatement ps;
	DBmanager db = new DBmanager();
	Connection con = db.getCon();
	public void main()
	{
	try 
	{
		System.out.println(" THE PRODUCTS IN THE STORE ");
		ps = con.prepareStatement("select a.pid,a.pname,a.pdesp,b.pqty,b.pprice,b.sprice from prodinfo a,proddet b where a.pid=b.pid");
		rs=ps.executeQuery();
		System.out.println("pid \t pname \t description \t \t pqty \t pprice \t sprice");
		System.out.println("------------------------------------------------------------------------");
		while(rs.next())  
			System.out.println(rs.getInt(1)+"\t "+rs.getString(2)+" \t "+rs.getString(3)+" \t "+rs.getInt(4)+" \t "+rs.getInt(5)+" \t "+rs.getInt(6));
		System.out.println("\n\n THE SALES IN THE STORE ");
		ps = con.prepareStatement("select a.sid,b.pid,b.pname,a.sqty from prodsal a,prodinfo b  where a.pid=b.pid");
		rs=ps.executeQuery();
		System.out.println("sid \t pid \t pname \t sqty ");
		System.out.println("-----------------------------------------");
		while(rs.next())  
			System.out.println(rs.getInt(1)+"\t "+rs.getInt(2)+" \t "+rs.getString(3)+" \t "+rs.getInt(4));
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	}
}