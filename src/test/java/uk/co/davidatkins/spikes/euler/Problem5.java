package uk.co.davidatkins.spikes.euler;

import org.junit.jupiter.api.Test;

public class Problem5 {

    /**
     * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
     *
     * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
     */
    // takes 324ms
    @Test
    public void problem5BruteForce() {

        for(int i = 20; true; i++) {

            boolean divByAll = true;
            for(int div = 1; div <= 20; div++) {

                if(i % div != 0) {
                    divByAll = false;
                    break;
                }

            }

            if(divByAll) {
                System.out.println(i);
                break;
            }

        }

    }

    /**
     * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
     *
     * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
     */
    // Takes 105ms
    @Test
    public void problem5BruteForceMoreEfficient() {

        // this approach we only consider multiples of 20
        for(int i = 20; true; i += 20) {

            boolean divByAll = true;
            // consider less likely cases first
            for(int div = 20; div > 0; div--) {

                if(i % div != 0) {
                    divByAll = false;
                    break;
                }

            }

            if(divByAll) {
                System.out.println(i);
                break;
            }

        }

    }

}
