package ru.mityushin.yandex.contest.november2018;

import java.util.Scanner;

public class TaskF {

    public static void main(String[] args) {

        try (Scanner scan = new Scanner(System.in)) {

            int n = scan.nextInt();
            double r = scan.nextDouble();

            double[] x = new double[n];
            double[] y = new double[n];

            for (int i = 0; i < n; i++) {
                x[i] = scan.nextDouble();
                y[i] = scan.nextDouble();
            }

            double h = 0.001;

            long count = 0;

            double rr = r * r;

            for (double i = 0.001; i < 1; i += h) {
                for (double j = 0.001; j < 1; j += h) {
                    for (int k = 0; k < n; k++) {
                        if (Double.compare(rr, Math.pow(x[k] - i, 2) + Math.pow(y[k] - j, 2)) >= 0) {
                            count++;
                        }
                    }
                }
            }
            System.out.print(count / Math.pow((1 - 0.001) / h, 2));
        }

    }

}
