package com.pirates;

/**
 * Created by Wrong on 26.01.2016.
 */
public class LIFO extends AbstractQueue {
    /*Показывает элемент из очереди и удаляет*/
    @Override
    public String pop() {
        String lastElement = null;
        for (int i = getArr().length - 1; i >= 0; i--) {
            if (getArr()[i] != null) {
                lastElement = getArr()[i];
                getArr()[i] = null;
                break;
            }
        }
        return lastElement;
    }

    /*Показывает элемент из очереди*/
    @Override
    public String peek() {
        String lastElement = null;
        if (size() == 0) {
            System.out.println("Add elements in the array");
        } else {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] != null) {
                    lastElement = arr[i];
                    break;
                }
            }
        }
        return lastElement;
    }

    /*Добавление элемента в массив и расширяет массив при переполнении*/
    @Override
    public void push(String element) {
        if(!("").equals(element)) {
            if (size() < getArr().length) {
                for (int i = 0; i < getArr().length; i++) {
                    if (getArr()[i] == null) {
                        getArr()[i] = element;
                        break;
                    }
                }
            } else {
                String[] arrNew = new String[(int) (getArr().length * 1.5)];
                for (int i = 0; i < arrNew.length; i++) {
                    if (i < getArr().length) {
                        arrNew[i] = getArr()[i];
                    }
                    if (arrNew[i] == null) {
                        arrNew[i] = element;
                        setArr(arrNew);
                        break;
                    }
                }
            }
        }
    }
}
