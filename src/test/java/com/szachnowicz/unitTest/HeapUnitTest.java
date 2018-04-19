package com.szachnowicz.unitTest;

import com.szachnowicz.bHeap.MHeap;
import org.junit.Test;

public class HeapUnitTest {
    MHeap<Integer> heap = new MHeap<>();
    @Test
    public void testAll() throws Exception {

        heap.insert(1);
        heap.insert(3);
        heap.insert(5);
        heap.insert(7);
        heap.insert(9);
        heap.print();
        heap.insert(11);
        heap.insert(12);
        heap.print();
        heap.insert(13);
        heap.insert(14);

        heap.print();


        System.out.println("zanaleziono 7 w index"+ heap.find(7));
        System.out.println("zanaleziono 777 w index "+ heap.find(777));


        for (int i = 0; i < 9; i++) {
            heap.deleteRoot();
        }
        heap.print();
    }



}
