ackage com.jwetherell.algorithms.sorts.test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.jwetherell.algorithms.sorts.BubbleSort;
import java.util.Random;

public class BubbleSortTest {
    
    @Test
    public void testBasicSorting() {
        Integer[] input = {5, 3, 1, 4, 2};
        Integer[] expected = {1, 2, 3, 4, 5};
        Integer[] result = BubbleSort.sort(input);
        assertArrayEquals("Basic sorting failed", expected, result);
    }
    
    @Test
    public void testEmptyArray() {
        Integer[] input = {};
        Integer[] expected = {};
        Integer[] result = BubbleSort.sort(input);
        assertArrayEquals("Empty array sorting failed", expected, result);
    }
    
    @Test
    public void testSingleElement() {
        Integer[] input = {1};
        Integer[] expected = {1};
        Integer[] result = BubbleSort.sort(input);
        assertArrayEquals("Single element sorting failed", expected, result);
    }
    
    @Test
    public void testDuplicateElements() {
        Integer[] input = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        Integer[] expected = {1, 1, 2, 3, 3, 4, 5, 5, 6, 9};
        Integer[] result = BubbleSort.sort(input);
        assertArrayEquals("Duplicate elements sorting failed", expected, result);
    }
    @Test
    public void testAlreadySorted() {
        Integer[] input = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};
        Integer[] result = BubbleSort.sort(input);
        assertArrayEquals("Already sorted array failed", expected, result);
    }
    
    @Test
    public void testReverseSorted() {
        Integer[] input = {5, 4, 3, 2, 1};
        Integer[] expected = {1, 2, 3, 4, 5};
        Integer[] result = BubbleSort.sort(input);
        assertArrayEquals("Reverse sorted array failed", expected, result);
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
        Integer[] result = BubbleSort.sort(input);
        assertArrayEquals("Large array sorting failed", expected, result);
    }
}