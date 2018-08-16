package uk.co.davidatkins.spikes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Recursion {

    @Test
    public void groupSumTest() {

        assertTrue(groupSum(0, new int[]{2, 4, 8}, 10));
        assertTrue(groupSum(0, new int[]{2, 4, 8}, 14));
        assertFalse(groupSum(0, new int[]{2, 4, 8}, 9));

    }

    public boolean groupSum(int start, int[] nums, int target) {

        // this doesn't work if numbers adding to target aren't in a sequence

        // we've met the target
        if(target == 0) {
            return true;
        }

        // exceeded the array length
        if(start >= nums.length) {
            return false;
        }

        if (groupSum(start + 1, nums, target - nums[start])) {
            return true;
        }

        // skip this number
        return groupSum(start + 1, nums, target);

    }

}
