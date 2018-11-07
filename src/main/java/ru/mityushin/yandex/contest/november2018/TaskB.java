package ru.mityushin.yandex.contest.november2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {

        try (Scanner scan = new Scanner(System.in)) {

            int n = scan.nextInt();
            scan.nextLine();

            List<String> numbers = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                numbers.add(scan.nextLine().replaceAll("[+\\s-()]*", ""));
            }

            int m = scan.nextInt();
            scan.nextLine();

            List<PhoneNumberPattern> patterns = new ArrayList<>(m);

            for (int i = 0; i < m; i++) {
                patterns.add(new PhoneNumberPattern(scan.nextLine()));
            }

            StringBuilder builder = new StringBuilder();

            for (String number : numbers) {
                for (PhoneNumberPattern pattern : patterns) {
                    if (number.startsWith(pattern.codeNumber) && number.length() == pattern.fullNumberLength) {
                        builder.append(pattern.normalize(number)).append('\n');
                        break;
                    }
                }
            }

            builder.deleteCharAt(builder.length() - 1);

            System.out.print(builder.toString());
        }
    }

    private static class PhoneNumberPattern {

        int fullNumberLength;
        int personalNumberLength;

        String codeNumber;
        String formattedCodeNumber;
        String formattedCountryOperator;

        public PhoneNumberPattern(String pattern) {

            String[] str = pattern.split(" - ");

            this.formattedCodeNumber = str[0].replaceAll("[X]", "");
            this.formattedCountryOperator = str[1];
            this.codeNumber = this.formattedCodeNumber.replaceAll("[+\\s-()]", "");

            this.personalNumberLength = (int) str[0].chars().filter(ch -> ch == 'X').count();
            this.fullNumberLength = str[0].replaceAll("[+\\s-()]", "").length();
        }

        public String normalize(String number) {
            return formattedCodeNumber
                    + number.substring(number.length() - personalNumberLength)
                    + " - "
                    + formattedCountryOperator;
        }
    }

}
