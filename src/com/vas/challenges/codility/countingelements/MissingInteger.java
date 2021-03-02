package com.vas.challenges.codility.countingelements;

import java.util.HashSet;
import java.util.Set;

/**
 * Find the smallest positive integer that does not occur in a given sequence.
 */

public class MissingInteger {
    public static void main(String[] args) {
        System.out.println(solution(new int[] { 1, 2, 3 }));
    }

    public static int solution(int[] A) {
        int smallestMissing = 1;
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            numbers.add(A[i]);
        }
        while (numbers.remove(smallestMissing)) {
            smallestMissing++;
        }
        return smallestMissing;
    }
}
