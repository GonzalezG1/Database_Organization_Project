/**
 * This is an account for a Employee.
 *
 */
public class Employee extends Account
{
	private String phoneNumber;
	private int employeeID, dealerID, annualIncome;
	
	public Employee(String email, String password, String firstName, String lastName, String phoneNumber, int annualIncome)
	{
		super(email, password, firstName, lastName);
		this.phoneNumber = phoneNumber;
		this.annualIncome = annualIncome;
		employeeID = 0;
		dealerID = 0;
	}
	
	/**
	 * Return the employee's phoneNumber.
	 * @return phoneNumber
	 */
	public String getPhoneNumber() 
	{
		return phoneNumber;
	}

	/**
	 * Set the employee's phoneNumber.
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Return the employee's dealerID.
	 * @return dealerID
	 */
	public int getDealerID() 
	{
		return dealerID;
	}

	/**
	 * Set the employee's dealerID.
	 * @param dealerID
	 */
	public void setDealer(int dealerID) {
		this.dealerID = dealerID;
	}
	
	/**
	 * Return the employee's ID.
	 * @return employeeID
	 */
	public int getEmployeeID() 
	{
		return employeeID;
	}

	/**
	 * Set the employee's ID.
	 * @param employeeID
	 */
	public void setEmployeeID(int customerID) {
		this.employeeID = customerID;
	}
	
	/**
	 * Return the employee's annual income.
	 * @return annualIncome
	 */
	public int getAnnualIncome() 
	{
		return annualIncome;
	}

	/**
	 * Set the employee's annualIncome.
	 * @param annualIncome
	 */
	public void setAnnualIncome(int annualIncome) {
		this.annualIncome = annualIncome;
	}
}

