/**
 * Name: Joel Mbah
 * Class: CMSC 204
 * Professor Huseyin Aygun
 * 09/14/2025
 * Project 1 Implementation
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class UserAccessManager extends Object {
	private List <UserAccount> accounts;
	
	public UserAccessManager() 
	{
		accounts = new ArrayList<>();
	}
	
	
	
	public void addUser(String username, String encryptedPassword) throws DuplicateUserException,InvalidCommandException
	{
		if (username == null || username.trim().isEmpty()
				|| encryptedPassword == null || encryptedPassword.trim().isEmpty())
		{
			throw new InvalidCommandException("Username or password is null or empty");
		}
		
		//String ePassword = Utilities.encryptPassword(encryptedPassword);
	    UserAccount tempUser = new UserAccount(username, encryptedPassword);
	    if(accounts.contains(tempUser))  //create a new UserAccount object and scan through accounts to see if accounts already contains it
		    throw new DuplicateUserException("User '" + username + "' already exists.");
		
	    accounts.add(tempUser);
	    //accounts.add(new UserAccount(username, encryptedPassword)); // adds the new user to the list with the encrypted password
	}
	
	
	public void removeUser(String username) throws UserNotFoundException, InvalidCommandException
	{
		if(username == null || username.trim().isEmpty())
			throw new InvalidCommandException("Username is null or empty.");
		
		UserAccount tempUser = new UserAccount(username);
		if(!accounts.contains(tempUser))
			throw new UserNotFoundException("User not found");
		
		accounts.remove(tempUser);
	}
	
	
	public boolean verifyAccess (String username, String encryptedPassword) throws UserNotFoundException, AccountLockedException, PasswordIncorrectException, InvalidCommandException
	{
		if(username == null || username.trim().isEmpty())
		{
			throw new InvalidCommandException ("Username is null or empty");
		}
		if (encryptedPassword == null || encryptedPassword.trim().isEmpty())
		{
			throw new InvalidCommandException ("Encrypted password is null or empty");
		}
			
		//String ePassword = Utilities.encryptPassword(encryptedPassword);
		for (UserAccount storedUser : accounts)
		{ // I am using a loop to go through the list to find the saved user and use the encrypted password as a parameter in the checkPassword method call.
			if (storedUser.getUsername().equals(username)) {
				String ePassword = Utilities.encryptPassword(encryptedPassword);
				return storedUser.checkPassword(encryptedPassword);// since the checkPassword method in the UserAccount class already has all 
			}
			}																//these exceptions, I will just call the method to avoid redundancy
	
		throw new UserNotFoundException("User '" + username + "' not found");
	}
	
	public void loadAccount(String filename) throws FileNotFoundException
	{
		
		Utilities.readAccountFile(filename, this);
		
	}
	
	
	
}
