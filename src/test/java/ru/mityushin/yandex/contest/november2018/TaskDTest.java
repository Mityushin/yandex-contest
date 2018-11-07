package ru.mityushin.yandex.contest.november2018;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class TaskDTest {

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
        String input = "21\n" +
                "1";
        String output = "1.000000000000000";

        setupSystemInput(input);
        TaskD.main(null);
        assertEquals(output, getOutput());
    }

    @Test
    public void example2() {

        String input = "145\n" +
                "2";
        String output = "0.333333333333333";

        setupSystemInput(input);
        TaskD.main(null);
        assertEquals(output, getOutput());
    }

    @Test
    public void example3() {

        String input = "5316\n" +
                "2";
        String output = "0.555555555555556";

        setupSystemInput(input);
        TaskD.main(null);
        assertEquals(output, getOutput());
    }

    @Test
    public void example4() {

        String input = "531\n" +
                "2";
        String output = "0.333333333333333";

        setupSystemInput(input);
        TaskD.main(null);
        assertEquals(output, getOutput());
    }
}