package com.vas.challenges.algorithms.sorters;

/*
 * It's called "insertion" because the next element of the non ordered subset of the array is taken
 * and inserted on its right position by comparing with ordered elements from the last to the first
 * Insertion sort is an in-place sort algorithm.
 * It hasn't the better performance, but it's better than simple algorithms like Selection Sort or Bubble Sort.
 * It also supports inserting more elements during the sorting process and it won't be interrupted.
 *
 * Worst Case (when array is reversed sorted): O(n²)
 * Best Case (when array is already sorted): O(n)
 * (my mind version has a little worst performance)
 *
 * Auxiliary space: O(1) for iterative version and O(n) for the recursive
 */

public class InsertionSortImplementation {
  public static void main(String[] args) {
    int[] arr = new int[] { 3, 8, 5, 4, 1, 9, -2 };
    System.out.println("Insertion sorting from my mind...");
    insertionSort(arr);
    printArray(arr);

    int[] arr2 = new int[] { 3, 8, 5, 4, 1, 9, -2 };
    System.out.println("Insertion sorting from google...");
    insertionSort2(arr2);
    printArray(arr2);

    int[] arr3 = new int[] { 3, 8, 5, 4, 1, 9, -2 };
    System.out.println("Insertion sorting recursively...");
    insertionSortRecursive(arr3, 1, arr3.length-1);
    printArray(arr3);
  }

  // My implementation
  // 1 iterates over the array using i
  // 2 iterates over the ordered subset using j (from j = 0 until j = i-1)
  // 3 if value on i is less than value on j, exchange them
  // 5 increment j by 1
  // 6 repeat 3 and 4 until j = i-1
  public static void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int value = arr[i];
      int j = 0;
      while (j <= i-1) {
        if (value < arr[j]) {
          arr[i] = arr[j];
          arr[j] = value;
          value = arr[i];
        }
        j++;
      }
    }
  }
  
  // Better performance (I've looked at google)
  public static void insertionSort2(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int value = arr[i];
      int j = i;
      while (j > 0 && arr[j-1] > value) {
        arr[j] = arr[j-1];
        j--;
      }
      arr[j] = value;
    }
  }

  public static void insertionSortRecursive(int[] arr, int unOrderedFirst, int unOrderedlast) {
    int value = arr[unOrderedFirst];
    int j = unOrderedFirst;
    while (j > 0 && arr[j-1] > value) {
      arr[j] = arr[j-1];
      j--;
    }
    arr[j] = value;
    
    if (unOrderedFirst + 1 <= unOrderedlast) {
      insertionSortRecursive(arr, unOrderedFirst + 1, unOrderedlast);
    }
  }
  
  public static void printArray(int[] arr) {
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.print("\n");
  }
}
