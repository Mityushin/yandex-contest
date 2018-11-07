package ru.mityushin.yandex.contest.april2018;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mityushin.yandex.contest.april2018.Task4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class Task4Test {

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
        String input = "3 1\n" +
                "1 2";
        String output1 = "2\n" +
                "1 2\n" +
                "3";
        String output2 = "1\n" +
                "3\n" +
                "1 2";

        setupSystemInput(input);
        Task4.main(null);
//        assertEquals(output1, getOutput());
        assertEquals(output2, getOutput());
    }

    @Test
    public void example2() {
        String input = "3 0";
        String output = "-1";

        setupSystemInput(input);
        Task4.main(null);
        assertEquals(output, getOutput());
    }

}