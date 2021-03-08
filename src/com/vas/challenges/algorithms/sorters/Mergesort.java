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
    System.out.println(toString(arr));
    System.out.println("Merge sorting...");
    sort(arr);
    System.out.println(toString(arr));
  }
  
  private static void sort(int[] arr) {
    int[] aux = new int[arr.length];
    sort(arr, aux, 0, arr.length - 1);
  }
  
  private static void sort(int[] arr, int[] aux, int left, int right) {
    if (left >= right) return;
    
    int mid = left + (right - left) / 2;
    sort(arr, aux, left, mid);
    sort(arr, aux, mid + 1, right);
    merge(arr, aux, left, mid, right);
  }

  private static void merge(int[] arr, int[] aux, int left, int mid, int right) {
    assert isSorted(arr, left, mid);
    assert isSorted(arr, mid+1, right);

    for (int i = left; i <= right; i++) {
      aux[i] = arr[i];
    }

    int i = left;
    int j = mid + 1;
    
    for (int k = left; k <= right; k++) {
      if (i > mid) {
        arr[k] = aux[j++];
      } else if (j > right) {
        arr[k] = aux[i++];
      } else if (aux[j] < aux[i]) {
        arr[k] = aux[j++];
      } else {
        arr[k] = aux[i++];
      }
    }
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
