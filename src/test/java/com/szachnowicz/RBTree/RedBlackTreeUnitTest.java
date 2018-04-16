package com.szachnowicz.RBTree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RedBlackTreeUnitTest {
    RedBlackTree<Integer> tree = new RedBlackTree<>();

    @Before
    public void setUp() throws Exception {


    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addingTest() {


        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(50);
        tree.insert(50);


        tree.delete(10);
        tree.delete(20);
        tree.delete(40);



    }

}