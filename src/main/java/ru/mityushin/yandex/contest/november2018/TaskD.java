package ru.mityushin.yandex.contest.november2018;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TaskD {

    public static void main(String[] args) {

        try (Scanner scan = new Scanner(System.in)) {

            String str = scan.nextLine();
            int k = scan.nextInt();

            long sum = 0;
            long evenCount = 0;
            long fiveCount = 0;

            for (char ch : str.toCharArray()) {

                int number = Character.getNumericValue(ch);
                sum += number;

                if (number % 2 == 0) {
                    evenCount++;
                }
                if (number == 5) {
                    fiveCount++;
                }
            }
            long correct = fiveCount;
            boolean isDivisible = false;

            int lastNumber = Character.getNumericValue(str.charAt(str.length() - 1));

            if (lastNumber == 5) {
                isDivisible = true;
            }

            if (sum % 3 == 0) {
                correct += evenCount;
                if (lastNumber % 2 == 0) {
                    isDivisible = true;
                }
            }

            double p1 = 0.0d;
            double p2 = 0.0d;

            if (isDivisible) {
                p1 = 1.0d;
            }

            double amount = str.length();

            for (int i = 0; i < k; i++) {
                double oldP1 = p1;
                double oldP2 = p2;
                p1 = (p1 + p2) * ((amount - 2) / amount + (correct - 1) * 2 / ((amount) * (amount - 1)));
                p2 = (1 - oldP1 - oldP2) * correct * 2 / ((amount) * (amount - 1));
            }

            DecimalFormat decimalFormat = new DecimalFormat("#0.000000000000000");

            System.out.print(decimalFormat.format(p1 + p2));
        }
    }

}
