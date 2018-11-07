package ru.mityushin.yandex.contest.april2018;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mityushin.yandex.contest.april2018.Task2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class Task2Test {

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
        String input = "7\n" +
                "APPOINT 1 12:30 30 2 andrey alex\n" +
                "APPOINT 1 12:00 30 2 alex sergey\n" +
                "APPOINT 1 12:59 60 2 alex andrey\n" +
                "PRINT 1 alex\n" +
                "PRINT 1 andrey\n" +
                "PRINT 1 sergey\n" +
                "PRINT 2 alex";
        String output = "OK\n" +
                "OK\n" +
                "FAIL\n" +
                "alex andrey\n" +
                "12:00 30 alex sergey\n" +
                "12:30 30 andrey alex\n" +
                "12:30 30 andrey alex\n" +
                "12:00 30 alex sergey";

        setupSystemInput(input);
        Task2.main(null);
        assertEquals(output, getOutput());
    }

}