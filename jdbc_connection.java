import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainClass {

  private static final String CUSTOMER_TABLE = "create table customer ( "
      + "   customerID INT, firstName VARCHAR(20) not null, lastName VARCHAR(20) not null, "
      + "   phone VARCHAR(12), gender VARCHAR(1), annual_income INT, city VARCHAR(20), " 
      + "   primary key(customerID))";
      
  public static Connection getConnection() throws ClassNotFoundException, SQLException {
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:orcl12c";
    String username = "orcl12c";
    String password = "oracle";
    Class.forName(driver);
    Connection conn = DriverManager.getConnection(url, username, password);
    return conn;
  }

  public static void main(String args[]) {
    Connection conn = null;
    Statement stmt = null;
    try {
      conn = getConnection();
      stmt = conn.createStatement();
      stmt.executeUpdate(EMPLOYEE_TABLE);
      stmt.executeUpdate("insert into Customers(customerID, firstName) values(A20345, 'John')");
      System.out.println("CreateCustomerTableOracle: main(): table created.");
    } catch (ClassNotFoundException e) {
      System.out.println("error: failed to load Oracle driver.");
      e.printStackTrace();
    } catch (SQLException e) {
      System.out.println("error: failed to create a connection object.");
      e.printStackTrace();
    } catch (Exception e) {
      System.out.println("other error:");
      e.printStackTrace();
    } finally {
      try {
        stmt.close();
        conn.close();
      } catch (Exception e) {
      }
    }
  }
}
           