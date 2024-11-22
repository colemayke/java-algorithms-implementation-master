package com.jwetherell.algorithms.sorts.test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.jwetherell.algorithms.sorts.QuickSort;
import java.util.Random;

public class QuickSortTest {
    
    @Test
    public void testBasicSortingWithFirstPivot() {
        Integer[] input = {5, 3, 1, 4, 2};
        Integer[] expected = {1, 2, 3, 4, 5};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.FIRST, input);
        assertArrayEquals("Basic sorting with first pivot failed", expected, result);
    }
    
    @Test
    public void testBasicSortingWithMiddlePivot() {
        Integer[] input = {5, 3, 1, 4, 2};
        Integer[] expected = {1, 2, 3, 4, 5};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.MIDDLE, input);
        assertArrayEquals("Basic sorting with middle pivot failed", expected, result);
    }
    
    @Test
    public void testBasicSortingWithRandomPivot() {
        Integer[] input = {5, 3, 1, 4, 2};
        Integer[] expected = {1, 2, 3, 4, 5};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, input);
        assertArrayEquals("Basic sorting with random pivot failed", expected, result);
    }
    
    @Test
    public void testEmptyArray() {
        Integer[] input = {};
        Integer[] expected = {};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, input);
        assertArrayEquals("Empty array sorting failed", expected, result);
    }
    
    @Test
    public void testSingleElement() {
        Integer[] input = {1};
        Integer[] expected = {1};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, input);
        assertArrayEquals("Single element sorting failed", expected, result);
    }
    
    @Test
    public void testDuplicateElements() {
        Integer[] input = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        Integer[] expected = {1, 1, 2, 3, 3, 4, 5, 5, 6, 9};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, input);
        assertArrayEquals("Duplicate elements sorting failed", expected, result);
    }
    
    @Test
    public void testLargeArray() {
        Random rand = new Random();
        Integer[] input = new Integer[10000];
        Integer[] expected = new Integer[10000];
        
        for (int i = 0; i < input.length; i++) {
            input[i] = rand.nextInt(10000);
            expected[i] = input[i];
        }
        
        java.util.Arrays.sort(expected);
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, input);
        assertArrayEquals("Large array sorting failed", expected, result);
    }
    
    @Test
    public void testAllPivotTypesConsistency() {
        Integer[] input = {5, 3, 1, 4, 2};
        Integer[] expected = {1, 2, 3, 4, 5};
        
        Integer[] resultFirst = QuickSort.sort(QuickSort.PIVOT_TYPE.FIRST, input.clone());
        Integer[] resultMiddle = QuickSort.sort(QuickSort.PIVOT_TYPE.MIDDLE, input.clone());
        Integer[] resultRandom = QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, input.clone());
        
        assertArrayEquals("First pivot sorting inconsistent", expected, resultFirst);
        assertArrayEquals("Middle pivot sorting inconsistent", expected, resultMiddle);
        assertArrayEquals("Random pivot sorting inconsistent", expected, resultRandom);
    }
}
