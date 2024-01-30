import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Adminlogin {
	String dbUrl="jdbc:mysql://localhost:3306/ngpdb";
    String dbUname="root";
    String dbPassword="";
    String dbDriver="com.mysql.cj.jdbc.Driver";
      String email,password;
      Adminlogin(String email,String password){
    	  this.email=email;
    	  this.password=password;
    	  }
     
      public boolean retrieve() {
    		Connection con = null;
    			try {
    			Class.forName(dbDriver);  //class not found exception
    			con = DriverManager.getConnection(dbUrl,dbUname,dbPassword);   //sql Exception

//    			String sql = "insert into signup(email,password)"
//    					+ "values('"+email+"','"+password+"')";
    			String sql = "SELECT * FROM admin WHERE email = ? AND password = ?";
    	        PreparedStatement ps = con.prepareStatement(sql);
    	        ps.setString(1, email);
    	        ps.setString(2, password);

    	        ResultSet rs = ps.executeQuery();
    	        return rs.next();
    			}
    			catch (Exception e) {
    	            e.printStackTrace();
    	            return false;
    	        } finally {
    	            try {
    	                if (con != null) con.close();
    	            } catch (Exception e) {
    	                e.printStackTrace();
    	            }
    	        }
    	    }

}
