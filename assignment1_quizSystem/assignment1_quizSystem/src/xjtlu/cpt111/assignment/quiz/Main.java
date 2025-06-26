package xjtlu.cpt111.assignment.quiz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.*;

public class Main extends Application {
    private List<User> users = new ArrayList<>();
    private AuthService authService = new AuthService(users);
    private List<xjtlu.cpt111.assignment.quiz.model.Question> allQuestions = new ArrayList<>();
    private ScoreUtils scoreUtils = new ScoreUtils();
    private User currentUser;
    private Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        authService.loadUsersFromCSV("resources/users.csv");
        ReadQuestions.loadQuestions(allQuestions);

        window.setTitle("Quiz System");

        showLoginScene();
    }

    private void showLoginScene() {
        VBox loginLayout = new VBox(10);
        Label welcomeLabel = new Label("Welcome to the Quiz System!");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> handleLogin(usernameField.getText(), passwordField.getText()));

        Button registerButton = new Button("Register");
        registerButton.setOnAction(e -> showRegisterScene());

        loginLayout.getChildren().addAll(welcomeLabel, usernameField, passwordField, loginButton, registerButton);
        Scene loginScene = new Scene(loginLayout, 300, 200);

        window.setScene(loginScene);
        window.show();
    }

    private void showRegisterScene() {
        VBox registerLayout = new VBox(10);
        TextField userIdField = new TextField();
        userIdField.setPromptText("User ID");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button registerButton = new Button("Register");
        registerButton.setOnAction(e -> handleRegister(userIdField.getText(), usernameField.getText(), passwordField.getText()));

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> showLoginScene());

        registerLayout.getChildren().addAll(userIdField, usernameField, passwordField, registerButton, backButton);
        Scene registerScene = new Scene(registerLayout, 300, 200);

        window.setScene(registerScene);
    }

    private void handleLogin(String username, String password) {
        User user = authService.authenticate(username, password);
        if (user != null) {
            currentUser = user;
            showMainMenuScene();
        } else {
            showAlert("Login Failed", "Invalid username or password.");
        }
    }

    private void handleRegister(String userId, String username, String password) {
        if (authService.register(userId, username, password, "resources/users.csv")) {
            showAlert("Registration Successful", "You can now log in.");
            showLoginScene();
        } else {
            showAlert("Registration Failed", "Username already exists.");
        }
    }

    private void showMainMenuScene() {
        VBox menuLayout = new VBox(10);
        Label welcomeLabel = new Label("Welcome, " + currentUser.getUsername() + "!");
        Button quizButton = new Button("Take Quiz");
        quizButton.setOnAction(e -> takeQuiz());

        Button leaderboardButton = new Button("View Leaderboard");
        leaderboardButton.setOnAction(e -> scoreUtils.view_leaderboard());

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> {
            currentUser = null;
            showLoginScene();
        });

        menuLayout.getChildren().addAll(welcomeLabel, quizButton, leaderboardButton, logoutButton);
        Scene menuScene = new Scene(menuLayout, 300, 200);

        window.setScene(menuScene);
    }

    private void takeQuiz() {
        if (allQuestions.isEmpty()) {
            showAlert("Quiz Error", "No questions available.");
            return;
        }
        Quiz quiz = new Quiz(allQuestions, currentUser);
        quiz.startQuiz(); // Assuming this method handles UI interactions.
        scoreUtils.saveScores(users);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
