package xjtlu.cpt111.assignment.quiz;

import xjtlu.cpt111.assignment.quiz.model.Question;
import xjtlu.cpt111.assignment.quiz.util.IOUtilities;

import java.util.List;
import java.util.ArrayList;  // Import ArrayList class

public class ReadQuestions {

	// Constant paths for resources and question bank directory
	private static final String RESOURCES_PATH = "src/main/resources/";
	private static final String QUESTIONS_BANK_PATH = "resources/questionsBank/";

	/**
	 * Loads questions from the questions bank and adds them to the provided list.
	 *
	 * @param allQuestions List to which the loaded questions will be added.
	 */
	public static void loadQuestions(List<Question> allQuestions) {
		// Set the file path for the question bank
		String filename = QUESTIONS_BANK_PATH;

		try {
			// Call IOUtilities to read the questions from the file
			Question[] questions = IOUtilities.readQuestions(filename);

			// If questions are successfully read, add them to the list
			if (questions != null && questions.length > 0) {
				for (Question question : questions) {
					allQuestions.add(question); // Add each question to the list
				}
			}
		} catch (Exception e) {
			e.printStackTrace();  // Print the stack trace if an error occurs while reading the questions
		}
	}

	public static void main(String... arguments) {
		// Create an empty list to store the loaded questions
		List<Question> allQuestions = new ArrayList<>();

		// Call loadQuestions method to load questions into the list
		loadQuestions(allQuestions);

		// Check if the list is empty and print a message if no questions were loaded
		if (allQuestions.isEmpty()) {
			System.out.println("No questions loaded.");
		}
	}
}
