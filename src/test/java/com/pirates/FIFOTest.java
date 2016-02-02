package com.pirates;

import org.junit.Assert;
import org.junit.Test;


public class FIFOTest {

    private FIFO fifo;

    @org.junit.Before
    public void setUp() throws Exception {
        fifo = new FIFO();
    }

    @Test
    public void testPop() throws Exception {
        fifo.push("aaa");
        fifo.push("bbb");
        fifo.push("ccc");
        Assert.assertEquals("aaa", fifo.pop());
        String[] actual = fifo.arr;
        String[] expected = {"bbb", "ccc", null, null, null, null, null, null, null, null};

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testPeek() throws Exception {
        fifo.push("aaa");
        fifo.push("bbb");
        fifo.push("ccc");
        String[] actual = fifo.arr;
        Assert.assertEquals(actual[0], fifo.peek());
    }

    @Test
    public void testPush() throws Exception {

        fifo.push("aaa");
        fifo.push("bbb");
        String[] actual = fifo.arr;
        String[] expected = {"aaa", "bbb", null, null, null, null, null, null, null, null};
        Assert.assertArrayEquals(expected, actual);
    }
}