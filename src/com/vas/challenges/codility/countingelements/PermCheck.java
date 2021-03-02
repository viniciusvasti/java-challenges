package com.vas.challenges.codility.countingelements;

import java.util.HashSet;
import java.util.Set;

/**
 * Check whether array A is a permutation.
 */

public class PermCheck {
    public static void main(String[] args) {
        System.out.println(PermCheck.solution(new int[] {1,1}));
        System.out.println(PermCheck.solution(new int[] {4,1,3,2}));
        System.out.println(PermCheck.solution(new int[] {4,1,3}));
    }

    public static int solution(int[] A) {
        int elem = 1;
        Set<Integer> arrayAsSet = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            arrayAsSet.add(A[i]);
        }

        for (int i = 0; i < A.length; i++) {
            if (!arrayAsSet.remove(elem)) {
                return 0;
            }
            elem++;
        }

        return 1;
    }
}
