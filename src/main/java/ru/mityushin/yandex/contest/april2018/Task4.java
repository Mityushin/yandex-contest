package ru.mityushin.yandex.contest.april2018;

import java.util.Scanner;

public class Task4 {

    private static int n;
    private static int m;

    private static boolean[][] graph;

    public static void main(String[] args) {

        try (Scanner scan = new Scanner(System.in)) {

            //число вершин
            n = scan.nextInt();

            //число ребер
            m = scan.nextInt();

            if (m == 0) {
                if (n == 2) {
                    System.out.print("1\n1\n2");
                } else {
                    System.out.print("-1");
                }
                return;
            }

            graph = new boolean[n][n];

            int x = scan.nextInt() - 1;
            int y = scan.nextInt() - 1;

            int v = x;

            graph[x][y] = true;
            graph[y][x] = true;

            for (int i = 1; i < m; i++) {
                x = scan.nextInt() - 1;
                y = scan.nextInt() - 1;
                graph[x][y] = true;
                graph[y][x] = true;
            }
//            printGraph();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        graph[i][j] = !graph[i][j];
                    }
                }
            }

            justBFS(v);
        }
    }

    public static void printGraph() {
        for (boolean[] booleans : graph) {
            for (boolean aBoolean : booleans) {
                System.out.print(aBoolean + " ");
            }
            System.out.println();
        }
    }

    public static void justBFS(int v) {
        boolean[] used = new boolean[n];
        boolean[] even = new boolean[n];
        int[] queue = new int[n];
        int queueHead = 0;
        int queueTail = 0;

        boolean flag = false;

        used[v] = true;
        even[v] = flag;
        queue[queueTail++] = v;

        while (queueHead < queueTail) {
            v = queue[queueHead++];
            flag = !even[v];
            for (int i = 0; i < n; i++) {
                if (graph[v][i]) {
                    if (!used[i]) {
                        used[i] = true;
                        even[i] = flag;
                        queue[queueTail++] = i;
                    } else if (even[i] != flag) {
                        System.out.println("конфликт v:" + v + " i:" + i);
                        System.out.print("-1");
                        System.exit(0);
                    }
                }
            }
        }

        int sum = 0;
        for (boolean b : even) {
            if (b) {
                sum++;
            }
        }
        StringBuilder evenBuilder = new StringBuilder();
        StringBuilder noEvenBuilder = new StringBuilder();
        evenBuilder.append(sum).append('\n');
        for (int i = 0; i < n; i++) {
            if (even[i]) {
                evenBuilder.append(i + 1).append(' ');
            } else {
                noEvenBuilder.append(i + 1).append(' ');
            }
        }
        evenBuilder.deleteCharAt(evenBuilder.length() - 1)
                .append('\n')
                .append(noEvenBuilder)
                .deleteCharAt(evenBuilder.length() - 1);
        System.out.print(evenBuilder.toString());
    }

//    public static void run(String[] args) {
//
//        try (Scanner scan = new Scanner(System.in)) {
//
//            //число вершин
//            int n = scan.nextInt();
//
//            //число ребер
//            int m = scan.nextInt();
//
//            int discriminant = -n * n + 2 * n + 4 * m;
//
//            if (discriminant <= 0) {
//                System.out.println("-1");
//                System.exit(0);
//            }
//
//            int[] lineCount = new int[n];
//            int[][] lines = new int[m][2];
//
//            for (int i = 0; i < m; i++) {
//                lines[i][0] = scan.nextInt();
//                lines[i][1] = scan.nextInt();
//
//                lineCount[lines[i][0] - 1]++;
//                lineCount[lines[i][1] - 1]++;
//            }
//
//            double discr_sqrt = Math.sqrt(discriminant);
//            double k1 = (n - discr_sqrt) / 2;
//            double k2 = (n + discr_sqrt) / 2;
//
//            int k = ((int) k2);
//            if (k == n) {
//                k--;
//            }
//
//            for (int i = n - k; i <= n / 2; i++) {
//                for (int j = 0; j < n; j++) {
//                    if (lineCount[j] < i - 1) {
//                        System.out.println("-1");
//                        System.exit(0);
//                    }
//                }
//                //todo:sss
//            }
//        }
//
//    }
}
