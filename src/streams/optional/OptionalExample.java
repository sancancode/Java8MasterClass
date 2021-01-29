package streams.optional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalExample {


    public static void main(String[] args) {



        //Get Strings from optional list
        List<Optional<String>> list = List.of(Optional.of("Steve"),Optional.of("Bob"),
                                        Optional.of("Kathy"),Optional.empty());


        //normal way
        List<String> listS = list.stream().map(e->e.isPresent()?e.get():null).collect(Collectors.toList());
        listS.forEach(e-> System.out.println(e));

        System.out.println("--------");
        //stream with flatmap
        listS = list.stream().flatMap(e->e.isPresent()?Stream.of(e.get()):Stream.empty()).collect(Collectors.toList());
        listS.forEach(e-> System.out.println(e));
        System.out.println("-----");

        //stream with java 9 optioanl stream
        listS = list.stream().flatMap(e->e.stream()).collect(Collectors.toList());
        listS.forEach(e-> System.out.println(e));


        System.out.println("-----");
        //normal way with Stream list
        List<Stream> listStream = list.stream().map(e->e.isPresent()?Stream.of(e.get()):Stream.empty()).collect(Collectors.toList());
        listStream.stream().flatMap(e->e).forEach(e-> System.out.println(e));
        System.out.println("---------");

    }






}
