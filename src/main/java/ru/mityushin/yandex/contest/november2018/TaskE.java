package ru.mityushin.yandex.contest.november2018;

import java.util.Scanner;

public class TaskE {

    public static void main(String[] args) {

        try (Scanner scan = new Scanner(System.in)) {

            int n = scan.nextInt();
            int m = scan.nextInt();
            int k = scan.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }

            int[] success = combinations(k, arr, m);

            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) {
                    if (success[i] == arr[j]) {
                        builder.append(j + 1).append(' ');
                        arr[j] = 0;
                        break;
                    }
                }
            }
            builder.deleteCharAt(builder.length() - 1);

            System.out.print(builder.toString());
        }
    }

    public static void func(int[] arr, int currentM, int currentK) {

    }

    public static int[] combinations(int k, int[] arr, int m) {
        // Calculate the number of arrays we should create
        int numArrays = (int) Math.pow(arr.length, k);
        // Create each array
        for (int i = 0; i < numArrays; i++) {
            int[] current = new int[k];
            // Calculate the correct item for each position in the array
            for (int j = 0; j < k; j++) {
                // This is the period with which this position changes, i.e.
                // a period of 5 means the value changes every 5th array
                int period = (int) Math.pow(arr.length, k - j - 1);
                // Get the correct item and set it
                int index = i / period % arr.length;
                current[j] = arr[index];
            }
            long p = 1;
            for (int i1 : current) {
                p *= i1;
            }
            if (p == m) {
                return current;
            }
        }
        return null;
    }

}
