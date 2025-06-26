package xjtlu.cpt111.assignment.quiz;

import java.util.*;

public class User {
    private String userId; // User ID
    private String username; // Username
    private String password; // Password
    private int english_score; // English score
    private int cs_score; // Computer Science score
    private int mathematics_score; // Mathematics score
    private int ee_score; // Electronics Engineering score

    private List<Integer> english_history;  // History of English test scores
    private List<Integer> cs_history;  // History of Computer Science test scores
    private List<Integer> mathematics_history;  // History of Mathematics test scores
    private List<Integer> ee_history;  // History of Electronics Engineering test scores

    // Constructor 1: Default constructor (only takes userId, username, and password)
    public User(String userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.english_score = 0;
        this.cs_score = 0;
        this.mathematics_score = 0;
        this.ee_score = 0;

        this.english_history = new ArrayList<>();
        this.cs_history = new ArrayList<>();
        this.mathematics_history = new ArrayList<>();
        this.ee_history = new ArrayList<>();
    }

    // Constructor 2: Takes userId, username, and scores for each subject
    public User(String userId, String username, int english_score, int cs_score, int mathematics_score, int ee_score) {
        this.userId = userId;
        this.username = username;
        this.english_score = english_score;
        this.cs_score = cs_score;
        this.mathematics_score = mathematics_score;
        this.ee_score = ee_score;

        this.english_history = new ArrayList<>();
        this.cs_history = new ArrayList<>();
        this.mathematics_history = new ArrayList<>();
        this.ee_history = new ArrayList<>();
    }

    // Getters and Setters
    public String getUserId() {
        return userId; // Returns user ID
    }

    public String getUsername() {
        return username; // Returns username
    }

    public String getPassword() {
        return password; // Returns password
    }

    // Returns the score for a specific subject based on the given theme
    public int getScore(int theme) {
        if (theme == 1) { // "English"
            return this.english_score;
        } else if (theme == 2) { // "Computer Science"
            return this.cs_score;
        } else if (theme == 3) { // "Mathematics"
            return this.mathematics_score;
        } else if (theme == 4) { // "Electronics Engineering"
            return this.ee_score;
        }
        return 0;  // Default return value if no match
    }

    // Returns the history of test scores for a specific subject
    public List<Integer> getHistory(int theme) {
        if (theme == 1) { // "English"
            return this.english_history;
        } else if (theme == 2) { // "Computer Science"
            return this.cs_history;
        } else if (theme == 3) { // "Mathematics"
            return this.mathematics_history;
        } else if (theme == 4) { // "Electronics Engineering"
            return this.ee_history;
        }
        return new ArrayList<>();  // Returns an empty list if no match
    }

    // Updates the score for a specific subject and also updates the history of the test scores
    public void updateScore(int score, int theme) {
        if (theme == 1) { // "English"
            this.english_score += score;
            updateHistory(score, theme);  // Updates the history
        } else if (theme == 2) { // "Computer Science"
            this.cs_score += score;
            updateHistory(score, theme);  // Updates the history
        } else if (theme == 3) { // "Mathematics"
            this.mathematics_score += score;
            updateHistory(score, theme);  // Updates the history
        } else if (theme == 4) { // "Electronics Engineering"
            this.ee_score += score;
            updateHistory(score, theme);  // Updates the history
        }
    }

    // Updates the test history for a specific subject, keeping only the last 3 test scores
    private void updateHistory(int score, int theme) {
        if (theme == 1) { // "English"
            english_history.add(score);
            if (english_history.size() > 3) {
                english_history.remove(0); // Remove the oldest score if more than 3
            }
        } else if (theme == 2) { // "Computer Science"
            cs_history.add(score);
            if (cs_history.size() > 3) {
                cs_history.remove(0); // Remove the oldest score if more than 3
            }
        } else if (theme == 3) { // "Mathematics"
            mathematics_history.add(score);
            if (mathematics_history.size() > 3) {
                mathematics_history.remove(0); // Remove the oldest score if more than 3
            }
        } else if (theme == 4) { // "Electronics Engineering"
            ee_history.add(score);
            if (ee_history.size() > 3) {
                ee_history.remove(0); // Remove the oldest score if more than 3
            }
        }
    }

    // Displays the user's dashboard with their scores and recent test history
    public void viewDashboard() {
        System.out.println("\n" + username + "'s Dashboard:");
        System.out.println("English score: " + english_score);
        System.out.println("Computer Science score: " + cs_score);
        System.out.println("Mathematics score: " + mathematics_score);
        System.out.println("Electronics Engineering score: " + ee_score);

        // Display the history of the last 3 tests for each subject
        System.out.println("\nLast 3 English scores: " + formatHistory(english_history, "English"));
        System.out.println("Last 3 Computer Science scores: " + formatHistory(cs_history, "Computer Science"));
        System.out.println("Last 3 Mathematics scores: " + formatHistory(mathematics_history, "Mathematics"));
        System.out.println("Last 3 Electronics Engineering scores: " + formatHistory(ee_history, "Electronics Engineering"));
    }

    // Helper method to format the history with "Test 1", "Test 2", etc.
    private String formatHistory(List<Integer> history, String subject) {
        if (history.isEmpty()) {
            return "No scores yet"; // If there are no test scores, return a message indicating so
        }

        String result = "";
        int i = 1;
        for (Integer score : history) {
            result += subject + " Test " + i + ": " + score + " ";  // Append each test's score
            i++;
        }
        return result.trim();  // Return the formatted string without trailing spaces
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", English_score=" + this.english_score +
                ", cs_score=" + this.cs_score +
                ", mathematics_score=" + this.mathematics_score +
                ", ee_score=" + this.ee_score +
                '}'; // Custom string representation for the user object
    }
}
