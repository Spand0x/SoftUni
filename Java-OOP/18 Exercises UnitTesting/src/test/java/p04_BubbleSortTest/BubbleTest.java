package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BubbleTest {

    @Test
    public void shouldReturnSortedArray(){
        int[] bubbleArr = new int[] {10,1,2,3,8,4};
        int[] sortArr = new int[] {10,1,2,3,8,4};

        Arrays.sort(sortArr);

        Bubble.sort(bubbleArr);

        Assert.assertArrayEquals(sortArr,bubbleArr);
    }
}
