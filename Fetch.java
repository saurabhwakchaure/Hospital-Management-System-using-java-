import java.util.Scanner;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;   
import javax.swing.table.DefaultTableModel;
class Fetch extends JFrame
{
	JFrame table;  
	DefaultTableModel model = new DefaultTableModel();
	Container cnt = this.getContentPane();
	JTable jtbl = new JTable(model);

	Fetch()
	{
		table=new JFrame("Hospital Records");
		try
		{
			    cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
				model.addColumn("id");
				model.addColumn("First Name");
				model.addColumn("Last Name");
				model.addColumn("Age");
				model.addColumn("Gender");
				model.addColumn("Phone No.");
				model.addColumn("A.Date");
				model.addColumn("Doctor Name");
				model.addColumn("Diagnosis");
				model.addColumn("Address");
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/codeclause_task2","root","saurabh1412");
				if(con!=null)
				{
					System.out.println("connection successful");
				}
				else
				{
					System.out.println("not");
				}
				PreparedStatement pstmt=con.prepareStatement("select*from hospital_records");
				ResultSet rs=pstmt.executeQuery();
				//String data[][];
				while(rs.next())
				{
					String fname=rs.getString("first_name");
					String lname=rs.getString("last_name");
					int age=rs.getInt("age");
					String gender=rs.getString("gender");
					String phone_no=rs.getString("phone_no");
					String appoinment_date=rs.getString("appoinment_date");
					String doctor_name=rs.getString("doctor_name");
					String diagnosis=rs.getString("diagnosis");
					String address=rs.getString("address");
				

					System.out.println(fname+" "+lname+" "+age+" "+gender+" "+phone_no+" "+appoinment_date+" "+doctor_name+" "+diagnosis+" "+address);
					model.addRow(new Object[]{rs.getInt(1),rs.getString(2), rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)});
					
				}
				JScrollPane pg = new JScrollPane(jtbl);
				cnt.add(pg);
				table.add(pg);
				 
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		
		
		
		
		
		table.setSize(500, 300);
        table.setLocationRelativeTo(null);
        table.setVisible(true);
        table.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	
	public static void main(String args[])
	{
		Fetch f=new Fetch();
	}
}
