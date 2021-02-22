package Sorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BucketSortFirstLetter {

    public static List<String> fillBuckets(List<String> words) {
        if (words == null || words.size() == 0) return null;
        if (words.size() == 1) return new ArrayList(words);

        //128 ascii letters
        Queue<String>[] buckets = new Queue[128];

        // add first letter to each bucket
        for (String e : words) {
            int index = e.charAt(0);
            if (buckets[index] == null) buckets[index] = new LinkedList<>();
            buckets[index].add(e);
        }

        // read buckets
        ArrayList<String> res = new ArrayList<>();
        for(Queue<String> bucket : buckets) {
            if (bucket != null) {
                res.addAll(bucket);
            }
        }

        return res;
    }


    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("cat");
        words.add("dog");
        words.add("apple");
        words.add("banana");
        words.add("horse");
        words.add("london");
        words.add("zoo");
        System.out.println(fillBuckets(words));
    }
}
