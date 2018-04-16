package com.szachnowicz.BTree;

import com.szachnowicz.resulsts.AbstractExcellTest;
import com.szachnowicz.resulsts.ExcelParser;
import com.szachnowicz.resulsts.Result;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryTreeTest extends AbstractExcellTest {


    private BinaryTree<Integer> binaryTree;

    public BinaryTreeTest() {
        super(100,"BTree");
    }


    @Before
    public void setUp() throws Exception {
        binaryTree = new BinaryTree<>();

    }

    @Test
    public void addingNote() throws Exception {
        Result result = new Result("Dodawanie do wezła");
        Result searchResult = new Result("Szukanie losowego elementu");
        Result resultDelete = new Result("Usuwanie z wezła");


        for (int i = 0; i < 10; i++) {
            setUp();


            int testTimes = TEST_TIMES * (i + 1);
            long startTime = System.nanoTime();
            for (int k = 0; k < testTimes; k++) {
                binaryTree.addNode(radnomInt.get(k));
//                binaryTree.inOrderTraverseTree(binaryTree.root);
            }
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000;
            result.addMessureTime(testTimes, duration);


            startTime = System.nanoTime();
            for (int k = 0; k < testTimes; k++) {
                Integer value = radnomInt.get(random.nextInt(radnomInt.size()));
                binaryTree.findNote(value);
//                binaryTree.inOrderTraverseTree(binaryTree.root);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;
            searchResult.addMessureTime(testTimes, duration);


            startTime = System.nanoTime();
            for (int k = 0; k < testTimes; k++) {
                binaryTree.remove(radnomInt.get(k));
//                binaryTree.inOrderTraverseTree(binaryTree.root);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;
            resultDelete.addMessureTime(testTimes, duration);
        }


//        BTreePrinter.printNode(binaryTree.root);
        results.add(result);
        results.add(resultDelete);
        results.add(searchResult);

    }

    @Ignore
    @Test
    public void addingNoteInOrder() throws Exception {
        Result result = new Result("Dodawanie do wezła z sortowaniem");
        Result resultDelete = new Result("Usuwanie z wezła bez sortowania");


        for (int i = 0; i < 10; i++) {
            setUp();


            int testTimes = TEST_TIMES * (i + 1);
            long startTime = System.nanoTime();
            for (int k = 0; k < testTimes; k++) {
                binaryTree.addNode(radnomInt.get(k));
                binaryTree.inOrderTraverseTree(binaryTree.root);
            }
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000;
            result.addMessureTime(testTimes, duration);

            startTime = System.nanoTime();
            for (int k = 0; k < testTimes; k++) {
                binaryTree.remove(radnomInt.get(k));
                binaryTree.inOrderTraverseTree(binaryTree.root);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;
            resultDelete.addMessureTime(testTimes, duration);
        }

//        BTreePrinter.printNode(binaryTree.root);
        results.add(result);
        results.add(resultDelete);

    }



}