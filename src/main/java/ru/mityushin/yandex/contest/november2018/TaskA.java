package ru.mityushin.yandex.contest.november2018;

import java.util.*;

public class TaskA {

    public static void main(String[] args) {

        try (Scanner scan = new Scanner(System.in)) {

            int t = scan.nextInt();
            scan.nextLine();

            Map<String, Integer> map = new HashMap<>();
            Set<String> set = new HashSet<>();

            for (int i = 0; i < t; i++) {

                String str = scan.nextLine();

                int step = 3;

                for (int k = 0; k < (str.length() - step); k++) {

                    String key = str.substring(k, k + step + 1);
                    String keyForSet = str.substring(k, k + step);
                    set.add(keyForSet);

                    if (map.containsKey(key)) {
                        Integer value = map.get(key);
                        map.put(key, ++value);
                    } else {
                        map.put(key, 1);
                    }

                }

            }

            StringBuilder builder = new StringBuilder();

            builder.append(set.size()).append("\n");
            builder.append(map.size()).append('\n');

            for (Map.Entry<String, Integer> entry: map.entrySet()) {

                String str1 = entry.getKey().substring(0, 3);
                String str2 = entry.getKey().substring(1, 4);

                builder.append(str1).append(' ').append(str2).append(' ').append(entry.getValue()).append('\n');
            }



            builder.deleteCharAt(builder.length() - 1);

            System.out.print(builder.toString());

        }
    }

}
