package com.vas.challenges.algorithms.sorters;

/*
 * Insertion sort is an in-place sort algorithm.
 * It hasn't the better performance, but it's better than simple algorithms like Selection Sort or Bubble Sort.
 * It also supports inserting more elements during the sorting process and it won't be interrupted.
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
  
  public static void printArray(int[] arr) {
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.print("\n");
  }
}
