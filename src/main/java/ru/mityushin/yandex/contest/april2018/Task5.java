package ru.mityushin.yandex.contest.april2018;

import java.util.Scanner;

public class Task5 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long k = scan.nextLong();
        long m = scan.nextLong();
        long d = scan.nextInt();

        long h = 1;
        long unread = m;
        while (unread >= 0) {
            unread += 5 * k * 2;
            unread -= 7 * h * 2 + 21 + 70;
            h += 7 * 2;
        }
        h -= 7 * 2;
        unread -= 5 * k * 2;
        unread += 7 * h * 2 + 21 + 70;
        while (unread >= 0) {
            unread += k * (1 - d / 6);
            unread -= h;
            h++;
            d++;
            if (d == 8) {
                d = 1;
            }
        }
        System.out.print(h - 2);
    }

    public static void trueMain(String[] args) {
        Scanner scan = new Scanner(System.in);
        long k = scan.nextLong();
        long m = scan.nextLong();
        int d = scan.nextInt();

        long h = 1;
        long unread = m;
        while (unread >= 0) {
            unread += k * (1 - d / 6);
            unread -= h;
            h++;
            d++;
            if (d == 8) {
                d = 1;
            }
        }
        System.out.print(h - 2);
    }
}
