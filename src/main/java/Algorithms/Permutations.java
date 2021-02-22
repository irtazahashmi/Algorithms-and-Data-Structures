package Algorithms;

import java.util.*;

public class Permutations {

    public static Set<ArrayList<Integer>> permute(ArrayList<Integer> list) {
        Set<ArrayList<Integer>> result = new HashSet<>();

        if (list.isEmpty()) return result;
        else {
            permuteHelper(result, new ArrayList<>(), list);
            return result;
        }
    }

    private static void permuteHelper(Set<ArrayList<Integer>> result, ArrayList<Integer> newList, ArrayList<Integer> list) {
        if (newList.size() == list.size()) {
            result.add(new ArrayList<>(newList));
        } else {

            for (int i = 0; i < list.size(); i++) {

                if (newList.contains(list.get(i))) {
                    continue;
                }

                newList.add(list.get(i));
                permuteHelper(result, newList, list);
                newList.remove(newList.size()-1);
            }
        }

    }
}
