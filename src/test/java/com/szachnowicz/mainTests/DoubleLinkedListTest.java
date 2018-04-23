package com.szachnowicz.mainTests;

import com.szachnowicz.DoubleLinkedList.DoubleLinkedList;
import com.szachnowicz.DoubleLinkedList.TimeMessure;
import com.szachnowicz.resulsts.AbstractExcellTest;
import com.szachnowicz.resulsts.ExcelParser;
import com.szachnowicz.resulsts.Result;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DoubleLinkedListTest extends AbstractExcellTest {
    TimeMessure time = new TimeMessure();

    private DoubleLinkedList<Integer> list;

    public DoubleLinkedListTest() {
        super("LISTA");
    }

    @Before
    public void setUp() throws Exception {
        list = new DoubleLinkedList<>();
    }

    @BeforeClass
    public static void setUpBc() throws Exception {

        Random random = new Random();
        for (int i = 0; i < 50 * TEST_TIMES; i++) {
            radnomInt.add(random.nextInt());
        }


    }


    @Test
    public void singleStactureTest() {
        Result deleteBegin = new Result("Usuwanie z końca");
        for (int i = 0; i < 10; i++) {
            list = new DoubleLinkedList<>();
            int testTimes = TEST_TIMES * (i + 1);


            for (int j = 0; j < testTimes; j++) {
                list.addAtBegin(radnomInt.get(j));
            }

            time.reset();
            for (int k = 0; k < testTimes; k++) {
                time.start();
                list.deleteAtEnd();
                time.end();
                list.addAtBegin(radnomInt.get(k));
            }
            deleteBegin.addMessureTime(testTimes, time.getDuration());
        }
        results.add(deleteBegin);
    }

    @Test
    public void addBeginTest() {
        Result result = new Result("Dodawanie z początku");
        Result resultDelete = new Result("Usuwanie z początku");
        Result serachResults = new Result("Wyszukiwanie");
        for (int i = 0; i < 10; i++) {
            time = new TimeMessure();
            list = new DoubleLinkedList<>();
            int testTimes = TEST_TIMES * (i + 1);

            for (int k = 0; k < testTimes; k++) {
                time.start();
                list.addAtBegin(radnomInt.get(k + i));
                time.end();
            }

            result.addMessureTime(testTimes, time.getDuration());
            time.reset();

            for (int k = 0; k < testTimes; k++) {
                time.start();
                list.search(list.size / 2);
                time.end();
            }


            serachResults.addMessureTime(testTimes, time.getDuration());
            time.reset();

            for (int k = 0; k < testTimes; k++) {
                time.start();
                list.deleteAtBegin();
                time.end();
            }

            resultDelete.addMessureTime(testTimes, time.getDuration());
        }
        results.add(result);
        results.add(resultDelete);
        results.add(serachResults);


    }


    @Test
    public void addEndTest() {
        Result result = new Result("Dodawanie od końca");
        Result resultDelete = new Result("Usuwanie z końca");
        List<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list = new DoubleLinkedList<>();
            time = new TimeMessure();

            int testTimes = TEST_TIMES * (i + 1);

            for (int k = 0; k < testTimes; k++) {
                time.start();
                list.addAtEnd(radnomInt.get(k + i));
                time.end();
            }

            result.addMessureTime(testTimes, time.getDuration());
            time.reset();

            testTimes = TEST_TIMES * (i + 1);

            for (int k = 0; k < testTimes; k++) {
                time.start();
                list.deleteAtEnd();
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

        List<Integer> listN = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list = new DoubleLinkedList<>();
            int testTimes = TEST_TIMES * (i + 1);
            time = new TimeMessure();
            for (int k = 0; k < testTimes; k++) {
                time.start();
                list.addAtIndex(k, k / 2);
                time.end();
            }

            result.addMessureTime(testTimes, time.getDuration());
            time.reset();
            for (int k = 0; k < testTimes; k++) {
                time.start();
                list.deleteAtIndex(k / 2);
                time.end();
            }

            resultDelete.addMessureTime(testTimes, time.getDuration());
        }
        results.add(resultDelete);
        results.add(result);

    }


}