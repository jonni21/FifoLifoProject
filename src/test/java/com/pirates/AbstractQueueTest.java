package com.pirates;

import org.junit.Assert;
import org.junit.Test;

public class AbstractQueueTest {
    private FIFO fifo;

    @org.junit.Before
    public void setUp() throws Exception {
        fifo = new FIFO();
    }

    @Test
    public void testPrint() throws Exception {
        fifo.push("aa");
        fifo.push("bb");
        String[] actual = fifo.getArr();
        String[] expected = {"aa", "bb", null, null, null, null, null, null, null, null};
        Assert.assertArrayEquals(expected, actual);
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