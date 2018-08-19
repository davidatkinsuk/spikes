package uk.co.davidatkins.spikes;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringSorting {

    @Test
    public void sortStringComparator() {

        String myString = "hello";
        char[] chars = myString.toCharArray();
        Arrays.sort(chars);
        System.out.println(new String(chars));

    }


    @Test
    public void sortStringBubbleSortTest() {

        assertEquals("eeggHillLnnooprrSStu",sortStringBubbleSortDoWhile("HelloSuperLongString"));

    }

    public String sortStringBubbleSortDoWhile(String myString) {

        /**
         * In bubble sort algorithm, array is traversed from first element to last element.
         * Here, current element is compared with the next element. If current element is greater than the next element,
         * it is swapped.
         */

        char[] myChars = myString.toCharArray();

        boolean swapMade = false;
        do {

            swapMade = false;
            for(int i = 0; i < myChars.length - 1; i++) {

                if(compareCharCaseInsensitive(myChars[i],myChars[i+1]) > 0) {
                    swap(myChars,i,i+1);
                    swapMade = true;

                }

            }

        } while (swapMade);

        return new String(myChars);

    }

    private void swap(char[] array, int a, int b) {
        char aValue = array[a];
        array[a] = array[b];
        array[b] = aValue;
    }

    private int compareCharCaseInsensitive(char a, char b) {
        return Character.toUpperCase(a) - Character.toUpperCase(b);
    }

}
