/*
* This program is about the tower of Hanoi
*
* @author  Seti Ngabo
* @version 1.0
* @since   2022-12-02
*/

import java.util.Scanner;

/**
* This program solves the Tower of Hanoi riddle.
*/
final class TowerOfHanoi {
    /**
    * Prevent instantiation
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */
    private TowerOfHanoi() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * This function completes the tower problem.
    *
    * @param diskNum the number of disks
    * @param peg1 the start peg
    * @param peg2 the end peg
    */
    static void hanoi(final int diskNum, final int peg1,
                             final int peg2) {
        final int pegNum = 6;
        final String toPeg = " to peg ";

        if (diskNum == 1) {
            System.out.println("Move disk 1 from peg " + peg1 + toPeg
                               + peg2);
        } else {
            hanoi(diskNum - 1, peg1, pegNum - peg1 - peg2);
            System.out.println("Move disk " + diskNum + " from peg "
                + peg1 + toPeg + peg2);
            hanoi(diskNum - 1, pegNum - peg1 - peg2, peg2);
        }
    }

    /**
    * This starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {
        final int peg1 = 1;
        final int peg2 = 3;

        System.out.println("Tower of Hanoi");

        // input
        final Scanner userInput = new Scanner(System.in);
        System.out.print("\nHow many disks would you like in your tower (1->): ");

        try {
            final int diskNum = userInput.nextInt();
            System.out.println();
            if (diskNum > 0) {
                // process
                hanoi(diskNum, peg1, peg2);
            } else {
                System.out.println("\nPlease enter a positive integer");
            }
        } catch (java.util.InputMismatchException ex) {
            System.err.println("\nThis is not an integer");
        }
         System.out.println();
        System.out.println("\nDone.");
    }
}
