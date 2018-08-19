package uk.co.davidatkins.spikes;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KarprekersConstant {

    /**
     * Using the Java language, have the function KaprekarsConstant(num) take the num parameter being passed which will
     * be a 4-digit number with at least two distinct digits. Your program should perform the following routine on the
     * number:
     *
     * Arrange the digits in descending order and in ascending order (adding zeroes to fit it to a 4-digit number),
     *
     * Subtract the smaller number from the bigger number.
     *
     * Then repeat the previous step. Performing this routine
     * will always cause you to reach a fixed number: 6174.
     *
     * Then performing the routine on 6174 will always give you
     * 6174 (7641 - 1467 = 6174). Your program should return the number of times this routine must be performed until
     * 6174 is reached.
     *
     * For example: if num is 3524 your program should return 3 because of the following steps:
     * (1) 5432 - 2345 = 3087, (2) 8730 - 0378 = 8352, (3) 8532 - 2358 = 6174.
     */
    @Test
    public void kaprekersConstantTest() {

        assertEquals(1,kaprekersConstant(6174,1));
        assertEquals(3,kaprekersConstant(3542,1));
        assertEquals(7,kaprekersConstant(9831,1));

    }

    private int kaprekersConstant(int input, int iterationCount) {

        String inputString = rightPadZeros(Integer.toString(input),4);

        int inputAsc = Integer.parseInt(sortString(inputString));
        int inputDesc = Integer.parseInt(reverseString(sortString(inputString)));

        int subtracted = inputAsc > inputDesc ? inputAsc - inputDesc : inputDesc - inputAsc;

        if(subtracted == 6174) {
            return iterationCount;
        } else {
            return kaprekersConstant(subtracted,iterationCount + 1);
        }

    }

    private String sortString(String input) {
        char[] inputChars = input.toCharArray();
        Arrays.sort(inputChars);
        return new String(inputChars);
    }

    private String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    private String rightPadZeros(String input, int padding) {
        return String.format("%-" + padding + "s",input).replace(' ','0');
    }

}
