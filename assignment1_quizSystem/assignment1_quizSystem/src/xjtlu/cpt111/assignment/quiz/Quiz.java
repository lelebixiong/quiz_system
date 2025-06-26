package xjtlu.cpt111.assignment.quiz;

import java.util.*;

public class Quiz {
    private List<xjtlu.cpt111.assignment.quiz.model.Question> questions;
    private User user;
    private int score;
    private int topic;

    // Constructor: Initializes the Quiz object with a user and selects questions based on a topic
    public Quiz(List<xjtlu.cpt111.assignment.quiz.model.Question> allQuestions, User user) {
        this.user = user;
        this.score = 0;
        // Calls the method to select questions based on the user's topic choice
        this.questions = selectTopicQuestions(allQuestions);
    }
    boolean is_multiple_choice(List<xjtlu.cpt111.assignment.quiz.model.Option> options) {
        int correct_count = 0;
        // Count the number of correct answers
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).isCorrectAnswer()) {
                correct_count++;
            }
        }
        // If more than one correct answer exists, it is a multiple-choice question
        return correct_count > 1;
    }
    // Method to select questions based on the topic chosen by the user
    private List<xjtlu.cpt111.assignment.quiz.model.Question> selectTopicQuestions(List<xjtlu.cpt111.assignment.quiz.model.Question> allQuestions) {
        Scanner scanner = new Scanner(System.in);
        Set<String> availableTopics = new HashSet<>();

        // Collect all available topics from the questions list
        for (xjtlu.cpt111.assignment.quiz.model.Question question : allQuestions) {
            availableTopics.add(question.getTopic());
        }

        // Display the available topics to the user
        System.out.println("Available Topics:");
        int index = 1;
        Map<Integer, String> topicMap = new HashMap<>();
        for (String topic : availableTopics) {
            System.out.println(index + ". " + topic);
            topicMap.put(index++, topic);
        }

        // Get the user's topic selection and validate input
        int selected_topic = -1;
        while (true) {
            System.out.print("Select a topic (1-" + availableTopics.size() + "): ");
            try {
                selected_topic = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                // If the input is valid, break the loop
                if (selected_topic >= 1 && selected_topic <= availableTopics.size()) {
                    String selectedTopic = topicMap.get(selected_topic);
                    System.out.println("You have selected: " + selectedTopic + "\n");
                    break;
                } else {
                    System.out.println("Invalid option! Please choose a number between 1 and " + availableTopics.size() + ".");
                }
            } catch (InputMismatchException e) {
                // Handle invalid input and prompt the user to enter a valid number
                System.out.println("Invalid input, please enter a valid number.");
                scanner.nextLine();  // Clear the buffer
            }
        }
        this.topic = selected_topic;

        // Filter the questions based on the selected topic
        List<xjtlu.cpt111.assignment.quiz.model.Question> selectedQuestions = new ArrayList<>();
        for (xjtlu.cpt111.assignment.quiz.model.Question question : allQuestions) {
            if (question.getTopic().equals(topicMap.get(selected_topic))) {
                selectedQuestions.add(question);
            }
        }

        // Create lists for each difficulty level
        List<xjtlu.cpt111.assignment.quiz.model.Question> easy_question = new ArrayList<>();
        List<xjtlu.cpt111.assignment.quiz.model.Question> medium_question = new ArrayList<>();
        List<xjtlu.cpt111.assignment.quiz.model.Question> hard_question = new ArrayList<>();
        List<xjtlu.cpt111.assignment.quiz.model.Question> veryhard_question = new ArrayList<>();
        List<xjtlu.cpt111.assignment.quiz.model.Question> final_question = new ArrayList<>();

        // Classify the questions into difficulty categories (easy, medium, hard, very hard)
        // If a question has only one option, it is ignored
        // If a question has more than one answer,it is ignored
        for (xjtlu.cpt111.assignment.quiz.model.Question question : selectedQuestions) {
            if (question.getDifficulty().toString().equals("EASY") && question.getOptions().length > 1 && !is_multiple_choice(Arrays.asList(question.getOptions()))) {
                easy_question.add(question);
            } else if (question.getDifficulty().toString().equals("MEDIUM") && question.getOptions().length > 1 && !is_multiple_choice(Arrays.asList(question.getOptions()))) {
                medium_question.add(question);
            } else if (question.getDifficulty().toString().equals("HARD") && question.getOptions().length > 1 && !is_multiple_choice(Arrays.asList(question.getOptions()))) {
                hard_question.add(question);
            } else if (question.getDifficulty().toString().equals("VERY_HARD") && question.getOptions().length > 1 && !is_multiple_choice(Arrays.asList(question.getOptions()))) {
                veryhard_question.add(question);
            }
        }

        // Randomly select one question from each difficulty level
        Random random = new Random();
        int easy_index = random.nextInt(easy_question.size());
        int medium_index = random.nextInt(medium_question.size());
        int hard_index = random.nextInt(hard_question.size());
        int veryhard_index = random.nextInt(veryhard_question.size());

        // Add the selected questions to the final list
        final_question.add(easy_question.get(easy_index));
        final_question.add(medium_question.get(medium_index));
        final_question.add(hard_question.get(hard_index));
        final_question.add(veryhard_question.get(veryhard_index));

        return final_question; // Return the final list of selected questions
    }

    // Method to check if a question is a multiple-choice question


    // Start the quiz and display questions to the user
    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        // Display the questions in order
        for (xjtlu.cpt111.assignment.quiz.model.Question question : questions) {
            System.out.println("Question: " + question.getQuestionStatement() + " Difficulty: " + question.getDifficulty());

            // Convert the array of options to a List<Option>
            List<xjtlu.cpt111.assignment.quiz.model.Option> options = Arrays.asList(question.getOptions());

            // Shuffle the options to randomize their order
            Collections.shuffle(options);

            // Check if the question is a multiple-choice question
            boolean isMultipleChoice = is_multiple_choice(options);

            // Display the options
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i).getAnswer());
            }

            // Collect the user's selected options
            List<Integer> selectedOptions = new ArrayList<>();

            // Handle input for single-choice questions
            int selectedOption = -1;
            while (true) {
                try {
                    selectedOption = scanner.nextInt() - 1;  // Subtract 1 for zero-based indexing
                    scanner.nextLine();  // Clear newline character
                    if (selectedOption >= 0 && selectedOption < options.size()) {
                        selectedOptions.add(selectedOption);
                        break;
                    } else {
                        System.out.println("Invalid option! Please select a valid option.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a valid number.");
                    scanner.nextLine();  // Clear buffer
                }
            }

            // Check if all selected options are correct
            boolean allCorrect = true;
            for (int index : selectedOptions) {
                if (!options.get(index).isCorrectAnswer()) {
                    allCorrect = false;
                    break;
                }
            }

            // Provide feedback to the user
            if (allCorrect) {
                System.out.println("Your answer is correct!\n");
                score++;  // Increase score for correct answers
            } else {
                System.out.println("Your answer is wrong. The correct answer(s): ");
                for (int i = 0; i < options.size(); i++) {
                    if (options.get(i).isCorrectAnswer()) {
                        System.out.println("Option " + (i + 1) + ": " + options.get(i).getAnswer());
                    }
                }
                System.out.println();
            }
        }

        // Update the user's score for the specific topic
        user.updateScore(score, this.topic);
        System.out.println("Quiz completed! Your score: " + score);
    }
}
