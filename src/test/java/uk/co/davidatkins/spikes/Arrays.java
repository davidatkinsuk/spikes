package uk.co.davidatkins.spikes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Arrays {

    @Test
    public void largestSpanTest() {

        assertEquals(4,maxSpan(new int[]{1, 2, 1, 1, 3}));
        assertEquals(6,maxSpan(new int[]{1, 4, 2, 1, 4, 1, 4}));
        assertEquals(0,maxSpan(new int[]{}));

    }

    public int maxSpan(int[] nums) {

        int largestSpan = 0;

        for(int i = 0; i < nums.length; i++) {

            int numOfInterest = nums[i];

            for(int j = nums.length - 1; j >= i; j--) {

                if(numOfInterest != nums[j]) {
                    continue;
                }

                // change to 1 based, as test requires that
                int currentSpan = j - i + 1;

                if(largestSpan < currentSpan) {
                    largestSpan = currentSpan;
                }

            }

        }

        return largestSpan;

    }




}
