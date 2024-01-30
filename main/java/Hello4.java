import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Hello4 {
	String dbUrl="jdbc:mysql://localhost:3306/ngpdb";
    String dbUname="root";
    String dbPassword="";
    String dbDriver="com.mysql.cj.jdbc.Driver";
      String name,aadhar,email,phone;
      Hello4(String name,String aadhar,String email,String phone ){
    	  this.name=name;
    	  this.aadhar=aadhar;
    	  this.email=email;
    	  this.phone=phone;
    	  
    	  
    	  }
      void stores() {
    	  Connection con = null;
    	  try {
    	Class.forName(dbDriver);  //class not found exception
    	con = DriverManager.getConnection(dbUrl,dbUname,dbPassword);
    	 String sql = "insert into booking4 (name,aadhar,email,phone)"
    	 + "values('"+name+"','"+aadhar+"','"+email+"','"+phone+"')";
//    	   String sql="select * from student";
    	Statement s = con.createStatement();
    	 s.execute(sql);

    	  con.close();
    	} catch (Exception e) {
    	e.printStackTrace();
    	}
    	  
      }

}
