import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public class Hello2 {
    String dbUrl = "jdbc:mysql://localhost:3306/ngpdb";
    String dbUname = "root";
    String dbPassword = "";
    String dbDriver = "com.mysql.cj.jdbc.Driver";
    String from, to, date;

    Hello2(String from, String to, String date) {
        this.from = from;
        this.to = to;
        this.date = date;
    }

    public boolean retrieve() {
        Connection con = null;
        try {
            Class.forName(dbDriver);
            con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);

            String sql = "SELECT * FROM details WHERE `from` = ? AND `to` = ? AND date = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, from);
            ps.setString(2, to);
            ps.setString(3, date);
            

            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
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
