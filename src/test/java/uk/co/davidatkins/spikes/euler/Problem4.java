package uk.co.davidatkins.spikes.euler;

import org.junit.jupiter.api.Test;

public class Problem4 {

    private int largestPalendrom = 0;

    @Test
    public void problem4() {

        for(int i = 0 ; i < 1000; i++) {

            for(int j = 0 ; j < 1000; j++) {

                if(isPalendrome(i * j)) {
                    if(largestPalendrom < i * j) {
                        largestPalendrom = i * j;
                    }
                }

            }

        }

        System.out.println(largestPalendrom);

    }

    private boolean isPalendrome(int number) {

        String asString = Integer.toString(number);

        for(int i = 0; i < asString.length() / 2; i++) {

            if(asString.charAt(i) != asString.charAt(asString.length() - 1 - i)) {
                return false;
            }

        }

        return true;

    }

}
