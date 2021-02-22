package Algorithms;

import Algorithms.Permutations;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class PermutationsTest {


    @Test
    public void testEmptyArray() {
        ArrayList<Integer> arr = new ArrayList<>();
        Set<ArrayList<Integer>> permuted = Permutations.permute(arr);
        Set<ArrayList<Integer>> result = new HashSet<>();
        assertEquals(result, permuted);
    }

    @Test
    public void testSizeOneArray() {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1));
        Set<ArrayList<Integer>> permuted = Permutations.permute(arr);
        Set<ArrayList<Integer>> result = new HashSet<>();
        result.add(new ArrayList<>(Arrays.asList(1)));
        assertEquals(result, permuted);
    }

    @Test
    public void testSmall() {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3));
        Set<ArrayList<Integer>> permuted = Permutations.permute(arr);
        Set<ArrayList<Integer>> result = new HashSet<>();
        result.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        result.add(new ArrayList<>(Arrays.asList(1, 3, 2)));
        result.add(new ArrayList<>(Arrays.asList(2, 1, 3)));
        result.add(new ArrayList<>(Arrays.asList(2, 3, 1)));
        result.add(new ArrayList<>(Arrays.asList(3, 1, 2)));
        result.add(new ArrayList<>(Arrays.asList(3, 2, 1)));
        assertEquals(result, permuted);
    }

}