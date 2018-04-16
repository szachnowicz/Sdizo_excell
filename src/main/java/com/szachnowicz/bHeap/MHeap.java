package com.szachnowicz.bHeap;

import java.util.*;

/**
 * @author Sesh Venugopal. New Jersey. 2013
 */
public class MHeap<T extends Comparable<T>> {

    private List<T> list;

    public MHeap() {
        list = new ArrayList<T>();
    }

    private void siftUp() {
        int k = list.size() - 1;
        while (k > 0) {
            int p = (k - 1) / 2;
            T item = list.get(k);
            T parent = list.get(p);
            if (item.compareTo(parent) > 0) {
                // swap
                list.set(k, parent);
                list.set(p, item);

                // move up one level
                k = p;
            } else {
                break;
            }
        }
    }

    public void insert(T item) {
        list.add(item);
        siftUp();
    }

    private void siftDown() {
        int k = 0;
        int l = 2 * k + 1;
        while (l < list.size()) {
            int max = l, r = l + 1;
            if (r < list.size()) { // there is a right child
                if (list.get(r).compareTo(list.get(l)) > 0) {
                    max++;
                }
            }
            if (list.get(k).compareTo(list.get(max)) < 0) {
                // switch
                T temp = list.get(k);
                list.set(k, list.get(max));
                list.set(max, temp);
                k = max;
                l = 2 * k + 1;
            } else {
                break;
            }
        }
    }

    public T get(int index) {
        return list.get(index);
    }


    public T deleteRoot()
            throws NoSuchElementException {
        if (list.size() == 0) {
            throw new NoSuchElementException();
        }
        if (list.size() == 1) {
            return list.remove(0);
        }
        T hold = list.get(0);
        list.set(0, list.remove(list.size() - 1));
        siftDown();
        return hold;
    }


    public T delete(int index)
            throws NoSuchElementException {
        if (list.size() == 0) {
            throw new NoSuchElementException();
        }
        if (list.size() == 1 || index <= 1) {
            return list.remove(0);
        }


        T hold = list.get(index);
        list.set(index, list.remove(list.size() - 1));
        siftDown();
        return hold;
    }


    public T deleteItem(T element) throws NoSuchFieldException {

        int index = list.indexOf(element);
        if (index == -1)
            throw new NoSuchFieldException();
        return delete(index);
    }


    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public String toString() {
        return list.toString();
    }

    public void print() {
        if (list.isEmpty()) return;
        new HeapPrinter(list);
    }


    public int find(T item) {

        T midValue = list.get(size() / 2);
        if (item.compareTo(midValue) > 0) {
            for (int i = size() / 2; i < size(); i++) {
                if (item == list.get(i)) {
                    return i;
                }
            }
        }

        for (int i = 0; i <= size() / 2; i++) {
            if (item == list.get(i)) {
                return i;
            }
        }


        return -1;
    }
}