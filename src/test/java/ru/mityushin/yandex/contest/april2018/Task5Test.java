package ru.mityushin.yandex.contest.april2018;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mityushin.yandex.contest.april2018.Task5;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class Task5Test {

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
        String input = "4 2 5";
        String output = "4";

        setupSystemInput(input);
        Task5.main(null);

        assertEquals(output, getOutput());
    }

    @Test
    public void example2() {

        String input = "4 3 5";
        String output = "5";

        setupSystemInput(input);
        Task5.main(null);
        assertEquals(output, getOutput());
    }

    @Test
    public void example3() {

        String input = "1000000000 1000000000 1";
        String output = "1428571429";

        setupSystemInput(input);
        Task5.main(null);
        assertEquals(output, getOutput());
    }

    @Test
    public void example4() {

        String input = "1000000000 1000000000 6";

        setupSystemInput(input);
        Task5.trueMain(null);

        String result = getOutput();

        setupSystemInput(input);
        setupSystemOutput();

        Task5.main(null);

        assertEquals(result, getOutput());
    }
}