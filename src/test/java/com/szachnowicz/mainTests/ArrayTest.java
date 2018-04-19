package com.szachnowicz.mainTests;

import com.szachnowicz.Array.Array;
import com.szachnowicz.DoubleLinkedList.TimeMessure;
import com.szachnowicz.resulsts.AbstractExcellTest;
import com.szachnowicz.resulsts.ExcelParser;
import com.szachnowicz.resulsts.Result;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayTest extends AbstractExcellTest {


    public ArrayTest() {
        super("Tablica");
    }


    private Array array;

    @Before
    public void setUp() throws Exception {
        array = new Array();
        time = new TimeMessure();
    }

    @Test
    public void addBeginTest() {
        Result addBegin = new Result("Dodawanie z początku");
        Result deleteBegin = new Result("Uswanie z początku");
        Result searchResulst = new Result("Szukanie");

        for (int i = 0; i < 10; i++) {
            array = new Array();
            int testTimes = TEST_TIMES * (i + 1);

            time.reset();
            for (int k = 0; k < testTimes; k++) {

                time.start();
                array.addAtBegin(radnomInt.get(k));
                time.end();
            }

            addBegin.addMessureTime(testTimes, time.getDuration());
            time.reset();

            for (int j = 0; j < testTimes; j++) {
                time.start();
                boolean founded = array.find(array.size() / 2);
                time.end();
            }


            searchResulst.addMessureTime(testTimes, time.getDuration());
            time.reset();
            for (int k = 0; k < testTimes; k++) {
                time.start();
                array.deleteAtBegin();
                time.end();
            }

            deleteBegin.addMessureTime(testTimes, time.getDuration());

        }
        results.add(addBegin);
        results.add(deleteBegin);
        results.add(searchResulst);


    }

    @Test
    public void addEndTest() {
        Result result = new Result("Dodawanie od końca");
        Result resultDelete = new Result("Usuwanie z końca");
        for (int i = 0; i < 10; i++) {
            array = new Array();
            int testTimes = TEST_TIMES * (i + 1);
            time.reset();
            for (int k = 0; k < testTimes; k++) {
                time.start();
                array.addAtEnd(radnomInt.get(k + i));
                time.end();
            }
            result.addMessureTime(testTimes, time.getDuration());
            time.reset();

            for (int k = 0; k < testTimes; k++) {
                time.start();
                array.deleteAtEnd();
                time.end();

            }

            resultDelete.addMessureTime(testTimes, time.getDuration());

        }
        results.add(result);
        results.add(resultDelete);
    }


    @Test
    public void addAtIndexTest() {
        Result result = new Result("Dodawanie w środkowym indexie");
        Result resultDelete = new Result("Usuwanie ze środkowego indexu");

        for (int i = 0; i < 10; i++) {
            array = new Array();
            int testTimes = TEST_TIMES * (i + 1);


            for (int k = 0; k < testTimes; k++) {
                time.start();
                array.addAtIndex(radnomInt.get(k), k / 2);
                time.end();

            }
            result.addMessureTime(testTimes, time.getDuration());
            time = new TimeMessure();
            for (int k = 0; k < testTimes; k++) {
                time.start();
                array.deleteAtIndex(k / 2);
                time.end();
            }
            resultDelete.addMessureTime(testTimes, time.getDuration());
        }
        results.add(resultDelete);
        results.add(result);
    }


}