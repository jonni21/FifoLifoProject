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
        String[] arr = fifo.arr;
        String[] arr1 = {"bbb", "ccc", null, null, null, null, null, null, null, null};

        Assert.assertArrayEquals(arr1, arr);
    }

    @Test
    public void testPeek() throws Exception {
        fifo.push("aaa");
        fifo.push("bbb");
        fifo.push("ccc");
        String[] arr = fifo.arr;
        Assert.assertEquals(arr[0], fifo.peek());
    }

    @Test
    public void testPush() throws Exception {

        fifo.push("aaa");
        fifo.push("bbb");
        String[] arr = fifo.arr;
        String[] arr1 = {"aaa", "bbb", null, null, null, null, null, null, null, null};
        Assert.assertArrayEquals(arr1, arr);
    }
}