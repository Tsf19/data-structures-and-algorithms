/**
 * 
 */
package NarasimhaKarumanchi.Java._1_Recursion;

/**
 * @author Tousif
 *
 *
 * Problem: Towers of Hanoi puzzle.
 * 
 * Solution: The Towers of Hanoi is a mathematical puzzle.
 * It consists of three rods (or pegs or towers)
 * and a number of disks of different sizes which can slide onto any rod.
 * The puzzle starts with the disks on one rod in ascending order of size, the smallest at the top,
 * thus making a conical shape.
 * The objective of the puzzle is to move the entire stack to another rod, satisfying the following rules:
 * • Only one disk may be moved at a time.
 * • Each move consists of taking the upper disk from one of the rods and sliding it onto another rod,
 *   on top of the other disks that may already be present on that rod.
 * • No disk may be placed on top of a smaller disk.
 *
 * @ALGORITHM
 * • Move the top n–1 disks from Source to Auxiliary tower.
 * • Move the nth disk from Source to Destination tower.
 * • Move the n–1 disks	from Auxiliary tower to	Destination	tower
 * • Transferring the top n–1 disks	from Source to Auxiliary tower can again
 *   be	thought of as a	fresh problem and can be solved	in the same	manner. 
 *   
 *   Once we solve Towers of Hanoi with three disks, we can solve it with any
 *   number	of disks with the above algorithm.
 *
 */
public class _2_TowersOfHanoi {
	
	static int i = 1;
	
	// Move the n disks	from 'source' to 'destination' with the help of 'aux'
	static void towerOfHanoi(int n, String source, String destination, String aux) {
		
		System.out.println("invocation #" + i++);
		
		if (n == 1) {
			System.out.println("Move Disk 1 from " + source + " to " + destination);
			return;
		}
		
		// Move the n-1 disks	from 'source' to 'aux' with the help of 'destination'
		towerOfHanoi(n - 1, source, aux, destination); // now, aux is destination and destination is aux

		System.out.println("Move disk " + n + " from " + source + " to " + destination);

		// Move the n-1 disks	from 'aux' to 'destination' with the help of 'source'
		towerOfHanoi(n - 1, aux, destination, source); // now, source is aux and aux is destination
	}

	//  Driver method 
	public static void main(String args[]) {
		
		int numberOfDisks = 3; // Number of disks
//		towerOfHanoi(numberOfDisks, "A(From)", "C(To)", "B(Aux)"); // A, B and C are names of rods
		towerOfHanoi(numberOfDisks, "source", "destination", "aux"); // A, B and C are names of rods
	}
}

