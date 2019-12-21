/**
 * The following class is a general definition of an Account for a website.
 *
 */
public class Account
{
	private String email, password, firstName, lastName;
	
	public Account(String email, String password, String firstName, String lastName)
	{
		this.email = email; 
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Return the email address of the account.
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the email address of the account.
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Return the password of the account.
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the password of the account.
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Return the first name of the account.
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set the first name of the account.
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Return the last name of the account.
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set the last name of the account.
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}




