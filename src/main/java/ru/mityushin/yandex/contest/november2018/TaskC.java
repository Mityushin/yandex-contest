package ru.mityushin.yandex.contest.november2018;

import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {

        try (Scanner scan = new Scanner(System.in)) {

            String s = scan.nextLine();

            int q = scan.nextInt();

            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < q; i++) {
                int l = scan.nextInt();
                int r = scan.nextInt();

                builder.append(compressedLength(s, l, r))
                        .append('\n');
            }
            builder.deleteCharAt(builder.length() - 1);

            System.out.print(builder.toString());
        }
    }

    public static long compressedLength(String compressed, int l, int r) {

        long length = 0;
        long buffer = 0;
        long position = 0;

        long k1 = 0;

        for (char ch : compressed.toCharArray()) {
            if (Character.isDigit(ch)) {
                buffer = buffer * 10 + Character.getNumericValue(ch);
            } else {
                if (buffer == 0) {
                    buffer = 1;
                }
                position += buffer;
                buffer = 0;
                if (position > (l - 1)) {
                    if (position < r) {
                        k1 = position - (l - 1);
                        length += symbolCount(k1);
                    } else {
                        k1 = r - (l - 1);
                        length += symbolCount(k1);
                    }
                }
//                if (position < r) {
//                    length += symbolCount(k1);
//                    k1 = buffer - (position - r);
//                }
            }
        }
        return length;
    }

    public static long symbolCount(long number) {
        if (number <= 1) {
            return 1;
        }
        return (long) (Math.log10(number) + 2);
    }

}
