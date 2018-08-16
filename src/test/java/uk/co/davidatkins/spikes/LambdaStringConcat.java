package uk.co.davidatkins.spikes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LambdaStringConcat {

    @Test
    public void concatArbitraryStrings() {

        // https://stackoverflow.com/questions/31456898/convert-a-for-loop-to-concat-string-into-a-lambda-expression
        List<String> list = new ArrayList<>();
        list.add("foo");
        list.add("bar");
        list.add("baz");
        String result = list
                .stream()
                .collect(Collectors.joining());

        assertEquals("foobarbaz",result);

    }

    @Test
    public void contactSameStringMultipleTimesVersion1() {

        // https://stackoverflow.com/questions/28080703/using-a-stream-to-iterate-n-times-instead-of-using-a-for-loop-to-create-n-items
        String result = Collections.nCopies(3,"hello")
                .stream()
                .collect(Collectors.joining());

        assertEquals("hellohellohello",result);

    }


    @Test
    public void contactSameStringMultipleTimesVersion2() {

        // https://stackoverflow.com/questions/28080703/using-a-stream-to-iterate-n-times-instead-of-using-a-for-loop-to-create-n-items
        String result = IntStream.range(0,3)
                // now to mapToObj here to change type
                .mapToObj(i -> "hello")
                .collect(Collectors.joining());

        assertEquals("hellohellohello",result);

    }

}
