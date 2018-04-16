package com.szachnowicz.bHeap;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class HeapUnitTest  {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void name() throws Exception {


        MHeap<Integer> heap = new MHeap<>();
        for (int i = 0; i < 50; i++) {

            heap.insert(new Random().nextInt(100));
        }

        System.out.println(heap.toString());
        heap.print();
        System.out.println("_--------------------------------------");
        for (int i = 0; i < 10; i++) {
            heap.delete(heap.size()/2);
        }
        heap.print();


    }
}