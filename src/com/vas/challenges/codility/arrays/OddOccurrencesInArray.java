package com.vas.challenges.codility.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired. Return the unpaired;
 */

public class OddOccurrencesInArray {
    public int solution(int[] A) {
        Set<Integer> unpaired = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (!unpaired.remove(A[i])) {
                unpaired.add(A[i]);
            }
        }
        return (int) unpaired.toArray()[0];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 2, 6, 1, 8, 8, 6};
        System.out.println(new OddOccurrencesInArray().solution(arr));
    }
}
