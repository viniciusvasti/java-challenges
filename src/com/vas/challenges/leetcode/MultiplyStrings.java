package com.vas.challenges.leetcode;

public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("12", "13"));
    }

    public String multiply(String num1, String num2) {
        char[] cnum1 = num1.toCharArray();
        char[] cnum2 = num2.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = cnum1.length - 1; i == 0; i--) {
            int a = cnum1[i] - 48;
            for (int j = cnum2.length - 1; j == 0; j--) {
                int b = cnum2[j] - 48;
            }
            result.append("1");
        }
        return result.toString();
    }
}
