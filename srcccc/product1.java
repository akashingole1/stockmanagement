import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class product1 extends JFrame implements ActionListener{
static String str;
	static int a1,b11,c1,d1;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JButton b1,b2,b3,b4,b5;
	JTextField t1,t2,t3,t4,t5,t6,t7;
product1(){
	setTitle("Stock Management System:-Raw Materials Needed Are");
	setSize(500,600);
	setVisible(true);
	setLayout(null);
	l1=new JLabel("Product Name");
	l1.setBounds(150,50,100,150);
	add(l1);
	t1=new JTextField("");
	t1.setBounds(250,100,100,50);
	add(t1);
	l3=new JLabel("Milk");
	l3.setBounds(150,150,100,120);
	add(l3);
	t3=new JTextField("");
	t3.setBounds(250,200,150,50);
	add(t3);
	l4=new JLabel("Cocoa");
	l4.setBounds(150,200,100,120);
	add(l4);

	t4=new JTextField("");
	t4.setBounds(250,250,150,50);
	add(t4);
	l5=new JLabel("Vanilla");
	l5.setBounds(150,250,100,120);
	add(l5);
	t5=new JTextField("");
	t5.setBounds(250,300,150,50);
	add(t5);
	l6=new JLabel("Butter");
	l6.setBounds(150,300,100,120);
	add(l6);

	t6=new JTextField("");
	t6.setBounds(250,350,150,50);
	add(t6);
	l7=new JLabel("total stock");
	l7.setBounds(150,350,100,120);
	add(l7);
	t7=new JTextField("");
	t7.setBounds(250,400,150,50);
	add(t7);
	
	
	b1=new JButton("Instock");
	b1.setBounds(200,500,100,40);
	add(b1);
	b1.addActionListener(this);
	b2=new JButton("Tstockvalue");
	b2.setBounds(310,500,100,40);
	add(b2);
	b2.addActionListener(this);
	b3=new JButton("Add");
	b3.setBounds(200,600,100,40);
	add(b3);
	b3.addActionListener(this);
	b4=new JButton("Check");
	b4.setBounds(310,600,100,40);
	add(b4);
	b4.addActionListener(this);
}
	public static void main(String args[])
	{
	new product1();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");

	Statement st=cn.createStatement();
    ResultSet rs=st.executeQuery("select * from emp5");
    
	while(rs.next()){
    int a=rs.getInt(1);
    a1=a;
    String s=String.valueOf(a);
    int b=rs.getInt(2);
    b11=b;
    String s1=String.valueOf(b);
    int c=rs.getInt(3);
    c1=c;
    String s2=String.valueOf(c);
    int d=rs.getInt(4);
    d1=d;
    String s3=String.valueOf(d);
    t3.setText(s);
    t4.setText(s1);
    t5.setText(s2);
    t6.setText(s3);
	}
	}
	catch(Exception e1)
		{
		System.out.println(e1);
		}
		}
		else
		{
			if(e.getSource()==b2)
			{
		
				int sm=a1+b11+c1+d1;
			t7.setText(Integer.toString(sm));	
			
			}
		}
	     str=t1.getText();
	    if(e.getSource()==b3)
	    	
	    {
	    	
	    	new proj();
	    	}
	    if(e.getSource()==b4){
	    	if(str!="chocolate")
	    	JOptionPane.showMessageDialog(this,"wrong product");
				
	    }
	    		    	
	
	

	
	
	
	
	}}
