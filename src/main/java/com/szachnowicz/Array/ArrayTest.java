package com.szachnowicz.Array;

import com.szachnowicz.resulsts.ExcelParser;
import com.szachnowicz.resulsts.Result;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayTest {


    private static final int TEST_TIMES = 10000;

    @AfterClass
    public static void doYourOneTimeTeardown() {
        System.out.println("affter all");
        ExcelParser excelParser = new ExcelParser();
        excelParser.createFile("Array", results);

    }

    private Array array;
    private static List<Integer> radnomInt = new ArrayList<>();
    private static List<Result> results = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        array = new Array();
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
        Result resultDelete = new Result("Uswanie z początku");

        for (int i = 0; i < 10; i++) {
            array = new Array();
            int testTimes = TEST_TIMES * (i + 1);
            long startTime = System.nanoTime();
            for (int k = 0; k < testTimes; k++) {
                array.addAtBegin(radnomInt.get(k + i));
            }
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000;
            result.addMessureTime(testTimes, duration);

            startTime = System.nanoTime();
            for (int k = 0; k < testTimes; k++) {
                array.deleteAtBegin();
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
        for (int i = 0; i < 10; i++) {
            array = new Array();
            int testTimes = TEST_TIMES * (i + 1);
            long startTime = System.nanoTime();
            for (int k = 0; k < testTimes; k++) {
                array.addAtEnd(radnomInt.get(k + i));
            }
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000;
            result.addMessureTime(testTimes, duration);


            testTimes = TEST_TIMES * (i + 1);
            startTime = System.nanoTime();
            for (int k = 0; k < testTimes; k++) {
                array.deleteAtEnd();
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

        for (int i = 0; i < 10; i++) {
            array = new Array();
            int testTimes = TEST_TIMES * (i + 1);
            long startTime = System.nanoTime();
            for (int k = 0; k < testTimes; k++) {
                array.addAtIndex(radnomInt.get(k + i), k / 2);
            }
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000;
            result.addMessureTime(testTimes, duration);


            testTimes = TEST_TIMES * (i + 1);
            startTime = System.nanoTime();
            for (int k = 0; k < testTimes; k++) {
                array.deleteAtIndex(k / 2);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;
            resultDelete.addMessureTime(testTimes, duration);
        }
        results.add(resultDelete);
        results.add(result);

    }


}