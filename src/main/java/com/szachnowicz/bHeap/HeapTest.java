package com.szachnowicz.bHeap;

import com.szachnowicz.resulsts.AbstractExcellTest;
import com.szachnowicz.resulsts.Result;
import org.junit.Test;

public class HeapTest extends AbstractExcellTest {

    public MHeap<Integer> heap = new MHeap<>();


    public HeapTest() {
        super(50000, "Kopiec Binarny");

    }

    @Test
    public void insertTestAndDeleteTest() {
        Result insertResult = new Result("Dodawanie elementu");
        Result resultDelete = new Result("Usuwanie elementu");
        Result searchResult = new Result("Szukanie losowego elementu");
        long start, end, duration;


        for (int i = 0; i < 10; i++) {
            int testTimes = TEST_TIMES * (i + 1);
            // insert test
            start = System.nanoTime();
            for (int j = 0; j < testTimes; j++) {
                heap.insert(radnomInt.get(j));
            }
            end = System.nanoTime();
            duration = (end - start) / 1000000;
            insertResult.addMessureTime(testTimes, duration);
//            //find
            start = System.nanoTime();
            for (int j = 0; j < testTimes; j++) {
                Integer rValue = radnomInt.get((int) (Math.random() * radnomInt.size()));
                Integer integer = heap.find(rValue);
            }
            end = System.nanoTime();
            duration = (end - start) / 1000000;
            searchResult.addMessureTime(testTimes, duration);

            // delete test
            start = System.nanoTime();
            for (int j = 0; j < testTimes; j++) {
                heap.insert(radnomInt.get(j));
            }
            end = System.nanoTime();
            duration = (end - start) / 1000000;
            resultDelete.addMessureTime(testTimes, duration);


        }
        results.add(insertResult);
        results.add(searchResult);
        results.add(resultDelete);

    }


}
