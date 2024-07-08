import java.util.Scanner;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Hospital extends JFrame implements ActionListener
{
	JButton exit,retrieve,submit,clear,update;//buttons
	JTextField txtfirstname,txtlastname,txtage,txtphone;//textfield
	JTextArea txtdiagnosis,txtaddress;//textarea
	JComboBox cb,doctor_cb;//dropdown
	JRadioButton male,female;//radiobutton
	
	Hospital()
	{
		//swing frame
		JFrame hospital_frame=new JFrame("Hospital Management System");  
		
		//project name
		JLabel projectname=new JLabel("Hospital Management System");
		projectname.setBounds(400,20,300,50);
		projectname.setFont(new Font("Arial", Font.BOLD, 20));
		projectname.setForeground(Color.BLUE);
		hospital_frame.add(projectname);
		
		
		//first name
		JLabel firstname=new JLabel("First Name:");
		firstname.setBounds(100,100,90,100);
		firstname.setFont(new Font("TimesRoman", Font.BOLD, 15));
		firstname.setForeground(Color.BLACK);
		hospital_frame.add(firstname);
		//Textfield for first name
		txtfirstname=new JTextField();
		txtfirstname.setBounds(200,140,200,25);
		txtfirstname.setFont(new Font("Serif", Font.PLAIN, 15));
		hospital_frame.add(txtfirstname);
		
		//last name
		JLabel lastname=new JLabel("Last Name:");
		lastname.setBounds(100,170,90,100);
		lastname.setFont(new Font("TimesRoman", Font.BOLD, 15));
		lastname.setForeground(Color.BLACK);
		hospital_frame.add(lastname);
		//Textfield for last name
		txtlastname=new JTextField();
		txtlastname.setBounds(200,210,200,25);
		txtlastname.setFont(new Font("Serif", Font.PLAIN, 15));
		hospital_frame.add(txtlastname);
		
		//Age
		JLabel age=new JLabel("Age:");
		age.setBounds(100,240,90,100);
		age.setFont(new Font("TimesRoman", Font.BOLD, 15));
		age.setForeground(Color.BLACK);
		hospital_frame.add(age);
		//Textfield for Age
		txtage=new JTextField();
		txtage.setBounds(200,280,200,25);
		txtage.setFont(new Font("Serif", Font.PLAIN, 15));
		hospital_frame.add(txtage);
		
		//Gender
		JLabel gender=new JLabel("Gender:");
		gender.setBounds(100,310,90,100);
		gender.setFont(new Font("TimesRoman", Font.BOLD, 15));
		gender.setForeground(Color.BLACK);
		hospital_frame.add(gender);
		//male
		male=new JRadioButton("Male");  
		male.setBounds(200,340,80,40);  
		//female
		female=new JRadioButton("Female");
		female.setBounds(300,340,80,40);		
		ButtonGroup bg=new ButtonGroup(); 	
		bg.add(male);
		bg.add(female);
		hospital_frame.add(male); 
		hospital_frame.add(female);
		
		//phone no
		JLabel phone=new JLabel("Phone No:");
		phone.setBounds(100,380,90,100);
		phone.setFont(new Font("TimesRoman", Font.BOLD, 15));
		phone.setForeground(Color.BLACK);
		hospital_frame.add(phone);
		//Textfield for phone no
		txtphone=new JTextField();
		txtphone.setBounds(200,420,200,25);
		txtphone.setFont(new Font("Serif", Font.PLAIN, 15));
		hospital_frame.add(txtphone);
		
		//select appoinment date
		JLabel appoinment_date=new JLabel("Appoinment Date:");
		appoinment_date.setBounds(100,440,140,100);
		appoinment_date.setFont(new Font("TimesRoman", Font.BOLD, 15));
		appoinment_date.setForeground(Color.BLACK);
		hospital_frame.add(appoinment_date);
		
		//dates_list
		String dates[]={"--SELECT--","20 july 2024","21 july 2024","22 july 2024","23 july 2024","24 july 2024","other"};
		cb=new JComboBox(dates);    
		cb.setBounds(250,470,100,40);    
		hospital_frame.add(cb);     

		//select DOCTOR
		JLabel doctor_label=new JLabel("Doctor:");
		doctor_label.setBounds(600,100,90,100);
		doctor_label.setFont(new Font("TimesRoman", Font.BOLD, 15));
		doctor_label.setForeground(Color.BLACK);
		hospital_frame.add(doctor_label);
		
		//dates_list
		String doctor[]={"--SELECT--","Mr.Saurabh Wakchaure","Ms.Sejal Waman","Mr.Abhishek Ugale","Ms.Monica Warunkshe","Mr.Akash Wale","other"};
		doctor_cb=new JComboBox(doctor);    
		doctor_cb.setBounds(670,130,150,40);    
		hospital_frame.add(doctor_cb);   
		
		//Diagnosis
		JLabel diagnosis=new JLabel("Diagnosis:");
		diagnosis.setBounds(600,170,90,100);
		diagnosis.setFont(new Font("TimesRoman", Font.BOLD, 15));
		diagnosis.setForeground(Color.BLACK);
		hospital_frame.add(diagnosis);
		
		//textfield for diagnosis
		txtdiagnosis=new JTextArea();
		txtdiagnosis.setBounds(700,210,200,70);
		txtdiagnosis.setFont(new Font("Serif", Font.PLAIN, 15));
		hospital_frame.add(txtdiagnosis);
		
		//Address
		JLabel address=new JLabel("Address:");
		address.setBounds(600,270,90,100);
		address.setFont(new Font("TimesRoman", Font.BOLD, 15));
		address.setForeground(Color.BLACK);
		hospital_frame.add(address);
		
		//textfield for address
		txtaddress=new JTextArea();
		txtaddress.setBounds(700,310,200,70);
		txtaddress.setFont(new Font("Serif", Font.PLAIN, 15));
		hospital_frame.add(txtaddress);
		
		//clear
		clear=new JButton("CLEAR");  
		clear.setBounds(685,450,95,30);  
		hospital_frame.add(clear);  
		clear.setBackground(Color.YELLOW);  
		
		//submit
		submit=new JButton("SUBMIT");  
		submit.setBounds(805,385,95,30);  
		hospital_frame.add(submit);
		submit.setBackground(Color.GREEN); 
		
		//retrieve
		retrieve=new JButton("RETRIEVE");  
		retrieve.setBounds(805,450,95,30);  
		hospital_frame.add(retrieve);
		Color customColor = Color.decode("#FFA500");
		retrieve.setBackground(customColor); 
		
		//exit
		exit=new JButton("EXIT");  
		exit.setBounds(1000,510,80,30);  
		hospital_frame.add(exit);
		exit.setBackground(Color.RED);

		//update
		update=new JButton("UPDATE");  
		update.setBounds(685,485,215,30);  
		hospital_frame.add(update);
		update.setBackground(Color.ORANGE);		
		
		//actionlistener
		
		clear.addActionListener(this);
		exit.addActionListener(this);
		submit.addActionListener(this);
		retrieve.addActionListener(this);
		update.addActionListener(this);
		
		
		
		//regarding frame
		hospital_frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		hospital_frame.setSize(1000,600);
        hospital_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hospital_frame.setLayout(null);
		hospital_frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			if(ae.getSource()==exit)
			{
				System.exit(0);
			}
			else if(ae.getSource()==clear)
			{
				txtfirstname.setText(" ");
				txtlastname.setText(" ");
				txtage.setText(" ");
				txtphone.setText(" ");
				txtdiagnosis.setText(" ");
				txtaddress.setText(" ");
				cb.setSelectedItem("--SELECT--");
				doctor_cb.setSelectedItem("--SELECT--");
				male.setSelected(false);
				female.setSelected(false);
			}
			else if(ae.getSource()==submit)
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
				//String sql = "INSERT INTO example_table (name, age) VALUES (?, ?)";
				PreparedStatement pstmt=con.prepareStatement("insert into hospital_records(first_name,last_name,age,gender,phone_no,appoinment_date,doctor_name,diagnosis,address) values(?,?,?,?,?,?,?,?,?)");
				//Get value of first name,last name and age
				String first_name=txtfirstname.getText();
				String last_name=txtlastname.getText();
				String age=txtage.getText();
				//Get the value of gender
				String gender;
				if(male.isSelected())
				{
					gender="Male";
				}
				else
				{
					gender="Female";
				}
				//System.out.println(gender);
				//Get the value of phone number
				String phone_no=txtphone.getText();
				
				//Get the value of appoinment date and doctor name
				String selected_date =(String)cb.getSelectedItem();
				String selected_doctor =(String)doctor_cb.getSelectedItem();
				
				//Get the value of diagnosis and address
				String diagnosis=txtdiagnosis.getText();
				String address=txtaddress.getText();
				
				//set the value to pstmt
				pstmt.setString(1,first_name);
				pstmt.setString(2,last_name);
				pstmt.setString(3,age);
				pstmt.setString(4,gender);
				pstmt.setString(5,phone_no);
				pstmt.setString(6,selected_date);
				pstmt.setString(7,selected_doctor);
				pstmt.setString(8,diagnosis);
				pstmt.setString(9,address);
				
				//exexute query
				int result=pstmt.executeUpdate();
				System.out.println(first_name+" "+last_name+" "+age+" "+gender+" "+phone_no+" "+selected_date+" "+selected_doctor+" "+diagnosis+" "+address);
				
			}
			else if(ae.getSource()==retrieve)
			{
				new Retrieve();
			}
			else if(ae.getSource()==update)
			{
				new Update();
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String args[])
	{
		Hospital sasun=new Hospital();
	}
}

