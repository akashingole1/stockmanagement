
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
public class login1 extends JFrame implements ActionListener{
	JLabel l1,l2;
	JTextField t1,t2;
	JButton b2;
	Container c;
	login1()
	{
		 c=getContentPane();
		 c.setBackground(Color.blue);

		setTitle("Stock Management System:-User Login");
		setSize(500,600);
		setVisible(true);
		setLayout(null);
		l1=new JLabel("username");
		l1.setBounds(150,150,100,100);
		add(l1);
		t1=new JTextField("");
		t1.setBounds(250,150,100,50);
		add(t1);
		l2=new JLabel("password");
		l2.setBounds(150,250,100,100);
		add(l2);
		t2=new JTextField("");
		t2.setBounds(250,250,100,50);
		add(t2);
		b2=new JButton("submit");
		b2.setBounds(300,400,100,40);
		add(b2);
		b2.addActionListener(this);
		
	}
	public static void main(String args[]){
		new login1();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String b=t2.getText();

		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");

			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("select * from emp where password='"+b+"'");
		boolean ss=rs.next();
		if(ss)
		{
			System.out.println("valid user"+ss);
		new product1();
		}
		else{
			System.out.println("invalid user"+ss);
		}
		}
		
          	catch(Exception e1){
		e1.printStackTrace();
	}
	}
	}
	