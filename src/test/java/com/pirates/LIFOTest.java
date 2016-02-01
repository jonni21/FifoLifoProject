package com.pirates;

import org.junit.Assert;
import org.junit.Test;


public class LIFOTest {

    private LIFO lifo;

    @org.junit.Before
    public void setUp() throws Exception {
        lifo = new LIFO();
    }

    @Test
    public void testPop() throws Exception {
        lifo.push("aaa");
        lifo.push("bbb");
        lifo.push("ccc");
        Assert.assertEquals("ccc", lifo.pop());
        String[] arr = lifo.arr;
        String[] arr1 = {"aaa", "bbb", null, null, null, null, null, null, null, null};
        Assert.assertArrayEquals(arr1, arr);
    }

    @Test
    public void testPeek() throws Exception {
        lifo.push("aaa");
        lifo.push("bbb");
        lifo.push("ccc");
        Assert.assertEquals("ccc", lifo.peek());
    }

    @Test
    public void testPush() throws Exception {
        lifo.push("aaa");
        lifo.push("bbb");
        String[] arr = lifo.arr;
        String[] arr1 = {"aaa", "bbb", null, null, null, null, null, null, null, null};
        Assert.assertArrayEquals(arr1, arr);
    }
}