package com.szachnowicz.bHeap;

import org.apache.poi.ss.formula.functions.T;

import java.util.Arrays;
import java.util.List;

public class HeapPrinter {


    public <T extends Comparable<T>> HeapPrinter(List<T> list) {
        itemsInArray = list.size();
        theHeap = list.toArray();
        printTree2(getTreeRows(list.size()));
    }

    public int getTreeRows(int size) {

        return (int) Math.ceil((Math.log(size) / Math.log(2)))+1;
    }

    private int itemsInArray;
    private Object[] theHeap;

    public void printTree2(int rows) {

        // Number of spaces between items in tree

        int spaces = 0;

        int iteration = 1;

        // Generate all of the indents that are
        // needed depending on the number of rows
        // to print

        int[] indent = getIndentArray(rows);

        while (iteration <= rows) {

            // Find first Index : .5 * (-2 + 2^n)

            int indexToPrint = (int) (.5 * (-2 + (Math.pow(2, iteration))));

            // Number of Items per Row : 2^(n - 1)

            int itemsPerRow = (int) (Math.pow(2, iteration - 1));

            int maxIndexToPrint = indexToPrint + itemsPerRow;

            // Print the indents needed

            for (int j = 0; j < indent[iteration - 1]; j++)
                System.out.print(" ");

            // Print all of the index values for each row
            // indexToPrint represents the first index in the
            // row, while maxIndexToPrint equals the last

            for (int l = indexToPrint; l < maxIndexToPrint; l++) {

                // If the array isn't full don't try to print
                // indexes that don't exist

                if (l < itemsInArray) {

                    System.out.print(String.format("%2d", theHeap[l]));

                    for (int k = 0; k < spaces; k++)
                        System.out.print(" ");

                }

            }

            // In a tree the spaces get bigger in the
            // same way that indents get smaller

            spaces = indent[iteration - 1];

            iteration++;

            System.out.println();

        }

    }

    public int[] getIndentArray(int rows) {

        int[] indentArray = new int[rows];

        for (int i = 0; i < rows; i++) {

            indentArray[i] = (int) Math.abs((-2 + (Math.pow(2, i + 1))));

        }

        Arrays.sort(indentArray);

        indentArray = reverseArray(indentArray);

        return indentArray;

    }

    // Reverse the indent values in the array
    // so that they go from biggest to smallest

    public int[] reverseArray(int[] theArray) {

        // Index of the first element
        int leftIndex = 0;

        // Index of last element
        int rightIndex = theArray.length - 1;

        while (leftIndex < rightIndex) {
            // Exchange the left and right elements
            int temp = theArray[leftIndex];
            theArray[leftIndex] = theArray[rightIndex];
            theArray[rightIndex] = temp;

            // Move the indexes to check towards the middle
            leftIndex++;
            rightIndex--;
        }

        return theArray;
    }
}
