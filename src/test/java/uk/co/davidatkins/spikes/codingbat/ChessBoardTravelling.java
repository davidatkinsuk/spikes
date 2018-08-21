package uk.co.davidatkins.spikes.codingbat;

import lombok.NonNull;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChessBoardTravelling {

    /**
     * Using the Java language, have the function ChessboardTraveling(str) read str which will be a string consisting
     * of the location of a space on a standard 8x8 chess board with no pieces on the board along with
     * another space on the chess board.
     *
     * The structure of str will be the following: "(x y)(a b)" where (x y) represents the position you are
     * currently on with x and y ranging from 1 to 8 and (a b) represents some other space on the chess board
     * with a and b also ranging from 1 to 8 where a > x and b > y.
     *
     * Your program should determine how many ways there are of traveling from (x y) on the board to (a b)
     * moving only up and to the right. For example: if str is (1 1)(2 2) then your program should output 2
     * because there are only two possible ways to travel from space (1 1) on a chessboard to space (2 2)
     * while making only moves up and to the right.
     */
    @Test
    public void travelTest() {

        assertEquals(1,extractCoords("(1 1)(3 3)").get(0).x);
        assertEquals(1,extractCoords("(1 1)(3 3)").get(0).y);
        assertEquals(3,extractCoords("(1 1)(3 3)").get(1).x);
        assertEquals(3,extractCoords("(1 1)(3 3)").get(1).x);

        assertEquals(6,travel("(1 1)(3 3)"));
        assertEquals(3,travel("(2 2)(4 3)"));

    }

    public int travel(String coordsString) {

        List<Coord> coords = extractCoords(coordsString);
        return travel(coords.get(0),coords.get(1));

    }

    public int travel(Coord position, Coord target) {

        if(Objects.equals(target,position)) {
            return 1;
        }

        if(position.getX() > target.getX() || position.getY() > target.getY()) {
            return 0;
        }

        return travel(position.moveRight(),target) + travel(position.moveUp(),target);

    }


    public List<Coord> extractCoords(String coordsString) {

        List<Coord> coords = new ArrayList<>();

        Matcher m = Pattern.compile("[0-9 0-9]*").matcher(coordsString);

        while (m.find()) {

            String match  = m.group();
            if(match.length() > 0) {
                String[] coordStrings = match.split(" ");
                coords.add(
                        new Coord(
                                Integer.parseInt(coordStrings[0]),
                                Integer.parseInt(coordStrings[1])));
            }

        }

        return coords;

    }

    public static class Coord {

        public int x;

        public int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Coord moveRight() {
            return new Coord(x+1,y);
        }

        public Coord moveUp() {
            return new Coord(x,y+1);
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof Coord)) return false;
            final Coord other = (Coord) o;
            if (!other.canEqual((Object) this)) return false;
            if (this.getX() != other.getX()) return false;
            if (this.getY() != other.getY()) return false;
            return true;
        }

        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            result = result * PRIME + this.getX();
            result = result * PRIME + this.getY();
            return result;
        }

        protected boolean canEqual(Object other) {
            return other instanceof Coord;
        }

        public String toString() {
            return "ChessBoardTravelling.Coord(x=" + this.getX() + ", y=" + this.getY() + ")";
        }
    }

}
