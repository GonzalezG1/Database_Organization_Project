import java.util.Hashtable;
import java.lang.Exception;
import java.io.*;
/**
 * This class Manages the logins for the accounts and makes sure they are valid.
 *
 */
public class AccountManager 
{
	public Account account; //This holds the currently signed in account information.
	private Hashtable<String, String> accountInfo; //This will store the email addresses and passwords.
	private File accountFile; //This file holds the accounts login information for loading for later use of the program.
	private int numOfEmployees, numOfCustomers;
	
	/**
	 * Constructor for the Account Manager. The login information is loaded from a file and populates the contents of the arrays and hash table.
	 */
	public AccountManager()
	{
		accountInfo = new Hashtable<String, String>();
		numOfEmployees = 0;
		numOfCustomers = 0;
		loadAccountData();
	}
	
	
	public void loadAccountData() 
	{
		//accountFile = new File("accountInfo.txt");
		try
		  {
		    BufferedReader reader = new BufferedReader(new InputStreamReader(AccountManager.class.getResourceAsStream("accountInfo.txt")));
		    String line;
		    String []data;
		    while ((line = reader.readLine()) != null)
		    {
		      data = line.split(" "); //Take out spaces in the line and return an array of string.
		      //The contents are [email, password, account type]
		      accountInfo.put(data[0], data[1]);
		      switch(data[2])
		      {
		    	  case "E": 
		    		  numOfEmployees += 1;
		    		  break;
		    	  case "C": 
		    		  numOfCustomers += 1;
		    		  break;
		    	  default: throw new Exception();
		      }
		    }
		    reader.close();
		  }
		  catch (Exception e)
		  {
		    System.err.format("Exception occurred trying to read '%s'.", accountFile);
		    e.printStackTrace();
		  }
	}
	
	public int verifyLogin(String email, String password)
	{
		int infoValid = 0;
		boolean emailValid = false;
		boolean passValid = false;
		emailValid = accountInfo.containsKey(email);
		passValid = accountInfo.contains(password);
		if(emailValid)
		{
			if(passValid)
			{
				infoValid = 1;
				System.out.println("Login Successful");
			}
			else
			{
				System.out.println("Inccorrect Password");
			}
		}
		else
		{
			System.out.println("Email does not exist.");
		}
		return infoValid;
	}
	
	public void createCustomerAccount(String email, String password, String firstName, String lastName, String phoneNumber, String city, char gender, int annualIncome)
	{
		Customer c = new Customer(email, password, firstName, lastName, phoneNumber, city, gender, annualIncome);
		c.setCustomerID(numOfCustomers + 1);
		numOfCustomers += 1;
		account = c;
		saveAccountLogin(email, password, "C");
		/**
		 * ADD CUSTOMER TO THE DATABASE
		 */
	}
	
	public void createEmployeeAccount(String email, String password, String firstName, String lastName, String phoneNumber, int annualIncome)
	{
		Employee e = new Employee(email, password, firstName, lastName, phoneNumber, annualIncome);
		e.setEmployeeID(numOfEmployees + 1);
		numOfEmployees += 1;
		account = e;
		saveAccountLogin(email, password, "E");
		/**
		 * ADD CUSTOMER TO THE DATABASE
		 */
	}
	
	public void saveAccountLogin(String email, String password, String type)
	{
		accountFile = new File(System.getProperty("user.dir") + "\\src\\accountInfo.txt");
		try
		  {
			BufferedWriter writer = new BufferedWriter(new FileWriter(accountFile, true));
		    writer.write(email + " " + password + " " + type + "\n");
		    writer.close();
		  }
		  catch (Exception e)
		  {
		    System.err.format("Exception occurred trying to read '%s'.", accountFile);
		    e.printStackTrace();
		  }
	}
	
}


