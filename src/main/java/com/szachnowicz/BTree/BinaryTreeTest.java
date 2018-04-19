package com.szachnowicz.BTree;

import com.szachnowicz.DoubleLinkedList.TimeMessure;
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
    private TimeMessure time;

    public BinaryTreeTest() {
        super( "BTree");
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
            time = new TimeMessure();
            for (int k = 0; k < testTimes; k++) {
                time.start();
                binaryTree.addNode(radnomInt.get(k));
                time.end();
            }


            result.addMessureTime(testTimes, time.getDuration());

            time = new TimeMessure();
            for (int k = 0; k < testTimes; k++) {
                Integer value = radnomInt.get(random.nextInt(radnomInt.size()));
                time.start();
                binaryTree.findNote(value);
                time.end();
            }


            searchResult.addMessureTime(testTimes, time.getDuration());
            time = new TimeMessure();

            for (int k = 0; k < testTimes; k++) {
                time.start();
                binaryTree.remove(radnomInt.get(k));
                time.end();
            }


            resultDelete.addMessureTime(testTimes, time.getDuration());
        }


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

            for (int k = 0; k < testTimes; k++) {
                binaryTree.addNode(radnomInt.get(k));
                binaryTree.inOrderTraverseTree(binaryTree.root);
            }


            result.addMessureTime(testTimes, time.getDuration());


            for (int k = 0; k < testTimes; k++) {
                binaryTree.remove(radnomInt.get(k));
                binaryTree.inOrderTraverseTree(binaryTree.root);
            }


            resultDelete.addMessureTime(testTimes, time.getDuration());
        }


        results.add(result);
        results.add(resultDelete);

    }


}