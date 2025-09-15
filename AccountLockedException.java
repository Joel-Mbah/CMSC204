/**
 * Name: Joel Mbah
 * Class: CMSC 204
 * Professor Huseyin Aygun
 * 09/14/2025
 * Project 1 Implementation
 */
public class AccountLockedException extends Exception{
	public AccountLockedException()
	{
		super("Account is locked"); //Custom class for AccountLockedException, that inherits from the parent class of Exception
	}

	public AccountLockedException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
	

}
