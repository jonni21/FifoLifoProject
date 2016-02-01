package com.pirates;


/**
 * Created by Wrong on 26.01.2016.
 */
public class FIFO extends AbstractQueue {

    //Удаляет последний добавленый элемент
    @Override
    public String pop() {
        String firstElement = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                arr[i] = arr[i + 1];
            } else arr[i] = null;
        }
        if (firstElement != null) {
            return firstElement;
        } else {
            return "Очередь пуста";
        }
    }

    //Возвращает элемент, находящийся в голове очереди, не удаляя его
    @Override
    public String peek() {
        if (arr[0] == null) {
            return "Очередь пуста";
        } else {
            return arr[0];
        }
    }

    //Добавление элемента в массив и расширяет массив при переполнении
    @Override
    public void push(String element) {
        if (size() < arr.length) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == null) {
                    arr[i] = element;
                    break;
                }
            }
        } else {
            String[] arrNew = new String[(arr.length * 2)];
            for (int i = 0; i < arrNew.length; i++) {
                if (i < arr.length) {
                    arrNew[i] = arr[i];
                }
                if (arrNew[i] == null) {
                    arrNew[i] = element;
                    arr = arrNew;
                    break;
                }
            }
        }
    }
}

