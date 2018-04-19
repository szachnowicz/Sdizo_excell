package com.szachnowicz.unitTest;

import com.szachnowicz.Array.Array;
import org.junit.Before;
import org.junit.Test;

public class ArrayTest {
    public Array array = new Array();

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void allTest() throws Exception {
        array.addAtEnd(1);
        array.addAtEnd(3);
        array.addAtEnd(5);
        array.addAtEnd(7);
        array.addAtEnd(9);
        array.print();
        array.addAtBegin(11);
        array.addAtBegin(12);
        array.print();
        array.addAtEnd(13);
        array.addAtEnd(14);
        array.addAtIndex(15, 1);
        array.print();


        for (int i = 0; i < 10; i++) {
            if(i%2==0)
                array.deleteAtBegin();
            if(i%2==1)
            array.deleteAtEnd();
        }
        array.print();
    }
}
