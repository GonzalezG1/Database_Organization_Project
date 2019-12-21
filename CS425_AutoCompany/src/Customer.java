/**
 * This is an account for a Customer.
 *
 */
public class Customer extends Account
{
	private String phoneNumber, city;
	private char gender;
	private int customerID, annualIncome;
	
	public Customer(String email, String password, String firstName, String lastName, String phoneNumber, String city, char gender, int annualIncome)
	{
		super(email, password, firstName, lastName);
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.gender = gender;
		this.annualIncome = annualIncome;
		customerID = 0;;
	}
	
	/**
	 * Return the customer's phoneNumber.
	 * @return phoneNumber
	 */
	public String getPhoneNumber() 
	{
		return phoneNumber;
	}

	/**
	 * Set the customer's phoneNumber.
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Return the customer's city.
	 * @return city
	 */
	public String getCity() 
	{
		return city;
	}

	/**
	 * Set the customer's city.
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Return the customer's gender.
	 * @return gender
	 */
	public char getGender() 
	{
		return gender;
	}

	/**
	 * Set the customer's gender.
	 * @param gender
	 */
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	/**
	 * Return the customer's ID.
	 * @return customerID
	 */
	public int getCustomerID() 
	{
		return customerID;
	}

	/**
	 * Set the customer's ID.
	 * @param customerID
	 */
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	/**
	 * Return the customer's annual income.
	 * @return annualIncome
	 */
	public int getAnnualIncome() 
	{
		return annualIncome;
	}

	/**
	 * Set the customer's annualIncome.
	 * @param annualIncome
	 */
	public void setAnnualIncome(int annualIncome) {
		this.annualIncome = annualIncome;
	}
}


