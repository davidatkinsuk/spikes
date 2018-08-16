package uk.co.davidatkins.spikes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MathChallenges {

    @Test
    public void makeBricksTest() {

        assertTrue(makeBricks(3, 1, 8));
        assertFalse(makeBricks(3, 1, 9));
        assertTrue(makeBricks(3, 2, 10));

    }

    public boolean makeBricks(int small, int big, int goal) {

        var SMALL_BRICK_SIZE = 1;
        var smallBrickTotalSize = small * SMALL_BRICK_SIZE;

        var BIG_BRICK_SIZE = 5;
        var bigBrickTotalSize = big * BIG_BRICK_SIZE;

        var maxBigUsable = Math.floorDiv(goal,BIG_BRICK_SIZE);

        if(big >= maxBigUsable) {
            // we have enough big, but need to complete with small
            return smallBrickTotalSize >= goal - (maxBigUsable * BIG_BRICK_SIZE);
        } else {
            // don't have enough big, may be able to complete with small
            return smallBrickTotalSize >= goal - bigBrickTotalSize;
        }

    }


}
