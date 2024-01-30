import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Flightdet {
    String dbUrl = "jdbc:mysql://localhost:3306/ngpdb";
    String dbUname = "root";
    String dbPassword = "";
    String dbDriver = "com.mysql.cj.jdbc.Driver";
    String from, to, date, fare, timing;

    Flightdet(String from, String to, String date, String fare, String timing) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.fare = fare;
        this.timing = timing;
    }

    void store() {
        Connection con = null;
        try {
            Class.forName(dbDriver);
            con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);

            String sql = "INSERT INTO details (`from`, `to`, `date`, `fare`, `timing`)"
                    + " VALUES ('" + from + "','" + to + "','" + date + "','" + fare + "','" + timing + "')";

            Statement s = con.createStatement();
            s.executeUpdate(sql);

            System.out.println("Record inserted successfully.");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

