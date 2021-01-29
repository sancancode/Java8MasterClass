package streams.iterate;

import java.util.ArrayList;
import java.util.stream.Stream;

public class IterateCLazz {


    public static void main(String[] args) {

        Class<?> clzz = ArrayList.class;

        Stream.<Class<?>>iterate(clzz, c->c!=null,c->c.getSuperclass()).forEach(e-> System.out.println(e));
    }
}
