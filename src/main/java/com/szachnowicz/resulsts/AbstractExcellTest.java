package com.szachnowicz.resulsts;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class AbstractExcellTest {
    protected static Random random;
    protected static List<Result> results = new ArrayList<>();
    protected static int TEST_TIMES;
    protected static List<Integer> radnomInt = new ArrayList<>();
    private static String FILE_NAME;

    public AbstractExcellTest(int times, String fileName) {
        TEST_TIMES = times;
        FILE_NAME = fileName;
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
        excelParser.createFile(FILE_NAME, results);

    }


}
