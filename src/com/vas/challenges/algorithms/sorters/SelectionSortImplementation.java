package com.vas.challenges.algorithms.sorters;

/*
 * Selection sort is an in-place sort algorithm.
 * It's very simple and it's main advantage is when memory is very limited.
 *
 * Worst Case: O(n)
 * Best Case: O(n)
 */

public class SelectionSortImplementation {
  public static void main(String[] args) {
    int[] arr = new int[] { 3, 8, 5, 4, 1, 9, -2 };
    System.out.println("Selection sorting from my mind...");
    selectionSort(arr);
    printArray(arr);

    int[] arr3 = new int[] { 3, 8, 5, 4, 1, 9, -2 };
    System.out.println("Selection sorting recursively...");
    selectionSortRecursive(arr3, 0);
    printArray(arr3);
  }

  // My implementation
  // 1. iterate on array from the 0 index
  // 2. find the smallest element on the unordered subset (right side)
  // 3. swap it with first unordered element
  // 4. increment index of first unordered element
  public static void selectionSort(int[] arr) {
    for (int firstUnordered = 0; firstUnordered < arr.length; firstUnordered++) {
      int smallestIndex = firstUnordered;
      for (int j = firstUnordered; j < arr.length; j++) {
        if (arr[j] < arr[smallestIndex]) {
          smallestIndex = j;
        }
      }
      int aux = arr[firstUnordered];
      arr[firstUnordered] = arr[smallestIndex];
      arr[smallestIndex] = aux;
    }
  }
  
  
  public static void selectionSortRecursive(int[] arr, int firstUnordered) {
    int smallestIndex = firstUnordered;
    for (int j = firstUnordered; j < arr.length; j++) {
      if (arr[j] < arr[smallestIndex]) {
        smallestIndex = j;
      }
    }
    int aux = arr[firstUnordered];
    arr[firstUnordered] = arr[smallestIndex];
    arr[smallestIndex] = aux;
    
    firstUnordered++;
    if (firstUnordered < arr.length) {
      selectionSortRecursive(arr, firstUnordered);
    }
  }
  
  public static void printArray(int[] arr) {
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.print("\n");
  }
}

