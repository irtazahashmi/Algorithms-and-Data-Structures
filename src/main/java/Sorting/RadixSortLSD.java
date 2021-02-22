package Sorting;
import java.util.*;

public class
RadixSortLSD {

    // keys must be equal length
    public static List<String> radixSortLSD(List<String> phoneNumbers) {
        if (phoneNumbers == null || phoneNumbers.size() == 0) return null;
        if (phoneNumbers.size() <= 1) return new ArrayList<>(phoneNumbers);

        // start from lowest key to the highest. Last 2 dont matter
        // assuming 06XXXXXXXX format.
        for (int i = 9; i >= 2; i--) {
            phoneNumbers = bucketSort(phoneNumbers, i);
        }
        return phoneNumbers;
    }

    @SuppressWarnings("unchecked")
    public static List<String> bucketSort(List<String> phoneNumbers, int radix) {
        List<String> sorted = new ArrayList<>();
        // 10 numbers possible
        LinkedList<String>[] buckets = new LinkedList[10];

        //put in buckets
        for (String phone : phoneNumbers) {
            int index = Integer.parseInt(String.valueOf(phone.charAt(radix))); // phone.charAt(radix) - 48
            if (buckets[index] == null) buckets[index] = new LinkedList<>();
            buckets[index].add(phone);
        }

        for (LinkedList<String> bucket : buckets)
            if (bucket != null) sorted.addAll(bucket);

        return sorted;
    }

    public static void main(String[] args) {
        List<String> numbers = new ArrayList<>();
        numbers.add("0682948283");
        numbers.add("0673933283");
        numbers.add("0694200223");
        numbers.add("0693423043");
        numbers.add("0606306536");
        numbers.add("0638942934");
        System.out.println(radixSortLSD(numbers));
    }
}
