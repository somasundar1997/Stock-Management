import java.io.*;
import java.sql.*;  
import java.util.*;

class Sell extends DBmanager
{
	
	public void main()
	{
		ResultSet rs,rs1,rs2,rs3;
		PreparedStatement ps,ps1,ps2,ps3;
		DBmanager db = new DBmanager();
		Connection con = db.getCon();
		Display displays= new Display();
		Scanner sc = new Scanner(System.in);
		try 
		{
			ps = con.prepareStatement("select a.pid,a.pname,b.pqty from prodinfo a,proddet b where a.pid=b.pid");
			rs=ps.executeQuery();
			System.out.println("pid \t pname \t sqty");
			System.out.println("----------------------------");
			while(rs.next())  
				System.out.println(rs.getInt(1)+"\t "+rs.getString(2)+"\t "+rs.getInt(3));
			System.out.println("ENTER THE PRODUCT ID TO SELL");
			int id=sc.nextInt();
			ps = con.prepareStatement("Select * from prodinfo where pid=?");
			ps.setInt(1,id);
			rs = ps.executeQuery();
			int i=0;
			while(rs.next())
			{
				i++;
			}
				if(i==1)
				{
					System.out.println("ENTER THE PRODUCT QUANTITY TO SELL");
					int qty = sc.nextInt();
					ps = con.prepareStatement("Select pqty from proddet where pid=?");
					ps.setInt(1,id);
					rs = ps.executeQuery();
					while(rs.next())
					{
						int qty1 = rs.getInt(1);
						if(qty<=qty1)
						{
							ps2 = con.prepareStatement("insert into prodsal (pid,sqty) values(?,?)");
							ps2.setInt(1,id);
							ps2.setInt(2,qty);
							ps2.executeUpdate();
							ps3 = con.prepareStatement("update proddet set pqty=pqty-(?) where pid=?");
							ps3.setInt(1,qty);
							ps3.setInt(2,id);
							ps3.executeUpdate();
							System.out.println("STOCK SOLD");
						}
						else
						{
							System.out.println("QUANTITY NOT AVAILABLE");
						}
					}
				}
				else
				{
					System.out.println("PRODUCT ID DOES NOT EXIST");
				}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}