/**
 * Name: Joel Mbah
 * Class: CMSC 204
 * Professor Huseyin Aygun
 * 09/14/2025
 * Project 1 Implementation
 */

import java.util.Objects;

public class UserAccount {
	static final int MAX_FAILURES = 3;
	private String username;
	private String encryptedPassword; // to store only the hashed version of the password
	private int failureCount;
	private boolean locked;
	
	public UserAccount( String username, String encryptedPassword)  // constructor for the UserAccount class
	{
		if(username == null || username.isEmpty())
			throw new IllegalArgumentException ("Username cannot be empty");
		
		if (encryptedPassword == null || encryptedPassword.isEmpty())
			throw new IllegalArgumentException ("Encrypted password cannot be empty");
		
		this.username = username;
		this.encryptedPassword = encryptedPassword;
		this.failureCount = 0;
		this.locked = false;
	}
	
	//creating another constructor to take just username so i can use it for my comparison
	public UserAccount(String username)
	{
		if(username == null || username.isEmpty())
			throw new IllegalArgumentException ("Username cannot be empty");
		
		this.username = username;
		this.failureCount = 0;
		this.locked = false;
	}
	
	//getter for locked
	public boolean getLocked()
	{
		return locked;
	}
	
	//getter for username
	public String getUsername()
	{
		return username;
	}
	
	
	public void incrementFailureCount() // This method increments the failure count
	{
		if (!locked)
		{
			failureCount++;
			if(failureCount >= MAX_FAILURES)
			{
				locked = true; // locks the account after the maximum number of failed attempts
			}
		}
	}
	
	public void resetFailureCount() // this method resets the failure count
	{
		failureCount = 0;
	}
	
	public boolean checkLock() // this method checks if the account is locked
	{
		return locked;
	}
	
	public boolean checkPassword (String password) throws AccountLockedException, PasswordIncorrectException
	{
		if(locked)
		{
			throw new AccountLockedException ("User '" + username + "' account is locked.");
		}
		if(password == null)
		{
			throw new IllegalArgumentException ("Password cannot be null");
		}
		if (!password.equals(encryptedPassword))
		{
			incrementFailureCount();
			throw new PasswordIncorrectException("Incorrect password");
			
		}
		else
		{
			resetFailureCount();
			return true;
		}
	}
	
	private String hash(String password)
	{
		return Integer.toHexString(password.hashCode()); // I did no know how to code this part for the hashing, so I looked this part up
	}
	
	@Override // didnt learn this part from class yet, so I had to look this part up
	public int hashCode()
	{
		return Objects.hash(username);
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(!(obj instanceof UserAccount))
			return false;
		UserAccount temp = (UserAccount) obj;
		return this.username.equals(temp.username);
	}
	
	@Override
	public String toString()
	{
		return username;
	}
	

}
