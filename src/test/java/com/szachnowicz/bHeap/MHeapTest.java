package com.szachnowicz.bHeap;

import org.junit.Test;

public class MHeapTest {


    @Test
    public void name() throws Exception {

        MHeap<Integer> heap = new MHeap<>();


        heap.insert(10);
        heap.insert(20);
        heap.insert(9);
        heap.insert(300);

        System.out.println(heap.toString());
        Integer delete = heap.deleteRoot();


    }

    @Test
    public void name1() throws Exception {


        System.out.println(Math.ceil((Math.log(3) / Math.log(2))));
        System.out.println((Math.log(8) / Math.log(2)));
        System.out.println((Math.log(16) / Math.log(2)));


    }
}