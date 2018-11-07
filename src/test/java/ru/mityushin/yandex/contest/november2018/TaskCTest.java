package ru.mityushin.yandex.contest.november2018;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class TaskCTest {

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
        String input = "a2bc3a\n" +
                "5\n" +
                "1 7\n" +
                "5 7\n" +
                "1 2\n" +
                "3 5\n" +
                "4 4";
        String output = "6\n" +
                "2\n" +
                "2\n" +
                "3\n" +
                "1";

        setupSystemInput(input);
        TaskC.main(null);
        assertEquals(output, getOutput());
    }

    @Test
    public void example2() {

        String input = "x1000000000yz\n" +
                "3\n" +
                "2 1000000001\n" +
                "1 1000000002\n" +
                "5938493 15938493";
        String output = "11\n" +
                "12\n" +
                "9";

        setupSystemInput(input);
        TaskC.main(null);
        assertEquals(output, getOutput());
    }

    @Test
    public void compress() {
        assertEquals(
                5,
                TaskC.symbolCount(1000)
        );
        assertEquals(
                1,
                TaskC.symbolCount(1)
        );
        assertEquals(1,
                TaskC.symbolCount(0));
    }
}