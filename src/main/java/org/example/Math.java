package org.example;

public class Math {
    public static double[] Fibonacci(int n) {
        double[] s = new double[]{0, 1};
        double[] result = new double[n];
        System.out.println(result.length);
        for (int i = 0; i < result.length; i++) {
            if (n > 0 ) {
                if (i < s.length) {
                    result[i] = s[i];
                } else {
                    result[i] = result[i - 1] + result[i - 2];
                }
                System.out.println(result[i]);
            }
        }
        return result;
    }

    public static double[] Tribonacci(double[] s, int n) {

        double[] result = new double[n];
        System.out.println(result.length);
        for (int i = 0; i < result.length; i++) {
            if (n > 0 ) {
                if (i < s.length) {
                    result[i] = s[i];
                } else {
                    result[i] = result[i - 1] + result[i - 2] + result[i - 3];
                }
                System.out.println(result[i]);
            }
        }
        return result;
    }
}

