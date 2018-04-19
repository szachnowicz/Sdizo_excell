package com.szachnowicz.unitTest;

import com.szachnowicz.BTree.helpers.BTreePrinter;
import com.szachnowicz.RBTree.RedBlackTree;
import org.junit.Test;

public class RBTUnit {
    RedBlackTree<Integer> list = new RedBlackTree<>();

    @Test
    public void name() throws Exception {
        list.insert(1);
        list.insert(3);
        list.insert(5);
        list.insert(7);
        list.insert(9);
        System.out.println(list);
        list.insert(11);
        list.insert(12);
        System.out.println(list);
        list.insert(13);
        list.insert(14);
        list.insert(15);

        System.out.println(list);
        for (int i = 0; i < 10; i++) {

            list.delete(i);
        }
        System.out.println(list);

    }
}
