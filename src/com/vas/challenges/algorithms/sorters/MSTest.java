package com.vas.challenges.algorithms.sorters;

 /*
  * Merge sort is an efficient stable algorithm.
  * It is a comparison sort.
  *
  * Worst Case: O()
  * Best Case: O()
  */

public class MergeSort {
  public static void main(String[] args) {
    int[] arr = new int[] { 38, 27, 49, 3, 9, 82, 10 };
//    int[] arr = new int[] { 1,3,5,7,2,4,6,8 };
    System.out.println(toString(arr));
    System.out.println("Merge sorting...");
    sort(arr);
    System.out.println(toString(arr));
  }
  
  private static boolean isSorted(int[] arr, int startPos, int endPos) {
    for (int i = startPos; i < endPos - 1; i++) {
      if (arr[i] > arr[i+1]) {
        return false;
      }
    }
    return true;
  }
  
  private static String toString(int[] arr) {
    String str = "[ ";
    for (int i = 0; i < arr.length; i++) {
      str += arr[i] + ", ";
    }
    return str.substring(0, str.length() - 2) + " ]";
  }
}
