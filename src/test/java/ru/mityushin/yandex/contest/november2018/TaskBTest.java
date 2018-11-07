package ru.mityushin.yandex.contest.november2018;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class TaskBTest {

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
        String input = "4\n" +
                "28-49-5-123-45-67\n" +
                "87544456789\n" +
                "+28 (495) 123 45 56\n" +
                "875-(29)-123456\n" +
                "3\n" +
                "+875 (29) 1XXXXX - Atlantis MythCell\n" +
                "+875 (44) 4XXXXX - Atlantis MobTelecom\n" +
                "+28 (495) XXXXXXX - ElDorado GoldLine";
        String output = "+28 (495) 1234567 - ElDorado GoldLine\n" +
                "+875 (44) 456789 - Atlantis MobTelecom\n" +
                "+28 (495) 1234556 - ElDorado GoldLine\n" +
                "+875 (29) 123456 - Atlantis MythCell";

        setupSystemInput(input);
        TaskB.main(null);
        assertEquals(output, getOutput());
    }

    @Test
    public void example2() {

        String input = "2\n" +
                "12345678\n" +
                "123456789\n" +
                "2\n" +
                "+1 (234) XXXXX - USA SomeCell\n" +
                "+1 (23) XXXXX - Canada AnotherCell";
        String output = "+1 (23) 45678 - Canada AnotherCell\n" +
                "+1 (234) 56789 - USA SomeCell";

        setupSystemInput(input);
        TaskB.main(null);
        assertEquals(output, getOutput());
    }
}