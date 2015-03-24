/**
 * HashDistChecker.java
 *
 * COMP 2230 Assignment 8 Problem 7
 * Steven Lyall (T00023594)
 *
 * For a range of values, counts the frequency distribution of keys using a hash function and given range of values and table size.
 *
 **/

public class HashDistChecker {
    private int tableSize;
    private int[] distTable;
    private int min;
    private int max;

    /**
     * Constructs a new HashDistChecker object for a given table size and range of values and checks the distribution.
     *  Complexity: O(n)
     *  Precondition: None
     *  Postcondition: The object has been instantiated.
     * @param size The desired table size.
     * @param min Minimum value of range to be checked.
     * @param max Maxiumum value of range to be checked.
     */
    public HashDistChecker(int size, int min, int max) {
        tableSize = size;
        this.min = min;
        this.max = max;
        distTable = new int[size];
        checkHashDistribution();
    }

    /**
     * Counts the hash index distribution for the given range of numbers.
     *  Complexity: O(n)
     *  Precondition: The HashDistChecker object exists.
     *  Postcondition: The distTable array contains the frequency of mappings to each index.
     */
    private void checkHashDistribution() {
        for (int i = min; i!=max; i++) {
            distTable[hash(i)]++;
        }
    }

    /**
     * Hash function used to map values.
     *  Complexity: O(1)
     *  Precondition: The HashDistChecker object exists.
     *  Postcondition: The object is unchanged.
     * @param i integer key
     * @return index mapped by hash function
     */
    private int hash(int i) {
        return i % tableSize;
    }

    /**
     * Builds a string representation of the object showing the index and frequency of mappings.
     *  Complexity: O(n)
     *  Precondition: The HashDistChecker object exists.
     *  Postcondition: The object is unchanged.
     * @return
     */
    public String toString() {
        String str = "============================\n" +
                     "Distribution of values in range " + min + "-" + max +
                     "\nTable Size: " + tableSize;

        for (int i = 0; i < distTable.length; i++) {
            str += "\n[" + i + "] - " + distTable[i];
        }

        return str + "\n============================\n";
    }
}
