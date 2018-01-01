import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import javax.swing.*;
public class stock extends JFrame implements ActionListener{
JLabel l1,l2;
JTextField t1,t2;
JButton b1;
Container c;

stock()
{
	 c=getContentPane();
	 c.setBackground(Color.lightGray);


	setTitle("Stock Management System:-Admin Login");
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
	b1=new JButton("submit");
	b1.setBounds(300,400,100,40);
	add(b1);
	b1.addActionListener(this);
	
}



public static void main(String args[])
{
	new stock();
}
@Override  
public void actionPerformed(ActionEvent e) 
{

	String a=t1.getText();
	String b=t2.getText();
	
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");

Statement st=cn.createStatement();
//st.executeUpdate("create table emp(username varchar2(20),password varchar2(20))");
st.executeUpdate("insert into emp values('"+a+"','"+b+"')");
System.out.println("ok");
new login1();
dispose();
	} 
	catch (Exception e1) 
	{


		e1.printStackTrace();
	}
	
}	
	
}