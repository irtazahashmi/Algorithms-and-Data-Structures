package Sorting;

import java.util.Arrays;

public class CountingSortChar {
    public static char[] countSort(char seq[]) {
        char res[] = new char[seq.length];
        int count[] = new int[256];
        Arrays.fill(count, 0);

        // storing the count of each array
        for (int i = 0; i < seq.length; ++i) ++count[seq[i]];

        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i = 1; i <= 255; ++i) count[i] += count[i-1];

        for (int i = 0; i < seq.length; ++i) {
            res[count[seq[i]]-1] = seq[i];
            --count[seq[i]];
        }

        // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i< seq.length; ++i) seq[i] = res[i];
        return seq;
    }
}
