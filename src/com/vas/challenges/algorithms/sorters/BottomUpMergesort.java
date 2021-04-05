package com.vas.challenges.algorithms.sorters;

 /*
  * Merge sort is an efficient stable algorithm.
  * It is a comparison sort.
  *
  * Worst Case: O()
  * Best Case: O()
  */

public class BottomUpMergesort {
  public static void main(String[] args) {
    int[] arr = new int[100_000_000];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) (Math.random() * i);
    }
    // System.out.println(toString(arr));
    System.out.println("Merge sorting...");
    long start = System.currentTimeMillis();
    sort(arr);
    long end = System.currentTimeMillis();
    System.out.printf("Time spent: %d%n", (end - start));
    // System.out.println(toString(arr));
  }
  
  private static void sort(int[] arr) {
    int[] aux = new int[arr.length];
    
    for (int subArraysSize = 1; subArraysSize < arr.length; subArraysSize = subArraysSize*2) {
      for (int i = 0; i < arr.length - subArraysSize; i += subArraysSize*2) {
        int left = i;
        int right = left + subArraysSize*2 - 1;
        int mid = left + ((right-left)/2);
        // An overflow may occur after doubling subArraysSize, so the last index should be length - 1
        merge(arr, aux, left, mid, right <= arr.length-1 ? right : arr.length-1);
      }
    }

    assert isSorted(arr, 0, arr.length - 1);
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
