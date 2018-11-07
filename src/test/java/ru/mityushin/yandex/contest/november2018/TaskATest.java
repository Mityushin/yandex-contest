package ru.mityushin.yandex.contest.november2018;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class TaskATest {

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
                "aaaaaaaaaaaaa\n" +
                "aaabbbaaabbba";
        String output = "6\n" +
                "7\n" +
                "aaa aaa 10\n" +
                "aaa aab 2\n" +
                "aab abb 2\n" +
                "abb bbb 2\n" +
                "bbb bba 2\n" +
                "bba baa 1\n" +
                "baa aaa 1";

        setupSystemInput(input);
        TaskA.main(null);

        Set<String> fromOutput = new HashSet<>(Arrays.asList(getOutput().split("\n")));
        Set<String> testOutput = new HashSet<>(Arrays.asList(output.split("\n")));

        assertEquals(fromOutput, testOutput);
    }

    @Test
    public void example2() {

        String input = "2\n" +
                "abab\n" +
                "baba";
        String output = "2\n" +
                "2\n" +
                "aba bab 1\n" +
                "bab aba 1";

        setupSystemInput(input);
        TaskA.main(null);

        Set<String> fromOutput = new HashSet<>(Arrays.asList(getOutput().split("\n")));
        Set<String> testOutput = new HashSet<>(Arrays.asList(output.split("\n")));

        assertEquals(fromOutput, testOutput);
    }

    @Test
    public void example3() {

        String input = "1\n" +
                "qwertyqwertyqwertyqwertyqwerty";
        String output = "6\n" +
                "6\n" +
                "qwe wer 5\n" +
                "wer ert 5\n" +
                "ert rty 5\n" +
                "rty tyq 4\n" +
                "tyq yqw 4\n" +
                "yqw qwe 4";

        setupSystemInput(input);
        TaskA.main(null);

        Set<String> fromOutput = new HashSet<>(Arrays.asList(getOutput().split("\n")));
        Set<String> testOutput = new HashSet<>(Arrays.asList(output.split("\n")));

        assertEquals(fromOutput, testOutput);
    }
}