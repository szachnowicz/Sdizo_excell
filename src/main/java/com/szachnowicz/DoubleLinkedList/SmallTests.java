package com.szachnowicz.DoubleLinkedList;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class SmallTests {
    private DoubleLinkedList<Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new DoubleLinkedList<>();
    }


    @Test
    public void addEndTest() {
        list.addAtEnd(3);
        list.addAtEnd(2);
        list.addAtEnd(1);
        list.display();
        assertTrue(list.get(0) == 3);
        assertTrue(list.get(1) == 2);
        assertTrue(list.get(2) == 1);
    }

    @Test
    public void deleteEndTest() throws Exception {
        list.addAtEnd(3);
        list.addAtEnd(2);
        list.addAtEnd(1);
        list.display();
        list.deleteAtEnd();
        System.out.println("------------");
        list.display();
    }

    @Test
    public void serachTest() throws Exception {

        list.addAtEnd(3);
        list.addAtEnd(2);
        list.addAtEnd(1);
        list.display();
        System.out.println(list.search(1));


    }

    @Test
    public void deleteIndexTest() throws Exception {
        list.addAtBegin(3);
        list.addAtBegin(2);
        list.addAtBegin(1);
        list.display();

        list.deleteAtIndex(1);
        list.display();

    }

    @Test
    public void addBeginTest() throws Exception {
        list.addAtBegin(3);
        list.addAtBegin(2);
        list.addAtBegin(1);
        list.display();
        assertTrue(list.get(0) == 1);
        assertTrue(list.get(1) == 2);
        assertTrue(list.get(2) == 3);

    }


    @Test
    public void addAtIndex() {

        list.addAtIndex(99, 0);
        list.addAtIndex(199, 1);
        list.addAtIndex(299, 1);
        list.display();
        assertTrue(list.get(0) == 99);
        assertTrue(list.get(1) == 299);
        assertTrue(list.get(2) == 199);
    }


}
