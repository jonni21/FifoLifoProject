package com.pirates;


/**
 * Created by Wrong on 26.01.2016.
 */
public class FIFO extends AbstractQueue {

    //Удаляет последний добавленый элемент
    @Override
    public String pop() {
        String firstElement = getArr()[0];
        for (int i = 0; i < getArr().length; i++) {
            if (i != getArr().length - 1) {
                getArr()[i] = getArr()[i + 1];
            } else getArr()[i] = null;
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
        if (getArr()[0] == null) {
            return "Очередь пуста";
        } else {
            return getArr()[0];
        }
    }

    //Добавление элемента в массив и расширяет массив при переполнении
    @Override
    public void push(String element) {
        if (!("").equals(element)) {
            if (size() < getArr().length) {
                for (int i = 0; i < getArr().length; i++) {
                    if (getArr()[i] == null) {
                        getArr()[i] = element;
                        break;
                    }
                }
            } else {
                String[] arrNew = new String[(getArr().length * 2)];
                for (int i = 0; i < arrNew.length; i++) {
                    if (i < getArr().length) {
                        arrNew[i] = getArr()[i];
                    }
                    if (arrNew[i] == null) {
                        arrNew[i] = element;
                        getSet(arrNew);
                        break;
                    }
                }
            }
        }
    }
}

