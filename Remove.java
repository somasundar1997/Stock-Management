import java.io.*;
import java.sql.*;  
import java.util.*;

class Remove extends DBmanager
{
	public ResultSet rs;
	public PreparedStatement ps;
	
	public void main()
	{
		try 
		{
			DBmanager db = new DBmanager();
			Connection con = db.getCon();
			ps = con.prepareStatement("select pid,pname from prodinfo");
			rs=ps.executeQuery();
			System.out.println("pid\tpname");
			System.out.println("-----------------");
			while(rs.next())  
				System.out.println(rs.getInt(1)+"\t "+rs.getString(2));
			System.out.println("ENTER THE PRODUCT ID TO REMOVE");
			Scanner sc5 = new Scanner(System.in);
			int num = sc5.nextInt();
			ps = con.prepareStatement("Select * from prodinfo where pid=?");
			ps.setInt(1,num);
			rs = ps.executeQuery();
			int i=0;
			while(rs.next())
			{
				i++;
			}
			if(i==1)
			{
				ps = con.prepareStatement("Delete from prodsal where pid = ?");
				ps.setInt(1,num);
				ps.executeUpdate();
				ps = con.prepareStatement("Delete from proddet where pid = ?");
				ps.setInt(1,num);
				ps.executeUpdate();
				ps = con.prepareStatement("Delete from prodinfo where pid = ?");
				ps.setInt(1,num);
				ps.executeUpdate();
				System.out.println("STOCK REMOVED");
			}
			else
			{
				System.out.println("PRODUCT DOES NOT EXIST");
			}
		}
		catch (Exception e) 
		{
            e.printStackTrace();
        }
        
	}
}