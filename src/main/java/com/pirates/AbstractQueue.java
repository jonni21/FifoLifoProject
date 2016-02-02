package com.pirates;

/**
 * Created by Wrong on 29.01.2016.
 */
public abstract class AbstractQueue {

    private String[] arr = new String[10];

    public String[] getArr() {
        return this.arr;
    }

    protected void setArr(String[] arr1) {
        this.arr = arr1;
    }

    public void print() {
        for (String anArr : arr) {
            if (anArr == null) break;
            System.out.println(anArr);
        }
    }

    public int size() {
        int elements = 0;
        for (String anArr : arr) {
            if (anArr != null) {
                elements++;
            }
        }
        return elements;
    }

    public void clear() {
        arr = new String[10];
    }

    public boolean empty() {
        return size() != 0;
    }

    public abstract String pop();

    public abstract void push(String element);

    public abstract String peek();
}