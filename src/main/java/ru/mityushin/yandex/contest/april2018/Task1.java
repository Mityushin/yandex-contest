package ru.mityushin.yandex.contest.april2018;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Task1 {

    private static final String FORMAT = "#0.000000000000";

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];

        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt() * scan.nextInt();
            sum += arr[i];
        }

        scan.close();

        DecimalFormat format = new DecimalFormat(FORMAT);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(format.format((double) arr[i] / sum));
            builder.append('\n');
        }
        builder.deleteCharAt(builder.length() - 1);
        System.out.print(builder.toString());
    }
}
