package com.szachnowicz.mainTests;

import com.szachnowicz.DoubleLinkedList.TimeMessure;
import com.szachnowicz.bHeap.MHeap;
import com.szachnowicz.resulsts.AbstractExcellTest;
import com.szachnowicz.resulsts.Result;
import org.junit.Test;

public class HeapTest extends AbstractExcellTest {

    public MHeap<Integer> heap = new MHeap<>();


    public HeapTest() {
        super("Kopiec Binarny");


    }

    @Test
    public void insertTestAndDeleteTest() {
        Result insertResult = new Result("Dodawanie elementu");
        Result resultDelete = new Result("Usuwanie elementu");
        Result searchResult = new Result("Szukanie losowego elementu");


        for (int i = 0; i < 10; i++) {
            int testTimes = TEST_TIMES * (i + 1);
            // insert Test

            for (int j = 0; j < testTimes; j++) {
                time.start();
                heap.insert(radnomInt.get(j));
                time.end();
            }

            insertResult.addMessureTime(testTimes, time.getDuration());
            time.reset();

            for (int j = 0; j < testTimes; j++) {
                Integer rValue = radnomInt.get((int) (Math.random() * radnomInt.size()));
                time.start();
                Integer integer = heap.find(rValue);
                time.end();
            }

            searchResult.addMessureTime(testTimes, time.getDuration());
            time.reset();
            // delete Test

            for (int j = 0; j < testTimes; j++) {
                time.start();
                heap.insert(radnomInt.get(j));
                time.end();
            }

            resultDelete.addMessureTime(testTimes, time.getDuration());


        }
        results.add(insertResult);
        results.add(searchResult);
        results.add(resultDelete);

    }


}
