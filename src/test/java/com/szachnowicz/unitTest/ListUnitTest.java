package com.szachnowicz.unitTest;

import com.szachnowicz.DoubleLinkedList.DoubleLinkedList;
import org.junit.Test;

public class ListUnitTest {
    DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

    @Test
    public void allTest() throws Exception {
        list.addAtEnd(1);
        list.addAtEnd(3);
        list.addAtEnd(5);
        list.addAtEnd(7);
        list.addAtEnd(9);
        list.display();
        list.addAtBegin(11);
        list.addAtBegin(12);
        list.display();
        list.addAtEnd(13);
        list.addAtEnd(14);
        list.addAtIndex(15, 1);
        list.display();


        for (int i = 0; i < 10; i++) {
            if(i%2==0)
                list.deleteAtBegin();
            if(i%2==1)
                list.deleteAtEnd();
        }
        list.display();
    }
}
