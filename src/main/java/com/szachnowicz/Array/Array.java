package com.szachnowicz.Array;

import com.szachnowicz.resulsts.IMethods;

import java.util.Arrays;

public class Array implements IMethods<Integer> {

    public int array[] = new int[0];

    public void print() {
        System.out.println(Arrays.toString(array));
    }

    @Override
    public void addAtEnd(Integer item) {
        int tempArr[] = new int[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            tempArr[i] = array[i];
        }
        tempArr[array.length] = item;
        array = tempArr;
       

    }

    @Override
    public void addAtBegin(Integer item) {
        int tempArr[] = new int[array.length + 1];
        tempArr[0] = item;
        for (int i = 0; i < array.length; i++) {
            tempArr[i + 1] = array[i];
        }
        array = tempArr;
       
    }

    @Override
    public void addAtIndex(Integer item, int index) {
        int tempArr[] = new int[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            if (array.length <= index)
                return;
            if (i >= index) {
                tempArr[i + 1] = array[i];

            } else {
                tempArr[i] = array[i];
            }
            tempArr[index] = item;
        }

        array = tempArr;
       

    }

    @Override
    public void deleteAtEnd() {
        int tempArr[] = new int[array.length - 1];

        for (int i = 0; i < array.length - 1; i++) {
            tempArr[i] = array[i];
        }

        array = tempArr;
       

    }

    @Override
    public void deleteAtBegin() {
        int tempArr[] = new int[array.length - 1];

        for (int i = 1; i < array.length; i++) {
            tempArr[i-1] = array[i];
        }

        array = tempArr;
       


    }

    @Override
    public void deleteAtIndex(int index) {
        if (array.length <= index)
            return;

        int tempArr[] = new int[array.length - 1];

        for (int i = 0; i < array.length; i++) {
            if (i == index) continue;

            if (i > index) {
                tempArr[i - 1] = array[i];
            } else {
                tempArr[i] = array[i];
            }
        }

        array = tempArr;

    }





    @Override
    public int search(Integer item) {
        String info = "";
        int index = -1;
        for (int i = 0; i < array.length; i++) {

            if (index != -1) {
                info = "jest wiecej niż jeden wynik wyszukiwania";
                continue;
            }
            if (array[i] == item) {
                index = i;
            }


        }
        System.out.println(info);
        return index;
    }


}
