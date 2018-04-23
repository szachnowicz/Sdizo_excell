package com.szachnowicz.unitTest;

import com.szachnowicz.RBTree.RedBlackTree;
import org.junit.Test;

public class RBTUnit {
    RedBlackTree<Integer> tree = new RedBlackTree<>();

    @Test
    public void name() throws Exception {
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(7);
        tree.insert(9);

        tree.insert(11);
        tree.insert(12);
        tree.insert(13);
        tree.insert(14);
        tree.insert(15);
        System.out.println(tree);


        System.out.println(tree.search(14));

        System.out.println(tree);
        for (int i = 0; i < 10; i++) {
            tree.delete(i);
        }


        System.out.println(tree);
        tree.delete(10);

    }

    @Test
    public void print() throws Exception {
        tree.insert(10);
        System.out.println(tree);
        tree.insert(15);
        System.out.println(tree);
        tree.insert(8);
        System.out.println(tree);
        tree.insert(100);
        System.out.println(tree);


    }
}
