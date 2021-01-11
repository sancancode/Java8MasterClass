package streams.stackoverflowquestions;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//https://stackoverflow.com/questions/23038673/merging-two-mapstring-integer-with-java-8-stream-api/23040630#23040630
public class MergeMaps {


    public static void main(String[] args) {

        Map<String, Integer> map1 = Map.of("a",2,"b",3);
        Map<String, Integer> map2 = Map.of("a",3,"c",4);

/*        Map<String, Integer> map = Stream.of(map1,map2).map(e->e.entrySet()).
                collect(Collectors.toMap(e->e.getKey(), e->e.getValue(),
                Integer::max));
        System.out.println(map);*/

        Map<String, Integer> mapmerge2 =new HashMap<>(map1);

        map2.forEach((k,v)->mapmerge2.merge(k,v,Integer::max));
        System.out.println(mapmerge2);

    }


}
