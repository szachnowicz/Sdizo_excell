package com.szachnowicz.mainTests;

import com.szachnowicz.DoubleLinkedList.TimeMessure;
import com.szachnowicz.RBTree.RedBlackTree;
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

    private static final int TEST_TIMES = 1000;
    private static List<Integer> radnomInt = new ArrayList<>();
    private static Random random;
    private TimeMessure time = new TimeMessure();


    @BeforeClass
    public static void setUpBc() throws Exception {

        random = new Random();
        for (int i = 0; i < TEST_TIMES * 10; i++) {
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
    public void singleStactureTest() {
        Result deleteBegin = new Result("Usuwanie z elementu");
        for (int i = 0; i < 10; i++) {
            tree = new RedBlackTree<>();
            int testTimes = TEST_TIMES * (i + 1);


            for (int j = 0; j < testTimes; j++) {
                tree.insert(radnomInt.get(j));
            }

            time.reset();
            for (int k = 0; k < testTimes; k++) {
                time.start();
                tree.delete(radnomInt.get(k));
                time.end();
                tree.insert(radnomInt.get(k));
            }
            deleteBegin.addMessureTime(testTimes, time.getDuration());
        }
        results.add(deleteBegin);
    }


    @Test
    public void addingNote() throws Exception {

        Result result = new Result("Dodawanie do wezła");
        Result resultDelete = new Result("Usuwanie z wezła");
        Result searchDelete = new Result("Wyszukiwanie");


        for (int i = 0; i < 10; i++) {
            setUp();


            int testTimes = TEST_TIMES * (i + 1);

            for (int k = 0; k < testTimes; k++) {
                Integer key = radnomInt.get(k);
                time.start();
                tree.insert(key);
                time.end();
            }

            result.addMessureTime(testTimes, time.getDuration());
            time.reset();
            /////////////////////////////////////////////////////////////////////

            for (int k = 0; k < testTimes; k++) {
                int rIndex = random.nextInt(testTimes);
                Integer key = radnomInt.get(rIndex);
                time.start();
                tree.search(key);
                time.end();

            }

            searchDelete.addMessureTime(testTimes, time.getDuration());
            time.reset();
            /////////////////////////////////////////////////////////////////////

            for (int k = 0; k < testTimes; k++) {
                Integer key = radnomInt.get(k);
                try {
                    time.start();
                    tree.delete(key);
                    time.end();
                } catch (NullPointerException e) {
                    System.out.println(key);
                }
            }
            resultDelete.addMessureTime(testTimes, time.getDuration());
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