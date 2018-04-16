package com.szachnowicz.BTree;

import com.szachnowicz.BTree.helpers.BTreePrinter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UnitBinaryTreeTest {
    BinaryTree<Integer> binaryTree;


    @Before
    public void setUp() throws Exception {
        binaryTree = new BinaryTree<>();
        binaryTree.addNode(50);
        binaryTree.addNode(25);
        binaryTree.addNode(75);
        binaryTree.addNode(12);


    }

    @Test
    public void printRoot() throws Exception {
        BTreePrinter.printNode(binaryTree.root);

        binaryTree.inOrderTraverseTree(binaryTree.root);



    }

    @Test
    public void inOrderTraverseTreeTest() {
        binaryTree.inOrderTraverseTree(binaryTree.root);
    }

    @Test
    public void dissOrderTraverseTreeTest() {
        binaryTree.preOrderTraversTree(binaryTree.root);
        binaryTree.addNode(100);
        binaryTree.preOrderTraversTree(binaryTree.root);

    }

    @Test
    public void findNoteTest() throws Exception {

        binaryTree.findNote(75);
    }

    @Test
    public void remoceTest() {


    }

}