package ru.mityushin.yandex.contest.november2018;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class TaskFTest {

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
        String input = "1 0.5\n" +
                "0.5 0.5";
        String output = "0.7853981634";

        setupSystemInput(input);
        TaskF.main(null);
        assertEquals(output, getOutput());
    }

    @Test
    public void example2() {

        String input = "2 2\n" +
                "0.001 0.001\n" +
                "0.999 0.999";
        String output = "2.0000000000";

        setupSystemInput(input);
        TaskF.main(null);
        assertEquals(output, getOutput());
    }
}