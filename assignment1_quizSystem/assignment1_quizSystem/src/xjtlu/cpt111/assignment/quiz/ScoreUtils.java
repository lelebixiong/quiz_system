package xjtlu.cpt111.assignment.quiz;
import java.io.*;
import java.util.*;

public class ScoreUtils {
    // The file path to save and load the score data
    private static final String SCORE_FILE = "resources/score.txt";

    // Method to save the scores of all users to the score.txt file
    public static void saveScores(List<User> users) {
        try  {
            // Create a FileWriter and BufferedWriter to write the data to the file
            FileWriter fileWriter = new FileWriter(SCORE_FILE);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Iterate through each user and write their data (ID, username, and scores) to the file
            for (User user : users) {
                bufferedWriter.write(user.getUserId() + ","
                        + user.getUsername() +
                        "," + user.getScore(1) + // English score
                        "," + user.getScore(2) + // Computer Science score
                        "," + user.getScore(3) + // Mathematics score
                        "," + user.getScore(4)); // Electronics Engineering score
                bufferedWriter.newLine(); // Move to the next line after each user's data
            }
            // Close the BufferedWriter
            bufferedWriter.close();
        } catch (IOException ioe) {
            // If an exception occurs while writing to the file, print the error message
            System.out.println(ioe.getMessage());
        }
    }

    // Method to load the scores from the score.txt file and return them as a list of users
    public static List<User> loadScores() {
        List<User> users = new ArrayList<>();
        File scoreFile = new File(SCORE_FILE); // Create a File object pointing to the score.txt file

        try {
            // Create a FileReader and BufferedReader to read the data from the file
            FileReader fileReader = new FileReader(SCORE_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            // Read each line of the file until there are no more lines
            while ((line = bufferedReader.readLine()) != null) {
                // Split the line by commas to extract the user data
                String[] parts = line.split(",");
                // Create a new User object and add it to the users list
                users.add(new User(parts[0], parts[1],
                        Integer.parseInt(parts[2]), // English score
                        Integer.parseInt(parts[3]), // Computer Science score
                        Integer.parseInt(parts[4]), // Mathematics score
                        Integer.parseInt(parts[5]))); // Electronics Engineering score
            }
        } catch (IOException ioe) {
            // If an exception occurs while reading from the file, print the error message
            System.out.println(ioe.getMessage());
        }
        return users; // Return the list of users loaded from the file
    }

    // Method to display the leaderboard by showing the highest score for each subject
    public static void view_leaderboard() {
        // Load the list of users and find the highest score for each subject
        List<User> users = loadScores();

        // Initialize the highest score for each subject with the first user in the list
        User English_highest = users.get(0);
        User CS_highest = users.get(0);
        User Mathematics_highest = users.get(0);
        User EE_highest = users.get(0);

        // Iterate through the users and compare their scores to find the highest in each subject
        for(User user : users) {
            if(English_highest.getScore(1) < user.getScore(1)) {
                English_highest = user;
            }
            if(CS_highest.getScore(2) < user.getScore(2)) {
                CS_highest = user;
            }
            if(Mathematics_highest.getScore(3) < user.getScore(3)) {
                Mathematics_highest = user;
            }
            if(EE_highest.getScore(4) < user.getScore(4)) {
                EE_highest = user;
            }
        }

        // Display the leaderboard with the highest scoring user for each subject
        System.out.println("\nThe leaderboard:");
        System.out.println("English:");
        System.out.println("id:" + English_highest.getUserId() + " Name:" + English_highest.getUsername() + " Score:" + English_highest.getScore(1));
        System.out.println("Computer Science:");
        System.out.println("id:" + CS_highest.getUserId() + " Name:" + CS_highest.getUsername() + " Score:" + CS_highest.getScore(2));
        System.out.println("Mathematics:");
        System.out.println("id:" + Mathematics_highest.getUserId() + " Name:" + Mathematics_highest.getUsername() + " Score:" + Mathematics_highest.getScore(3));
        System.out.println("Electronics Engineering:");
        System.out.println("id:" + EE_highest.getUserId() + " Name:" + EE_highest.getUsername() + " Score:" + EE_highest.getScore(4));
        System.out.println();
    }
}
