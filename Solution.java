import java.util.*;

public class Solution {
	/**
	 * Author: Tristan J Frey
	 * Date: January 5, 2025
	 * 
	 * This class handles an Merge Sort algorithm in both reverse and forward order. 
	 */
	
	
	/**
	 * Sorts an array using the Merge Sort algorithm in both forward and reverse order.
	 * 
	 * The method creates two copies of the input array: 
	 * one sorting in forward order and one sorting in reverse order.
	 * It then calls the sort method to sort both arrays, 
	 * then returns a 2D array containing the sorted arrays.
	 *
	 * @param list An array of integers to be sorted.
	 * @return arr A 2D array containing two sorted arrays: one in forward order and one in reverse order.
	 */
	public int[][] mergeSort(int[] list) { 
		// Create new arrays for forward and reverse
		int[] forwardArray = new int[list.length];
	    int[] reverseArray = new int[list.length];
	    
	    // Populate forward and reverse arrays
	    for (int i = 0; i < list.length; i++) {
	        forwardArray[i] = list[i];
	        reverseArray[i] = list[i];
	    }
	    
	    // Method to sort array via Merge Sort
		sort(forwardArray, true); // Sorts forward
		sort(reverseArray, false); // Sorts reverse
		
		
		int[][] arr = {forwardArray, reverseArray};
		return arr;
	}
	
	
	/**
	 * Sorts an array using the Merge Sort algorithm.
	 * 
	 * Recursive method that divides the array into smaller sub-arrays,
	 * sorts those sub-arrays, and then merges them back together in sorted order.
	 *
	 * @param array The array to be sorted.
	 * @param forward Boolean indicating whether to sort in forward (true) or reverse (false) order.
	 */
	public static void sort(int[] array, boolean forward) {
	    int length = array.length;
		if (length <= 1) {
		    return; // This is our base case
		}
		
		// Initialize our arrays for left and right
		int middle = length / 2;
		int leftArray[] = new int[middle];
		int rightArray[] =  new int[length - middle];
		
		
		/**
		 * Indices
		 * i handles leftArray array indices && original array indices
		 * j handles rideArray indices
		 */
		int i = 0, j = 0;
		
		
		// Populate our left and right arrays
		while (i < length) {
		    if (i < middle) {
		        leftArray[i] = array[i];
		    } else {
		        rightArray[j] = array[i];
		        j++;
		    }
		    i++;
		} // End of population loop
		
		
		// Recursive calls to sort left and right arrays
		sort(leftArray, forward);
		sort(rightArray, forward);
		
		
		// Merge sorted arrays into original array
		sorting(leftArray, rightArray, array, forward);
	}
	
	
	/**
	 * Merges two sorted arrays (leftArray and rightArray) into the original array.
	 * 
	 * This method compares elements from both arrays and merges them in either forward (true)
	 * or reverse order (false).
	 *
	 * @param leftArray The left sub-array.
	 * @param rightArray The right sub-array.
	 * @param array The original array to be sorted.
	 * @param forward Boolean indicating whether to merge in forward (true) or reverse (false) order.
	 */
	private static void sorting(int[] leftArray, int[] rightArray, int[] array, boolean forward) {
	    int length = array.length;
	    int leftSide = length / 2;
	    int rightSide = length - leftSide;
	    
	    
	    /**
		 * Indices:
		 * i handles the original array indices
		 * l handles leftArray indices
		 * r handles rightArray indices
		 */
	    int i = 0, l = 0, r = 0;
	    
	    
	    // Compare elements from left and right arrays and merge them into the original array
	    if (forward == true) {
	    	// Forward merge
    	    while (l < leftSide && r < rightSide) {
    	        if (leftArray[l] < rightArray[r]) {
    	            array[i] = leftArray[l];
    	            l++;
    	            i++;
    	        } else {
    	            array[i] = rightArray[r];
    	            r++;
    	            i++;
    	        }
    	    }
	    } else {
	    	// Reverse merge
	        while (l < leftSide && r < rightSide) {
    	        if (leftArray[l] > rightArray[r]) {
    	            array[i] = leftArray[l];
    	            l++;
    	            i++;
    	        } else {
    	            array[i] = rightArray[r];
    	            r++;
    	            i++;
    	        }
    	    }
	    }
	    
	    
	    // Fill out left array when no more right side comparisons
	    while (l < leftSide) {
	        array[i] = leftArray[l];
	        l++;
            i++;
	    }
	    
	    
	    // Fill out right array when no more left side comparisons
	    while (r < rightSide) {
	        array[i] = rightArray[r];
	        r++;
	        i++;
	    } // End of while loop
	} // End of sorting method
} // End of class
