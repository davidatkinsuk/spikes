package uk.co.davidatkins.spikes;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lamdbas {

    /**
     * Square all numbers, add 10 and exclude any that end with a 5 or 6
     *
     * @param nums
     * @return
     */
    public List<Integer> square56(List<Integer> nums) {

        Map<Boolean,List<Integer>> squares = nums
                .stream()
                .map(i -> i * i)
                .map(i -> i + 10)
                .collect(Collectors.partitioningBy(i -> ("" + i).matches("^.*[56]$")));

        return squares.get(Boolean.FALSE);

    }

}
