package com.szachnowicz.resulsts;

import com.szachnowicz.DoubleLinkedList.TimeMessure;
import org.junit.AfterClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class AbstractExcellTest {
    protected TimeMessure time = new TimeMessure();
    protected static Random random;
    protected static List<Result> results = new ArrayList<>();
    protected static int TEST_TIMES;
    protected static List<Integer> radnomInt = new ArrayList<>();
    private static String fileName;

    public AbstractExcellTest(String fileName) {
        TEST_TIMES =5000;
        AbstractExcellTest.fileName = fileName;
        createRandomData();

    }


    public void createRandomData() {
        random = new Random();
        for (int i = 0; i < 10 * TEST_TIMES; i++) {
            radnomInt.add(random.nextInt());
        }

    }


    @AfterClass
    public static void doYourOneTimeTeardown() {
        ExcelParser excelParser = new ExcelParser();
        excelParser.createFile(fileName, results);
    }


}
