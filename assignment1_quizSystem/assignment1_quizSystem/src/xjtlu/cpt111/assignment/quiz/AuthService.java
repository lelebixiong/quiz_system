package xjtlu.cpt111.assignment.quiz;
import java.io.*;
import java.util.*;

public class AuthService {
    private List<User> users;

    // Constructor to initialize the AuthService with a list of users
    public AuthService(List<User> users) {
        this.users = users;
    }

    // Load users from a CSV file and add them to the users list
    public void loadUsersFromCSV(String filePath) {
        File file = new File(filePath);
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                String student = input.nextLine();
                String[] values = student.split(",");  // Split each line by comma
                String userId = values[0];
                String username = values[1];
                String password = values[2]; // Read password as string
                users.add(new User(userId, username, password)); // Add the user to the list
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath); // Handle file not found
        }
    }

    // Register a new user if the username does not already exist
    public boolean register(String userId, String username, String password, String filePath) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false; // Username already exists
            }
        }
        users.add(new User(userId, username, password)); // Add new user to the list
        // Save the new user to the CSV file
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(userId + "," + username + "," + password); // Write user data to file
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage()); // Handle file write errors
        }
        return true; // Registration successful
    }

    // Authenticate the user by checking if the username and password match
    public User authenticate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user; // Return the user if credentials are correct
            }
        }
        return null; // Authentication failed
    }
}
