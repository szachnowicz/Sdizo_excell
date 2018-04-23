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



        System.out.println("zanaleziono 11 w index " + heap.find(11));
        System.out.println("zanaleziono 111 w index " + heap.find(111));
        System.out.println("zanaleziono 115 w index " + heap.find(115));
        System.out.println("zanaleziono 13 w index " + heap.find(13));
        System.out.println("zanaleziono 14 w index " + heap.find(14));
        System.out.println("zanaleziono 17 w index " + heap.find(17));
        System.out.println("zanaleziono 20 w index " + heap.find(20));

        for (int i = 0; i < 9; i++) {
            heap.deleteRoot();
        }
        heap.print();
        heap.deleteRoot();
        heap.deleteRoot();
        heap.insert(10);
        heap.insert(15);
        heap.insert(30);

        heap.print();

        System.out.println("zanaleziono 10 w index " + heap.find(10));
        System.out.println("zanaleziono 31 w index " + heap.find(31));



    }


}
