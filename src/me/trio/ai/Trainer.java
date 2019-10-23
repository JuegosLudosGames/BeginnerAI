package me.trio.ai;

import java.util.Random;

import me.trio.AILogger;
import me.trio.Vector2D;

/**
 * The class the trains the AI
 * @author Kyle
 *
 */
public class Trainer {
	
	public static final int MUTATIONCHANCE = 1;
	
	public static int currentGeneration = 1;
	
	public static float HighestPrevGen = 0;
	public static float LowestPrevGen = 0;
	public static float MedianPrevGen = 0;
	public static float averagePrevGen = 0;
	

	/**
	 * Calculates the fitness score for each AI
	 * @param start the vector of the start point
	 * @param end the vector of the end point
	 */
	public static void calculateAllFitness(Vector2D start, Vector2D end) {
		//the value that is considered 0 fitness
		float ZeroDistance = Vector2D.distance(start, end);
		averagePrevGen = 0;

		//goes through every AI
		for (Intelligence in : Intelligence.entities) {
			
			//calculates distance
			float inDistance = Vector2D.distance(in.location, end);
			
			//checks if dead
			if(in.isDead)
				//set fitness to 0
				in.fitness = 0;
			else
				//sets fitness
				in.fitness = ZeroDistance - inDistance;
			
			averagePrevGen += in.fitness;
			
			//unkill
			in.isDead = false;
		}
		
		//calculates full average
		averagePrevGen = averagePrevGen / Intelligence.entities.length;
	}
	
	/**
	 * Purges half of the AI population from index length / 2 to end and regenerates 
	 * the population
	 */
	public static void purgeHalfAndRegenerateRandom() {
		
		//sets prev generation info
		HighestPrevGen = Intelligence.entities[0].fitness;
		LowestPrevGen = Intelligence.entities[Intelligence.entities.length - 1].fitness;
		MedianPrevGen = Intelligence.entities[Intelligence.entities.length / 2].fitness;
		
		//logs
		AILogger.getLogger().write(currentGeneration, LowestPrevGen, MedianPrevGen, HighestPrevGen, averagePrevGen);
		
		int y = 0;
		for (int x = (Intelligence.entities.length / 2) - 1; x < Intelligence.entities.length; x++) {
			Intelligence.entities[x] = generateRandomCreature(Intelligence.entities[y], MUTATIONCHANCE);
			y++;
		}
		currentGeneration++;
	}
	
	/**
	 * Generates a random AI
	 * @return the generated aI
	 */
	public static Intelligence generateRandomCreature() {
		Random rnd = new Random();
		MoveSet[] moves = new MoveSet[Intelligence.MAXMOVES];

		for (int x = 0; x < moves.length; x++) {
			moves[x] = MoveSet.getRandom(rnd);
		}
		return new Intelligence(moves);
	}

	/**
	 * Generates a random creature via mutation of another creature
	 * @param i the creature to be mutated
	 * @param mutationChance percentage chance of a mutation for all moves
	 * @return the newly generated creature
	 */
	public static Intelligence generateRandomCreature(Intelligence i, int mutationChance) {
		Random rnd = new Random();
		MoveSet[] moves = i.getMoveset().clone();

		for (int x = 0; x < moves.length; x++) {

			if (rnd.nextInt(100) < mutationChance) {
				moves[x] = MoveSet.getRandom(rnd);
			}
		}

		return new Intelligence(moves);
	}
	
	/**
	 * Sorts the Ai by their fitness, highest to lowest
	 */
	public static void sortByFitness() {
		// quicksort
		Intelligence.entities = sortPartition(Intelligence.entities, 0, Intelligence.entities.length - 1);
	}

	/*Sorts partition from a start point to end point
	 * toSort the array to sort
	 * startPartition the low end (left) 
	 * endPartition the high end (right) 
	 */
	private static Intelligence[] sortPartition(Intelligence[] toSort, int startPartition, int endPartition) {
		
		//get indexes
		int high = endPartition;
		int low = startPartition;
		
		//get the pivot (middle number)
		float pivot = toSort[low + (high - low)/2].fitness;
		
		while(low <= high) {
			
			//goes through, find a left val that is higher than pivot,
			//find a right val that is lower than pivot,
			//swap
			
			while(toSort[low].fitness > pivot)
				low++;
			
			while(toSort[high].fitness < pivot) 
				high--;
			
			if(low <= high) {
				exchange(toSort, high, low);
				low++;
				high--;
			}
		}//end of while
		
		if(startPartition < high) 
			toSort = sortPartition(toSort, startPartition, high);
		if(low < endPartition)
			toSort = sortPartition(toSort, low, endPartition);
		
		return toSort;
		
		//return null;
	}
	
	/*
	 * swaps 2 elements in the array
	 * toSort the array to swap elements
	 * i 1 index
	 * j another index
	 */
	private static void exchange(Intelligence[] toSort, int i, int j) {
		Intelligence temp = toSort[i];
		toSort[i] = toSort[j];
		toSort[j] = temp;
	}

}
