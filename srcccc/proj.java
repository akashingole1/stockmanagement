	import java.awt.*;
    import javax.swing.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.*;
import java.util.*;
	public class proj extends JFrame implements ActionListener{
	static int i,i5,res,w,x,y,z;
	static int a,b11,c11,d;
	JLabel l1,l2,l3,l4,l5,l6;
	JLabel la1;
	JButton b1,b2,b3,b4;
	JTextField t1,t2,t3,t4,t5,t6;
	JTextField ta1;
	int m=2;// milk required for making one chocolate
	int c1=10;//cocoa 
	int v=10;//vanilla
	int b=2;//butter
	Container c;
	proj()
	{
		 c=getContentPane();
		 c.setBackground(Color.yellow);

		setTitle("Stock Management System:-Raw Materials Needed Are");
		setSize(500,600);
		setVisible(true);
		setLayout(null);
		l1=new JLabel("PRODUCT NAME");
		l1.setBounds(150,50,100,150);
		add(l1);
		t1=new JTextField("");
		t1.setBounds(250,100,100,50);
		add(t1);
		l2=new JLabel("PRODUCT QTY");
		l2.setBounds(150,100,100,150);
		add(l2);
		t2=new JTextField("");
		t2.setBounds(250,150,100,50);
		add(t2);
		la1=new JLabel("Raw Materials Are");
		la1.setBounds(250,200,100,120);
		add(la1);
		l3=new JLabel("MILK(litres)");
		l3.setBounds(150,270,100,120);
		add(l3);
		t3=new JTextField("");
		t3.setBounds(250,300,100,50);
		add(t3);
		l4=new JLabel("COCOA(gm)");
		l4.setBounds(150,320,100,120);
		add(l4);
		t4=new JTextField("");
		t4.setBounds(250,350,100,50);
		add(t4);
		l5=new JLabel("VANILLA(gm)");
		l5.setBounds(150,370,100,120);
		add(l5);
		t5=new JTextField("");
		t5.setBounds(250,400,100,50);
		add(t5);
		l6=new JLabel("BUTTER(litres)");
		l6.setBounds(150,420,100,120);
		add(l6);
		t6=new JTextField("");
		t6.setBounds(250,450,100,50);
		add(t6);
		ta1=new JTextField();
		ta1.setBounds(250,500,100,50);
		add(ta1);
		b1=new JButton("Raw Materials");
		b1.setBounds(300,600,100,40);
		add(b1);
		b1.addActionListener(this);
		b2=new JButton("TValue");
		b2.setBounds(180,600,100,40);
		add(b2);
		b2.addActionListener(this);
		b3=new JButton("Tstockvalue");
		b3.setBounds(420,600,100,40);
		add(b3);
		b3.addActionListener(this);
		b4=new JButton("Check");
		b4.setBounds(540,600,100,40);
		add(b4);
		b4.addActionListener(this);
		}
	
	public static void main(String args[]){
    new proj();
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
		String s1=t2.getText();
		int n1=Integer.parseInt(s1);
	    t3.setText(Integer.toString(m*n1));
		t4.setText(Integer.toString(c1*n1));
		t5.setText(Integer.toString(v*n1));
		t6.setText(Integer.toString(b*n1));
		
		}
		else{
			if(e.getSource()==b2)
			{
		String s2=t3.getText();
		String s3=t4.getText();
		String s4=t5.getText();
		String s5=t6.getText();
		int i1=Integer.parseInt(s2);
		int i2=Integer.parseInt(s3);
		int i3=Integer.parseInt(s4);
		int i4=Integer.parseInt(s5);
		 i5=i1+i2+i3+i4;
		ta1.setText(Integer.toString(i5));
		w=i1;
		x=i2;
		y=i3;
		z=i4;
		
			
			}
		}
		
			if(e.getSource()==b3)
			{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");

				Statement st=cn.createStatement();
			    ResultSet rs=st.executeQuery("select * from emp5");
            while(rs.next())
            {
                a=rs.getInt(1);
                
                 b11=rs.getInt(2);
               
                 c11=rs.getInt(3);
                 d=rs.getInt(4);
               res=a+b11+c11+d;
               ta1.setText(Integer.toString(res));
               
            }
            
            }
			
			catch(Exception e2)
			{
				System.out.println(e2);
			}
			}
			else
			{
				if(e.getSource()==b4){
				if(i5>res)
				JOptionPane.showMessageDialog(this,"insufficient storage");
				else{
					int a11=a-w;
					int b22=b11-x;
					int c33=c11-y;
					int d44=d-z;
					try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");

					Statement st=cn.createStatement();

					//st.executeUpdate("update emp7 set name='pranay',address='gzb' where name='akash' and address='indirapuram'");
					st.executeUpdate("update emp5 set milkinltres='"+a11+"',cocoaingms='"+b22+"',vanillaingms='"+c33+"',butterinltres='"+d44+"' where milkinltres='"+a+"' and cocoaingms='"+b11+"' and vanillaingms='"+c11+"' and butterinltres='"+d+"'");	
					
					}
					catch(Exception e5){
						System.out.println(e5);
					}
				}
				}
			}
			
		}
		}
	