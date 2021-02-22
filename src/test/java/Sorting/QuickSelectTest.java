package Sorting;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSelectTest {

    @Test
    public void test(){
        int[] data = {7, 10, 4, 3, 20, 15};
        int k = 3;
        int ans = QuickSelect.quickSelect(data, k);
        assertEquals(ans, 10);
    }

}