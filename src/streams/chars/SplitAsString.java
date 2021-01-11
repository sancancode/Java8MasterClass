package streams.chars;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class SplitAsString {

    public static void main(String[] args) {

        String test = "the quick brown fox jumps over the lazy dog";
        IntSummaryStatistics stats = test.chars().summaryStatistics();
        System.out.println(stats.getMin());
        System.out.println(stats.getMax());


        List<String>  listStr = test.chars()
                                .mapToObj(c->Character.toString(c))
                                .filter(c->!c.isBlank())
                                .distinct()
                                .sorted()
                                .collect(Collectors.toList());
        System.out.println(listStr);
    }
}
