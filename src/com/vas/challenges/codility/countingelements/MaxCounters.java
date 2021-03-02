package com.vas.challenges.codility.countingelements;

/**
 * MaxCounters
 * START
 * Calculate the values of counters after applying all alternating operations: increase counter by 1; set value of all counters to current maximum.
 */

public class MaxCounters {
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int maxCount = 0;
        int lastMaxCountOp = 0;

        for (int k : A) {
            boolean opIsIncrease = k >= 1 && k <= N;
            int counterIndex = k - 1;
            if (opIsIncrease) {
                if (counters[counterIndex] < lastMaxCountOp) {
                    counters[counterIndex] = lastMaxCountOp + 1;
                } else {
                    counters[counterIndex] += 1;
                }
                if (counters[counterIndex] > maxCount) {
                    maxCount = counters[counterIndex];
                }
            } else {
                lastMaxCountOp = maxCount;
            }
        }

        for (int i = 0; i < counters.length; i++) {
            if (counters[i] < lastMaxCountOp) {
                counters[i] = lastMaxCountOp;
            }
        }

        return counters;
    }
}
