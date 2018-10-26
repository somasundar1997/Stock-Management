import java.io.*;
import java.sql.*;  
import java.util.*;

class Products extends DBmanager
{
	public void main()
	{
		DBmanager db = new DBmanager();          
		boolean tf = true;
		while(tf)
		{
		System.out.println("1.ADD STOCK");
		System.out.println("2.SELL STOCK");
		System.out.println("3.INCOME/PROFIT");
		System.out.println("4.REMOVE product");
		System.out.println("5.DISPLAY product");
		System.out.println("6.EXIT/CLOSE");
		Scanner sc = new Scanner(System.in);
		System.out.println("CHOOSE AND OPTION TO PROCEED : ");
		int n = sc.nextInt();
		switch(n)
			{
				case 1:
					Add adds= new Add();
					adds.main();
					
					break;
				case 2:
					Sell sells= new Sell();
					sells.main();
					
					break;
				case 3:
					Income incomes= new Income();
					incomes.main();
					
					break;
				case 4:
					Remove removes= new Remove();
					removes.main();
				
					break;
				case 5:
					Display displays= new Display();
					displays.main();
					break;
				case 6:
					System.out.println("TERMINATED");
					System.out.println("DATABASE CLOSED");
					tf=false;
					break;
				default :
					System.out.println(" INVALID NUMBER ENTER NUMBER BETWEEN 1 TO 6 ");
					
					break;
			}
		}
	}
}