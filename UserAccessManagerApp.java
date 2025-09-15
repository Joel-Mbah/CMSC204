/**
 * Name: Joel Mbah
 * Class: CMSC 204
 * Professor Huseyin Aygun
 * 09/14/2025
 * Project 1 Implementation
 */

import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserAccessManagerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserAccessManager uam = new UserAccessManager();

        System.out.println("User access manager ready.");

        while (true) {
            System.out.print("User Access Manager> ");
            String command = scanner.next();

            if (command.equals("exit")) {
                System.out.println("Goodbye.");
                break;
            }
            else if (command.equals("add")) {
                String username = scanner.nextLine().trim();
                if (username.isEmpty()) {
                    System.out.println("Error: Username is null or empty");
                    continue;
                }

                System.out.print("Password: ");
                String password = scanner.nextLine().trim();
                if (password.isEmpty()) {
                    System.out.println("Error: Password is null or empty");
                    continue;
                }

                try {
                    uam.addUser(username, Utilities.encryptPassword(password));
                    System.out.println("User '" + username + "' added.");
                } catch (DuplicateUserException e) {
                    System.out.println("User '" + username + "' account already exists.");
                } catch (InvalidCommandException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            else if (command.equals("remove")) {
                String username = scanner.nextLine().trim();
                if (username.isEmpty()) {
                    System.out.println("Error: Username is null or empty");
                    continue;
                }
                try {
                    uam.removeUser(username);
                    System.out.println("User '" + username + "' removed.");
                } catch (UserNotFoundException e) {
                    System.out.println("User not found.");
                } catch (InvalidCommandException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            else if (command.equals("verify")) {
                String username = scanner.nextLine().trim();
                if (username.isEmpty()) {
                    System.out.println("Error: Username is null or empty");
                    continue;
                }

                System.out.print("Password: ");
                String password = scanner.nextLine().trim();
                if (password.isEmpty()) {
                    System.out.println("Error: Password is null or empty");
                    continue;
                }

                try {
                    boolean ok = uam.verifyAccess(username, password);
                    if (ok) {
                        System.out.println("Access verified");
                    }
                } catch (UserNotFoundException e) {
                    System.out.println("User not found.");
                } catch (AccountLockedException e) {
                    System.out.println("User '" + username + "' account is locked.");
                } catch (PasswordIncorrectException e) {
                    System.out.println("Incorrect password");
                } catch (InvalidCommandException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            else if (command.equals("load")) {
                String filename = scanner.nextLine().trim();
                if (filename.isEmpty()) {
                    System.out.println("Error: Filename is null or empty");
                    continue;
                }
                try {
                    uam.loadAccount(filename);
                    System.out.println("Loaded accounts from " + filename);
                } catch (FileNotFoundException e) {
                    System.out.println("Unable to load file: " + filename);
                }
            }
            else {
                System.out.println("Error: Unknown command");
            }
        }
    }
}
