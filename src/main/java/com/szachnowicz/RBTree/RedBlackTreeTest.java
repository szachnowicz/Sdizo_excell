package com.szachnowicz.RBTree;

import com.szachnowicz.resulsts.ExcelParser;
import com.szachnowicz.resulsts.Result;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RedBlackTreeTest {

    private static final int TEST_TIMES = 500000;
    private static List<Integer> radnomInt = new ArrayList<>();
    private static Random random;

    @BeforeClass
    public static void setUpBc() throws Exception {

         random = new Random();
        for (int i = 0; i <  TEST_TIMES*10; i++) {
            radnomInt.add(random.nextInt(10000));
        }


    }

    private RedBlackTree<Integer> tree;
    private static List<Result> results = new ArrayList<>();


    @Before
    public void setUp() throws Exception {
        tree = new RedBlackTree<>();

    }

    @Test
    public void addingNote() throws Exception {

        Result result = new Result("Dodawanie do wezła");
        Result resultDelete = new Result("Usuwanie z wezła");
        Result searchDelete = new Result("Wyszukiwanie");


        for (int i = 0; i < 10; i++) {
            setUp();


            int testTimes = TEST_TIMES * (i + 1);
            long startTime = System.nanoTime();
            for (int k = 0; k < testTimes; k++) {
                Integer key = radnomInt.get(k);
                tree.insert(key);
            }

            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000;
            result.addMessureTime(testTimes, duration);
           /////////////////////////////////////////////////////////////////////

            startTime = System.nanoTime();
            for (int k = 0; k < testTimes; k++) {
                int rIndex = random.nextInt(testTimes);
                Integer key = radnomInt.get(rIndex);
                tree.search(key);

            }
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;
            searchDelete.addMessureTime(testTimes, duration);

           /////////////////////////////////////////////////////////////////////
            startTime = System.nanoTime();
            for (int k = 0; k < testTimes; k++) {
                Integer key = radnomInt.get(k);

                try {
                    tree.delete(key);
                } catch (NullPointerException e) {
                    System.out.println(key);
                }

            }
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;
            resultDelete.addMessureTime(testTimes, duration);
        }

    /////////////////////////////////////////////////////////////////////
        results.add(result);
        results.add(resultDelete);
        results.add(searchDelete);

    }


    @AfterClass
    public static void doYourOneTimeTeardown() {
        System.out.println("affter all");
        ExcelParser excelParser = new ExcelParser();
        excelParser.createFile("RBTree", results);
    }
}