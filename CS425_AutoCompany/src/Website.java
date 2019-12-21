import java.util.Scanner;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Website {

	private static Scanner scan;
	private static String answer;
	private static AccountManager manager;
	
	private static final String CUSTOMER_TABLE = "create table customer ( "
		      + "   customerID INT, firstName VARCHAR(20) not null, lastName VARCHAR(20) not null, "
		      + "   phone VARCHAR(12), gender VARCHAR(1), annual_income INT, city VARCHAR(20), " 
		      + "   primary key(customerID))";
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		manager = new AccountManager();
		answer = "";
		boolean done = false;
		while(!done)
		{
			opener();
			answer = scan.nextLine();
			switch(answer)
			{
				case "login":
					if(loginPrompt() == 1)
					{
						
					}
					break;
				case "create":
					if(createAccountPrompt() == 1)
					{
						System.out.println("You are logged in.");
					}
					break;
				case "quit":
					quit();
				default:
					System.out.println("Couldn't understand your answer.");
			}
		}
		
	}
	
		      
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl12c";
		String username = "orcl12c";
		String password = "oracle";
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}
	
	public static void testConnection()
	{
		//Test Connection
				Connection conn = null;
			    Statement stmt = null;
			    try {
			      conn = getConnection();
			      stmt = conn.createStatement();
			      stmt.executeUpdate(CUSTOMER_TABLE);
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
	
	public static void quit()
	{
		System.out.println("PROGRAM END...");
		System.exit(0);
	}
	
	public static void logoutPrompt()
	{
		System.out.println("\n--------------------------------------------------");
		System.out.println("Are you sure you want to logout?\n" +
							"*Type yes or no");
		System.out.println("--------------------------------------------------");
		boolean done = false;
		while(!done)
		{
			System.out.print(">");
			answer = scan.nextLine();
			switch(answer)
			{
				case "yes": 
					quit();
				case "no": 
					System.out.println("Thanks for staying with us!");
					done = true;
					break;
				default:
					System.out.println("I couldn't quiet catch that.");
			}
		}
		
	}
	
	public static void opener()
	{
		System.out.println("\n--------------------------------------------------");
		System.out.println("WELCOME to General Motors!\n" +
							"Would you like to:\n" + 
							"Login or Create an Account\n" +
							"*Type either login or create or quit");
		System.out.println("--------------------------------------------------");
		System.out.print(">");
	}
	
	public static int loginPrompt()
	{
		while(true)
		{
			int successful = 0;
			System.out.println("\nType 'back' to go to the previous menu.");
			System.out.print("Email: ");
			String email = scan.nextLine();
						
			if(email.equals("back"))
			{
				return successful;
			}
			
			System.out.print("Password: ");
			String pass = scan.nextLine();
			
			if(manager.verifyLogin(email, pass) == 1)
			{
				successful = 1;
				return successful;
			}
			
		}
	}
	
	public static void customerMenu()
	{
		boolean done = false;
		while(!done)
		{
			System.out.println("Enter the corresponding number for a particular option listed.");
			System.out.println("1 - Account Information");
			System.out.println("2 - Transaction History");
			System.out.println("3 - Purchase new Vehicle");
			System.out.print(">");
			String answer = scan.nextLine();
			switch(answer)
			{
				case "1": viewCustomerAccountInfo();
						break;
				case "2": viewTransactionHistory();
						break;
				case "3": purchaseVehicle();
						break;
				default:
					System.out.println("Input not available.");
			}
		}
	}
	
	public static void viewCustomerAccountInfo()
	{
		Customer c = (Customer) manager.account;
		System.out.println("First Name: " + c.getFirstName());
		System.out.println("Last Name: " + c.getLastName());
		System.out.println("Email: " + c.getEmail());
		System.out.println("Password: " + c.getPassword());
		System.out.println("CustomerID : " + c.getCustomerID());
		System.out.println("Phone number: " + c.getPhoneNumber());
		System.out.println("City: " + c.getCity());
		System.out.println("Gender: " + c.getGender());
		System.out.println("Annual Income: " + c.getAnnualIncome());
	}
	
	public static void viewTransactionHistory()
	{
		//Grab Transaction data from database
	}
	
	public static void purchaseVehicle()
	{
		//Purchase a vehicle from database
	}
	
	public static int createAccountPrompt()
	{
		String type;
		boolean done = false;
		int successful = 0;
		while(!done)
		{			
			System.out.println("\nWhat type of user are you?\n"
								+ " Customer or Employee or back");
			System.out.print(">");
			type = scan.nextLine();
						
			if(type.equals("back"))
			{
				return 0;
			}
			
			type = type.toLowerCase();
			
			switch(type)
			{
				case "customer":
					type = "C";
					makeCustomerAccount();
					successful = 1;
					done = true;
					break;
				case "employee":
					type = "E";
					makeEmployeeAccount();
					successful = 1;
					done = true;
					break;
				default:
					System.out.println("Not a valid option try again\n");
			}
		
		}
		return successful;
	}
	
	public static void makeCustomerAccount()
	{
		System.out.print("First Name: ");
		String firstName = scan.nextLine();
		
		System.out.print("Last Name: ");
		String lastName = scan.nextLine();
			
		System.out.print("Email: ");
		String email = scan.nextLine();
			
		System.out.print("Password: ");
		String pass = scan.nextLine();
			
		System.out.print("Phone number: ");
		String phone = scan.nextLine();
		
		System.out.print("City: ");
		String city = scan.nextLine();
			
		System.out.print("Gender: ");
		char gender = scan.nextLine().charAt(0);
			
		System.out.print("Annual Income: ");
		int annualIncome = scan.nextInt();
		
		manager.createCustomerAccount(email, pass, firstName, lastName, phone, city, gender, annualIncome);
	}
	
	public static void makeEmployeeAccount()
	{
		System.out.print("First Name: ");
		String firstName = scan.nextLine();
		
		System.out.print("Last Name: ");
		String lastName = scan.nextLine();
			
		System.out.print("Email: ");
		String email = scan.nextLine();
			
		System.out.print("Password: ");
		String pass = scan.nextLine();
			
		System.out.print("Phone number: ");
		String phone = scan.nextLine();
			
		System.out.print("Annual Income: ");
		int annualIncome = scan.nextInt();
		
		manager.createEmployeeAccount(email, pass, firstName, lastName, phone, annualIncome);
	}
	
}


