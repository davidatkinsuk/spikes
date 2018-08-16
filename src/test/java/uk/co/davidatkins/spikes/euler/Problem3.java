package uk.co.davidatkins.spikes.euler;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Problem3 {

    private Set<Long> primes = new TreeSet<>();

    public Set<Long> findFactors(long number, boolean recursing) {

        Set<Long> factors = new HashSet<>();

        if(!recursing) {
           // System.out.println("Find Factors for " + number);
        }

        // attempt to divide by primes
        for(Long prime : primes) {

            if(number % prime == 0) {
                // it divides, this is a factor
                factors.add(prime);

                long result = number / prime;

                if(primes.contains(result)) {
                    // result is a prime, end of the line
                    return factors;
                } else {
                    factors.addAll(findFactors(result,true));
                    return factors;
                }

            }

        }

        if(factors.isEmpty()) {
            if(!primes.contains(number)) {
                //System.out.println(number + " is prime!");
                primes.add(number);
            }
        }

        return factors;

    }

    /**
     * This is incredibly slow, this isn't going to work. I think i need to attack
     * this starting at the large number instead of building up to it, but methods
     * i've seen assume you know what primes are. Maybe i can just try dividing starting
     * from 2 and continue up and if the division works, only then check to see if the divisor
     * is a prime number? That way we're quickly reducing the size of the headline number
     * (e.g. immediately halving it?)
     *
     * The prime factors of 13195 are 5, 7, 13 and 29.
     *
     * What is the largest prime factor of the number 600851475143 ?
     */
    @Test
    public void problem3() {

        primes.add(2L);

        for(long i = 3; i < 600851475143L; i++) {

            if(i > 851475143) {
                System.out.println("here");
            }

            findFactors(i,false);

        }


    }

}
