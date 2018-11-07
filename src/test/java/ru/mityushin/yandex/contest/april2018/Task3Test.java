package ru.mityushin.yandex.contest.april2018;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mityushin.yandex.contest.april2018.Task3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class Task3Test {

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
        String input = "3\n" +
                "hello world hello";
        String output = "11";

        setupSystemInput(input);
        Task3.main(null);
        assertEquals(output, getOutput());
    }

    @Test
    public void example2() {
        String input = "5\n" +
                "an apple a big apple";
        String output = "13";

        setupSystemInput(input);
        Task3.main(null);
        assertEquals(output, getOutput());
    }

    @Test
    public void example3() {
        String input = "5\n" +
                "aaaaa aaaab aaaaa abaaa abaaa";
        String output = "22";

        setupSystemInput(input);
        Task3.main(null);
        assertEquals(output, getOutput());
    }

}