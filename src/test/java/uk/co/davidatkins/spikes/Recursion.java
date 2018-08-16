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

    @Test
    public void groupSumMustIncludeDiv5Exclude1After5Test() {

        assertTrue(groupSumAdvanced(0, new int[]{2, 5, 10, 4}, 17));

    }


    public boolean groupSumAdvanced(int start, int[] nums, int target) {

        System.out.println("Start is " + start + " target is " + target);

        // got to the end
        if(start == nums.length) {
            return target == 0;
        }

        int previousNumber = start == 0 ? 1 : nums[start-1];
        int thisNumber = nums[start];

        boolean shouldIgnore = previousNumber % 5 == 0 && thisNumber == 1;
        boolean cannotIgnore = thisNumber % 5 == 0;

        if(cannotIgnore) {

            return groupSumAdvanced(start + 1, nums, target - nums[start]);

        } else {

            if (target != 0 && !shouldIgnore && groupSumAdvanced(start + 1, nums, target - nums[start])) {
                return true;
            }

            // try without this number
            return groupSumAdvanced(start + 1, nums, target);

        }

    }

}
