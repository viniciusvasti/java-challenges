package com.vas.challenges.codility.timecomplexity;

import java.util.HashSet;
import java.util.Set;

/**
 * An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
 *
 * Your goal is to find that missing element.
 */

public class PermMissingElem {

    public int solution(int[] A) {
        Set<Integer> elements = new HashSet<>();
        for (int i = 1; i <= A.length + 1; i++) {
            elements.add(i);
        }
        for (int i = 0; i < A.length; i++) {
            elements.remove(A[i]);
        }
        return (int) elements.toArray()[0];
    }
}
