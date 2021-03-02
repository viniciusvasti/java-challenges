package com.vas.challenges.codility.countingelements;

import java.util.HashSet;
import java.util.Set;

/**
 * Find the earliest time when a frog can jump to the other side of a river.
 */

public class FrogRiverOne {
    public int solution(int X, int[] A) {
        Set<Integer> riverPositions = new HashSet<>();
        for (int i = 1; i <= X; i++) {
            riverPositions.add(i);
        }

        for (int i = 0; i < A.length; i++) {
            riverPositions.remove(A[i]);
            if (riverPositions.isEmpty()) {
                return i;
            }
        }
        return -1;
    }
}
