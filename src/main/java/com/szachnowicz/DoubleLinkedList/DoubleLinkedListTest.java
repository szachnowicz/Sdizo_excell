package com.szachnowicz.DoubleLinkedList;

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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DoubleLinkedListTest {
//    private DoubleLinkedList<Integer> list;
//
//
//
//
//
//    @Before
//    public void setUp() throws Exception {
//        list = new DoubleLinkedList<>();
//    }
//
//
//    @Test
//    public void addEndTest() {
//        list.addAtEnd(3);
//        list.addAtEnd(2);
//        list.addAtEnd(1);
//        list.display();
//        assertTrue(list.get(0) == 3);
//        assertTrue(list.get(1) == 2);
//        assertTrue(list.get(2) == 1);
//    }
//
//    @Test
//    public void deleteEndTest() throws Exception {
//        list.addAtEnd(3);
//        list.addAtEnd(2);
//        list.addAtEnd(1);
//        list.display();
//        list.deleteAtEnd();
//        System.out.println("------------");
//        list.display();
//    }
//
//    @Test
//    public void serachTest() throws Exception {
//
//        list.addAtEnd(3);
//        list.addAtEnd(2);
//        list.addAtEnd(1);
//        list.display();
//        System.out.println(list.search(1));
//
//
//    }
//
//    @Test
//    public void deleteIndexTest() throws Exception {
//        list.addAtBegin(3);
//        list.addAtBegin(2);
//        list.addAtBegin(1);
//        list.display();
//        list.deleteAtIndex(0);
//        list.display();
//
//    }
//
//    @Test
//    public void addBeginTest() throws Exception {
//        list.addAtBegin(3);
//        list.addAtBegin(2);
//        list.addAtBegin(1);
//        list.display();
//        assertTrue(list.get(0) == 1);
//        assertTrue(list.get(1) == 2);
//        assertTrue(list.get(2) == 3);
//
//    }
//
//
//    @Test
//    public void addAtIndex() {
//
//        list.addAtIndex(99, 0);
//        list.addAtIndex(199, 1);
//        list.addAtIndex(299, 1);
//        list.display();
//        assertTrue(list.get(0) == 99);
//        assertTrue(list.get(1) == 299);
//        assertTrue(list.get(2) == 199);
//    }

    private static final int TEST_TIMES = 10000;
    private DoubleLinkedList<Integer> list;

    @AfterClass
    public static void doYourOneTimeTeardown() {
        System.out.println("affter all");
        ExcelParser excelParser = new ExcelParser();
        excelParser.createFile("List", results);

    }

    private static List<Integer> radnomInt = new ArrayList<>();
    private static List<Result> results = new ArrayList<>();

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
    public void addBeginTest() {
        Result result = new Result("Dodawanie z początku");
        Result resultDelete = new Result("Uuswanie z początku");

        for (int i = 0; i < 10; i++) {
            list = new DoubleLinkedList<>();
            int testTimes = TEST_TIMES * (i + 1);
            long startTime = System.nanoTime();
            for (int k = 0; k < testTimes; k++) {
                list.addAtBegin(radnomInt.get(k + i));
            }
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000;
            result.addMessureTime(testTimes, duration);

            testTimes = TEST_TIMES * (i + 1);
            startTime = System.nanoTime();
            for (int k = 0; k < testTimes; k++) {
                list.deleteAtBegin();
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;
            resultDelete.addMessureTime(testTimes, duration);
        }
        results.add(result);
        results.add(resultDelete);


    }


    @Test
    public void addEndTest() {
        Result result = new Result("Dodawanie od końca");
        Result resultDelete = new Result("Usuwanie z końca");
        List<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list = new DoubleLinkedList<>();
            int testTimes = TEST_TIMES * (i + 1);
            long startTime = System.nanoTime();
            for (int k = 0; k < testTimes; k++) {
                list.addAtEnd(radnomInt.get(k + i));
//                list2.add(radnomInt.get(k + i));
            }
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000;
            result.addMessureTime(testTimes, duration);


            testTimes = TEST_TIMES * (i + 1);
            startTime = System.nanoTime();
            for (int k = 0; k < testTimes; k++) {
                list.deleteAtEnd();
//                list2.remove(radnomInt.get(k + i));
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;
            resultDelete.addMessureTime(testTimes, duration);

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
            long startTime = System.nanoTime();
            for (int k = 0; k < testTimes; k++) {

                list.addAtIndex(k, k / 2);
//                listN.add(k, k / 2);
            }
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000;
            result.addMessureTime(testTimes, duration);

            testTimes = TEST_TIMES * (i + 1);
            startTime = System.nanoTime();
            for (int k = 0; k < testTimes; k++) {
                list.deleteAtIndex(k / 2);
//                listN.remove(listN.size() / 2);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;
            resultDelete.addMessureTime(testTimes, duration);
        }
        results.add(resultDelete);
        results.add(result);

    }


}