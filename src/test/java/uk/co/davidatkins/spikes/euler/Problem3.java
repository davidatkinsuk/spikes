package uk.co.davidatkins.spikes.euler;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Problem3 {

    private Set<Long> primes = new TreeSet<>();
    private Set<Long> factors = new TreeSet<>();

    public boolean isPrime(long number) {

        // primes we've already determined
        if(primes.contains(number)) {
            return true;
        }

        // attempt to divide by primes
        for(Long prime : primes) {
            if(number % prime == 0) {
                return false;
            }
        }

        primes.add(number);
        return true;

    }

    /**
     * I found this strategy to determine factors on the internet
     *
     * We build up a list of primes as we go
     *
     * @param number
     * @return
     */
    public long reduce(long number) {

        // find smallest prime number we can divide by
        for(long i = 2; i < number; i++) {

            if(isPrime(i)) {

                if(number % i == 0) {
                    long reduced = number / i;
                    factors.add(i);
                    System.out.println("Div by " + i + " to reduce to " + reduced);
                    return reduced;
                }

            }

        }

        factors.add(number);
        throw new IllegalStateException("can't reduce anymore at number " + number);

    }

    /**
     * The prime factors of 13195 are 5, 7, 13 and 29.
     *
     * What is the largest prime factor of the number 600851475143 ?
     */
    @Test
    public void problem3() {

        primes.add(2L);

        try {
            long reduced = 600851475143L;
            while (true) {
                reduced = reduce(reduced);
            }
        } catch(IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Factors are " + factors);

    }

}
