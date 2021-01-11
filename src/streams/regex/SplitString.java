package streams.regex;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class SplitString {

    public static void main(String[] args) {

        String test = "the quick brown fox jumps over the lazy dog";
        System.out.println(Arrays.stream(test.split(" ")).count());


        //no of words
        Pattern p = Pattern.compile(" ");
        try (Stream<String> streamStr = p.splitAsStream(test)) {
            System.out.println(streamStr.count());
        }

    }
}



