package streams.reduceandcollect;


import java.util.List;

public class ReduceVsCollect {


    public static void main(String[] args) {


        List<String> list = List.of("abc", "abc1", "abc2", "abc3", "abc4", "abc5");


        //reduce
        String result = list.stream().reduce((s1, s2) -> {
            System.out.println(s1 + " result ");
            return s1 + s2;
        }).get();
        System.out.println(result);


        //reduce
        String result1 = list.parallelStream().reduce("", (s1, s2) ->

                {
                    System.out.println(s1 + " resulrt1");

                    return s1 + s2;
                }

        );
        System.out.println(result1);

        //reduce
        String result11 = list.stream().reduce("", (s1, s2) -> s1 + s2, (s1, s2) -> s1 + s2);
        System.out.println(result11);


        List<Integer> listInt = List.of(1, 2, 3, 4, 5, 6, 7);
        int max = listInt.stream().reduce(0, (e1, e2) -> (e1 > e2 ? e1 : e2));
        System.out.println(max);


        List<Integer> listInt1 = List.of();

        int maxAdd = listInt.stream().reduce((e1, e2) -> {
            System.out.println(e1 + "   add " + e2);
            return (e1 + e2);
        }).get();
        System.out.println(maxAdd + "  add");

        maxAdd = listInt1.stream().reduce((e1, e2) -> {
            System.out.println(e1 + "   add one element with no identity accumulator " + e2);
            return (e1 + e2);
        }).orElse(100);
        System.out.println(maxAdd + "  add one element with no identity");


        maxAdd = listInt1.stream().reduce(0, (e1, e2) -> {
            System.out.println(e1 + "   add one element with identity accumulator" + e2);
            return (e1 + e2);
        });
        System.out.println(maxAdd + "  add one element with identity");


        int maxAdd1 = listInt.stream().reduce(0, (e1, e2) -> {
            System.out.println(e1 + "   add1   " + e2);
            return (e1 + e2);
        });
        System.out.println(maxAdd1 + "  add1");


        int maxPr = listInt.stream().reduce((e1, e2) -> (e1 * e2)).get();
        System.out.println(maxPr + "  pr");


        int maxPr1 = listInt.stream().reduce(1, (e1, e2) -> {
            System.out.println(e1 + "     pr1");
            return (e1 * e2);
        });
        System.out.println(maxPr1 + "  pr1");


        int length = list.stream()
                .reduce(1, (accumulatedInt, str) -> {
                            System.out.println(accumulatedInt + " syso");
                            return accumulatedInt + str.length();
                        },
                        (accumulatedInt, accumulatedInt2) -> accumulatedInt + accumulatedInt2);
        System.out.println(length);
        //listInt.stream().max(comparator)


        int lengthp = list.parallelStream()
                .reduce(1, (accumulatedInt, str) -> {
                            System.out.println(accumulatedInt + " syso");
                            return accumulatedInt + str.length();
                        },
                        (accumulatedInt, accumulatedInt2) -> accumulatedInt + accumulatedInt2);
        System.out.println(lengthp);


        //collect
        String res = list.stream().collect(() -> new StringBuilder(), (StringBuilder e1, String e2) -> e1.append(e2),
                (e1, e2) -> e1.append(e2)).toString();
        System.out.println(res);


        String res1 = list.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        System.out.println(res1);
    }
}