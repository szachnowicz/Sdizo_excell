package com.szachnowicz.resulsts;

public interface IMethods<T> {
    void addAtEnd(T item);

    void addAtBegin(T item);

    void addAtIndex(T item, int index);

    void deleteAtEnd();

    void deleteAtBegin();

    void deleteAtIndex(int index);

    int search(T Item);

}

