package xjtlu.cpt111.methods.simulation;

/**
 * Parasite simulation implementation.
 * 
 * @since 2024.09.10
 * @since version 0.0.1
 * @version Last modified: 2024.10.10
 */
public class ParasiteSimulation {

	private static final char SYMBOL_GREEN = 'G';
	private static final char SYMBOL_INFECTED = 'I';
	private static final char SYMBOL_DEFOLIATED = 'D';

	private static final char[][] DEFAULT_FOREST_1 = { // forest for task 1
			{ SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN } //
			, { SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_INFECTED, SYMBOL_GREEN, SYMBOL_GREEN } //
			, { SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_DEFOLIATED, SYMBOL_DEFOLIATED, SYMBOL_GREEN } //
			, { SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN } //
			, { SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN } //
	};

	private static final char[][] DEFAULT_FOREST_2 = { // forest for task 2
			{ SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_INFECTED, SYMBOL_GREEN, SYMBOL_DEFOLIATED } //
			, { SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN } //
			, { SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN } //
			, { SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN } //
			, { SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN } //
	};

	public static void main(String... arguments) {
		System.out.println("\nParasite Simulation\n");

		// initial states of the forest
		char[][] forestState = DEFAULT_FOREST_1;
		// forestState = DEFAULT_FOREST_2; // for task 2

		// number of generations to be simulated
		int numOfGenerations = 30;

		// your code start here!
	}

}
