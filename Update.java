import java.util.Scanner;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

class Update extends JFrame implements ActionListener
{
	Border blackline = BorderFactory.createLineBorder(Color.black);
	JTextField txtfirstname,txtage,txtmessage;
	JTextArea txtaddress;
	JButton update,exit,clear;
	Update()
	{
		JFrame update_frame=new JFrame("Update Frame");
		
		JLabel title=new JLabel("UPDATE");
		title.setBounds(500,20,300,50);
		title.setFont(new Font("Arial", Font.BOLD, 20));
		title.setForeground(Color.MAGENTA);
		update_frame.add(title);
		
		JLabel note1=new JLabel("PATIENT CURRENT DETAIL'S");
		note1.setBounds(400,80,300,50);
		note1.setFont(new Font("serif", Font.BOLD, 18));
		note1.setForeground(Color.green);
		update_frame.add(note1);
		note1.setBorder(blackline);
		
		//label for first name 
		JLabel name=new JLabel("Enter your First Name:");
		name.setBounds(380,110,200,100);
		name.setFont(new Font("TimesRoman", Font.BOLD, 15));
		name.setForeground(Color.BLACK);
		update_frame.add(name);
		//Textfield for first name 
		txtfirstname=new JTextField();
		txtfirstname.setBounds(580,150,140,25);
		txtfirstname.setFont(new Font("Serif", Font.PLAIN, 15));
		update_frame.add(txtfirstname);
		
		
		JLabel note2=new JLabel("PATIENT NEW DETAIL'S");
		note2.setBounds(400,220,300,50);
		note2.setFont(new Font("serif", Font.BOLD, 18));
		note2.setForeground(Color.blue);
		update_frame.add(note2);
		note2.setBorder(blackline);
		//label for age 
		JLabel age=new JLabel("Age:");
		age.setBounds(460,250,200,100);
		age.setFont(new Font("TimesRoman", Font.BOLD, 15));
		age.setForeground(Color.BLACK);
		update_frame.add(age);
		//Textfield for first name 
		txtage=new JTextField();
		txtage.setBounds(520,290,50,25);
		txtage.setFont(new Font("Serif", Font.PLAIN, 15));
		update_frame.add(txtage);
		//label for address 
		JLabel address=new JLabel("Address:");
		address.setBounds(400,300,200,100);
		address.setFont(new Font("TimesRoman", Font.BOLD, 15));
		address.setForeground(Color.BLACK);
		update_frame.add(address);
		//Textarea for address 
		txtaddress=new JTextArea();
		txtaddress.setBounds(500,340,200,75);
		txtaddress.setFont(new Font("Serif", Font.PLAIN, 15));
		update_frame.add(txtaddress);
		//button update
		update=new JButton("UPDATE");  
		update.setBounds(605,430,95,30);  
		update_frame.add(update);  
		update.setBackground(Color.PINK);
		//button exit
		exit=new JButton("EXIT");  
		exit.setBounds(970,510,95,30);  
		update_frame.add(exit);  
		exit.setBackground(Color.RED);
		//button clear
		clear=new JButton("CLEAR");  
		clear.setBounds(500,470,200,30);  
		update_frame.add(clear);  
		clear.setBackground(Color.LIGHT_GRAY);
		
		//txtfield for message
		txtmessage=new JTextField();
		txtmessage.setBounds(340,510,500,25);
		txtmessage.setFont(new Font("Serif", Font.PLAIN, 15));
		update_frame.add(txtmessage);
		
		
		clear.addActionListener(this);
		exit.addActionListener(this);
		update.addActionListener(this);
	
		update_frame.setSize(1000,600);
		update_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		update_frame.setLayout(null);
		update_frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==exit)
		{
			System.exit(0);
		}
		else if(ae.getSource()==update)
		{
			try
			{
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
				String first_name=txtfirstname.getText();
				String age=txtage.getText();
				String address=txtaddress.getText();
				PreparedStatement pstmt=con.prepareStatement("update hospital_records set age=?,address=? where first_name=?;");
				pstmt.setString(1,age);
				pstmt.setString(2,address);
				pstmt.setString(3,first_name);
				int result=pstmt.executeUpdate();
				System.out.println(result);
				if(result==1)
				{
					txtmessage.setText("Data Update Successfully");
				}
				else
				{
					txtmessage.setText(first_name+"record not found");
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==clear)
		{
			txtfirstname.setText(" ");
			txtage.setText(" ");
			txtaddress.setText(" ");
		}
	}
	
	
	public static void main(String args[])
	{
		Update u=new Update();
	}
}
