package Sorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RadixSortMSD {

    // keys length can be different
    public static List<String> radixSortMSD(List<String> words) {
        if (words == null || words.size() == 0) return null;
        if (words.size() <= 1) return new ArrayList<>(words);
        return bucketSort(words, 0);
    }

    public static List<String> bucketSort(List<String> words, int radix) {
        List<String> sorted = new ArrayList<>();

        // 128 ascii characters
        LinkedList<String>[] buckets = new LinkedList[128];


        for(String word : words) {
            // if word less than radix -> sorted
            if (word.length() <= radix) {
                sorted.add(word);
                continue;
            }
            // else put words in buckets and sort
            int index = word.charAt(radix);
            if (buckets[index] == null) buckets[index] = new LinkedList<>();
            buckets[index].add(word);
        }

        // Recursively calling bucket sort within each bucket
        for (LinkedList<String> bucket : buckets)
            if (bucket != null) sorted.addAll(bucketSort(bucket, radix + 1));

        return sorted;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("cat");
        words.add("dog");
        words.add("apple");
        words.add("banana");
        words.add("horse");
        words.add("laptop");
        words.add("zoo");
        System.out.println(radixSortMSD(words));
    }
}
