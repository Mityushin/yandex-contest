package ru.mityushin.yandex.contest.november2018;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TaskETest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setupSystemOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    public void setupSystemInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void example1() {
        String input = "7 27 2\n" +
                "9 1 1 27 3 27 3";
        String output = "4 2";

        setupSystemInput(input);
        TaskE.main(null);

        int[] arr = {9, 1, 1, 27, 3, 27, 3};

        long p = 1;

        int[] result = Arrays.stream(getOutput().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        for (int i : result) {
            p *= arr[i - 1];
        }

        assertEquals(p, 27);
    }

    @Test
    public void example2() {

        String input = "7 60 4\n" +
                "30 1 1 3 10 6 4";
        String output = "5 6 3 2";

        setupSystemInput(input);
        TaskE.main(null);

        int[] arr = {30, 1, 1, 3, 10, 6, 4};

        long p = 1;

        int[] result = Arrays.stream(getOutput().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        for (int i : result) {
            p *= arr[i - 1];
        }

        assertEquals(p, 60);
    }

    @Test
    public void example3() {

        
    }
}