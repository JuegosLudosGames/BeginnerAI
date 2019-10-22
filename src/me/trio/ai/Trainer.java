package me.trio.ai;

import java.util.Random;

import me.trio.Vector2D;

public class Trainer {

	public static void calculateAllFitness(Vector2D start, Vector2D end) {
		float ZeroDistance = Vector2D.distance(start, end);

		for (Intelligence in : Intelligence.entities) {

			float inDistance = Vector2D.distance(in.location, end);
			in.fitness = ZeroDistance - inDistance;
		}
	}

	public static void purgeHalfAndRegenerateRandom() {
		for (int x = (Intelligence.entities.length / 2) - 1; x < Intelligence.entities.length; x++) {
			Intelligence.entities[x] = null;
		}
	}

	public static Intelligence generateRandomCreature() {
		Random rnd = new Random();
		MoveSet[] moves = new MoveSet[Intelligence.MAXMOVES];

		for (int x = 0; x < moves.length; x++) {
			moves[x] = MoveSet.getRandom(rnd);
		}
		return new Intelligence(moves);
	}

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

	public static void sortByFitness() {
		// quicksort
		Intelligence.entities = sortPartition(Intelligence.entities, 0, Intelligence.entities.length - 1, new Random());
	}

	private static Intelligence[] sortPartition(Intelligence[] toSort, int startPartition, int endPartition,
			Random rnd) {
//		// select random value for pivot
//		int pivot = rnd.nextInt(endPartition - startPartition + 1) + startPartition;
//
//		// sort all greater to right, and all less to left
//		int leftCheck = startPartition;
//		int rightCheck = endPartition;
//
//		int newLeftPartition = -1;
//		int newRightPartition = -1;
//
//		boolean sorting = true;
//		outside: while (sorting) {
//			
//			
//			
//			if(leftCheck == pivot)
//				leftCheck++;
//			
//			if(rightCheck == pivot)
//				rightCheck--;
//			
//			System.out.println("Left " + leftCheck + " Right " + rightCheck + " Pivot " + pivot);
//			
//			while (leftCheck == pivot || toSort[leftCheck].fitness <= toSort[pivot].fitness) {
//				leftCheck++;
//				System.out.println("Left " + leftCheck + " Right " + rightCheck + " Pivot " + pivot + " Start " + startPartition + " end " + endPartition);
//				if (leftCheck != pivot) {
//					if (leftCheck == rightCheck) {
//						newLeftPartition = leftCheck - 1;
//						newRightPartition = rightCheck;
//						break outside;
//					}
//				} 
//			}
//
//			System.out.println("Left " + leftCheck + " Right " + rightCheck + " Pivot " + pivot);
//			
//			while (rightCheck == pivot || toSort[rightCheck].fitness > toSort[pivot].fitness) {
//				rightCheck--;
//				System.out.println("Left " + leftCheck + " Right " + rightCheck + " Pivot " + pivot + " Start " + startPartition + " end " + endPartition);
//				if (rightCheck != pivot) {
//					if (leftCheck == rightCheck) {
//						newLeftPartition = leftCheck;
//						newRightPartition = rightCheck + 1;
//						break outside;
//					}
//				}
//			}
//
//			Intelligence t = toSort[leftCheck];
//			toSort[leftCheck] = toSort[rightCheck];
//			toSort[rightCheck] = t;
//		}
//
//		// sort left partition
//		if ((newLeftPartition - startPartition + 1) <= 5) {
//			toSort = sortPartitionInsersion(toSort, startPartition, newLeftPartition);
//		} else {
//			toSort = sortPartition(toSort, startPartition, newLeftPartition, rnd);
//		}
//
//		// sort right partition
//		if ((endPartition - newRightPartition + 1) <= 5) {
//			toSort = sortPartitionInsersion(toSort, newRightPartition, endPartition);
//		} else {
//			toSort = sortPartition(toSort, newRightPartition, endPartition, rnd);
//		}
//
//		return toSort;
		
		//get indexes
		int high = endPartition;
		int low = startPartition;
		
		//get the pivot (middle number)
		float pivot = toSort[low + (high - low)/2].fitness;
		
		while(low <= high) {
			
			//goes through, find a left val that is higher than pivot,
			//find a right val that is lower than pivot,
			//swap
			
			while(toSort[low].fitness < pivot)
				low++;
			
			while(toSort[high].fitness > pivot) 
				high--;
			
			if(low <= high) {
				exchange(toSort, high, low);
				low++;
				high--;
			}
		}//end of while
		
		if(startPartition < high) 
			toSort = sortPartition(toSort, startPartition, high, rnd);
		if(low < endPartition)
			toSort = sortPartition(toSort, low, endPartition, rnd);
		
		return toSort;
		
		//return null;
	}
	
	private static void exchange(Intelligence[] toSort, int i, int j) {
		Intelligence temp = toSort[i];
		toSort[i] = toSort[j];
		toSort[j] = temp;
	}

//	private static Intelligence[] sortPartitionInsersion(Intelligence[] toSort, int startPartition, int endPartition) {
//
//		for (int x = startPartition + 1; x <= endPartition; x++) {
//			for (int y = x - 1; x >= startPartition; x--) {
//
//				if (toSort[x].fitness < toSort[y].fitness) {
//					Intelligence t = toSort[x];
//					toSort[x] = toSort[y];
//					toSort[y] = t;
//				} else {
//					break;
//				}
//
//			}
//		}
//		return toSort;
//
//	}

}
