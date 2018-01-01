
import java.sql.*;
public class table
{

public static void main(String args[])throws Exception
{

Class.forName("oracle.jdbc.driver.OracleDriver");
Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
Statement st=cn.createStatement();
st.executeUpdate("create table emp5(milkinltres number(10),cocoaingms number(10),vanillaingms number(10),butterinltres number(10))");
st.executeUpdate("insert into emp5 values(50,500,200,100)");
st.executeUpdate("select * from emp5");


}
}

