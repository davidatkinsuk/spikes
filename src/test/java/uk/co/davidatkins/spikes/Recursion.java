package uk.co.davidatkins.spikes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    /**
     * Given an array of ints, is it possible to divide the ints into two groups, so that the sum of one group
     * is a multiple of 10, and the sum of the other group is odd. Every int must be in one group or the other.
     *
     * Write a recursive helper method that takes whatever arguments you like, and make the initial call to your
     * recursive helper from splitOdd10(). (No loops needed.)
     */
    @Test
    public void splitOdd10Test() {
        assertTrue(splitOdd10(new int[]{1}));
    }

    public boolean splitOdd10(int[] nums) {
        return splitOdd(Arrays.stream(nums).boxed().collect(Collectors.toList()), 0,0);
    }

    private boolean splitOdd(List<Integer> values, int mult10Start, int multi10End) {

        System.out.println(mult10Start + "," + multi10End + ". List size is " + values.size());

        if(mult10Start > multi10End || mult10Start == values.size() || multi10End == values.size()) {
            return false;
        }

        // i'd like to think of a smarter way of doing this
        // could pass indices to functions that check if multi10 or odd
        List<Integer> multi10 = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for(int i = 0; i < values.size(); i++) {
            if(i >= mult10Start && i < multi10End) {
                multi10.add(values.get(i));
            } else {
                odd.add(values.get(i));
            }
        }

        if(sumMult10(multi10) && sumOdd(odd)) {
            return true;
        }

        if(splitOdd(values,mult10Start + 1,multi10End)) {
            return true;
        }

        return splitOdd(values,mult10Start,multi10End + 1);

    }

    private boolean sumMult10(List<Integer> list) {
        return list
                .stream()
                .reduce(0,Integer::sum) % 10 == 0;
    }

    private boolean sumOdd(List<Integer> list) {
        return list
                .stream()
                .reduce(0, (a,b) -> a + b) % 2 != 0;
    }

}
