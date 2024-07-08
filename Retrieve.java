import java.util.Scanner;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Retrieve extends JFrame implements ActionListener
{
	String username="saurabh1412";
	String password="123";
	JTextField txtusername;
	JPasswordField pswd;
	JButton submit,clear,exit,back;
	Retrieve()
	{
		JFrame retrieve_frame=new JFrame("Retrieve records");
		JLabel title=new JLabel("LOGIN");
		title.setBounds(500,20,300,50);
		title.setFont(new Font("Arial", Font.BOLD, 20));
		title.setForeground(Color.RED);
		retrieve_frame.add(title);
		
		//username
		JLabel username=new JLabel("Username:");
		username.setBounds(100,100,90,100);
		username.setFont(new Font("TimesRoman", Font.BOLD, 15));
		username.setForeground(Color.BLACK);
		retrieve_frame.add(username);
		//Textfield for username
		txtusername=new JTextField();
		txtusername.setBounds(200,140,200,25);
		txtusername.setFont(new Font("Serif", Font.PLAIN, 15));
		retrieve_frame.add(txtusername);
		
		//password
		JLabel password=new JLabel("Password:");
		password.setBounds(600,100,90,100);
		password.setFont(new Font("TimesRoman", Font.BOLD, 15));
		password.setForeground(Color.BLACK);
		retrieve_frame.add(password);
		//Textfield for password
		pswd = new JPasswordField(); 
		pswd.setBounds(700,140,200,25);
		retrieve_frame.add(pswd);
		
		//button submit
		submit=new JButton("SUBMIT");  
		submit.setBounds(800,190,95,30);  
		retrieve_frame.add(submit);  
		submit.setBackground(Color.GREEN);
		
		//button clear
		clear=new JButton("CLEAR");  
		clear.setBounds(800,230,95,30);  
		retrieve_frame.add(clear);  
		clear.setBackground(Color.YELLOW);
		
		//button EXIT
		exit=new JButton("EXIT");  
		exit.setBounds(700,230,95,30);  
		retrieve_frame.add(exit);  
		exit.setBackground(Color.RED);
		
		submit.addActionListener(this);
		clear.addActionListener(this);
		exit.addActionListener(this);
		
				
		
		
		
		retrieve_frame.setSize(1000,600);
        retrieve_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		retrieve_frame.setLayout(null);
		retrieve_frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		if(ae.getSource()==submit)
		{
			String usernametxtfield=txtusername.getText();
			String passwordfield=pswd.getText();
			//System.out.println(usernametxtfield+" "+passwordfield);
			try
			{
				if(usernametxtfield.equals(username) && passwordfield.equals(password))
				{
					new Fetch();
				}
				else
				{
					throw new Exception("invalid username or password");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		else if(ae.getSource()==clear)
		{
			txtusername.setText(" ");
			pswd.setText(" ");
		}
		else if(ae.getSource()==exit)
		{
			System.exit(0);
		}
	}
}
