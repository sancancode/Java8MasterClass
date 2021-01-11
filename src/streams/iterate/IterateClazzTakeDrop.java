package streams.iterate;

import java.util.ArrayList;
import java.util.stream.Stream;

public class IterateClazzTakeDrop {


    public static void main(String[] args) {
        Class<?> clzz = ArrayList.class;
        clzz.getSuperclass();
        Stream.<Class<?>>iterate(clzz, c->c.getSuperclass())
                .takeWhile(c->c!=null)
                .forEach(e-> System.out.println(e));
    }
}
