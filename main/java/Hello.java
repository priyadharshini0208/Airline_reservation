import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class Hello {
	String dbUrl="jdbc:mysql://localhost:3306/ngpdb";
    String dbUname="root";
    String dbPassword="";
    String dbDriver="com.mysql.cj.jdbc.Driver";
      String email,password;
      Hello(String email,String password){
    	  this.email=email;
    	  this.password=password;
    	  }
      void store() {
    	  Connection con = null;
    	  try {
    	Class.forName(dbDriver);  //class not found exception
    	con = DriverManager.getConnection(dbUrl,dbUname,dbPassword);
    	 String sql = "insert into register1 (email,password)"
    	 + "values('"+email+"','"+password+"')";
//    	   String sql="select * from student";
    	Statement s = con.createStatement();
    	 s.execute(sql);

    	  con.close();
    	} catch (Exception e) {
    	e.printStackTrace();
    	}
    	  
      }
}
