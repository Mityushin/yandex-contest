package ru.mityushin.yandex.contest.april2018;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mityushin.yandex.contest.april2018.Task1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class Task1Test {

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
        String input = "2\n" +
                "50 1\n" +
                "50 2";
        String output = "0.333333333333\n" +
                "0.666666666667";

        setupSystemInput(input);
        Task1.main(null);
        assertEquals(output, getOutput());
    }

    @Test
    public void example2() {

        String input = "3\n" +
                "10 100\n" +
                "30 10\n" +
                "60 2";
        String output = "0.704225352113\n" +
                "0.211267605634\n" +
                "0.084507042254";

        setupSystemInput(input);
        Task1.main(null);
        assertEquals(output, getOutput());
    }
}