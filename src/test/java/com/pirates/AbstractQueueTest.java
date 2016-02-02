package com.pirates;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AbstractQueueTest {
    private FIFO fifo;

    @org.junit.Before
    public void setUp() throws Exception {
        fifo = new FIFO();
    }

    @Test

    public void testPrint() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        fifo.push("aa");
        fifo.push("bb");
        fifo.print();

        String expectedOutput = "aa\r\nbb\r\n";
        Assert.assertEquals(outContent.toString(), expectedOutput);
    }

    @Test
    public void testSize() throws Exception {
        fifo.push("a");
        fifo.push("b");
        Assert.assertEquals(2, fifo.size());
    }

    @Test
    public void testClear() throws Exception {
        fifo.push("aaa");
        fifo.push("bbb");
        fifo.clear();
        String[] actual = fifo.getArr();
        String[] expected = {null, null, null, null, null, null, null, null, null, null};
        Assert.assertArrayEquals(expected, actual);
    }
}