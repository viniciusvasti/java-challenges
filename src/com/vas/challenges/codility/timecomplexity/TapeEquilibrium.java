package com.vas.challenges.codility.timecomplexity;

/**
 * Minimize the value |(A[0] + ... + A[P-1]) - (A[P] + ... + A[N-1])|.
 */

public class TapeEquilibrium {
    public static void main(String[] args) {
        System.out.println(new TapeEquilibrium().solution(new int[]{3, 1, 2, 4, 3}));
        System.out.println(new TapeEquilibrium().solution(new int[]{-1000, 1000}));
    }

    public int solution(int[] A) {
        int sumPart1 = 0;
        int sumPart2 = 0;
        int minDiff;
        for (int P = 1; P < A.length; P++) {
            sumPart2 += A[P];
        }
        sumPart1 = A[0];
        minDiff = Math.abs(sumPart2 - sumPart1);

        for (int P = 1; P < A.length; P++) {
            if (Math.abs(sumPart1 - sumPart2) < minDiff) {
                minDiff = Math.abs(sumPart1 - sumPart2);
            }
            sumPart1 += A[P];
            sumPart2 -= A[P];
        }

        return minDiff;
    }
}
