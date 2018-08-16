package uk.co.davidatkins.spikes.euler;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem1 {

    /**
     * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
     *
     * Find the sum of all the multiples of 3 or 5 below 1000.
     */
    @Test
    public void problem1() {

        int sum = IntStream.range(0,1000)
                .filter(i -> ((i % 3 == 0) || (i % 5 == 0)))
                .sum();

        System.out.println(sum);

        List<Object> ints = IntStream.range(0,1000)
                .filter(i -> ((i % 3 == 0) || (i % 5 == 0)))
                .boxed()
                .collect(Collectors.toList());

        System.out.println(ints);

    }

}
