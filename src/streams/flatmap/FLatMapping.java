package streams.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;

public class FLatMapping {

    class Person{

        Person(String name, int age){

            this.name = name;
            this.age = age;
        }

        String name;
        int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }


    private List<Person> createPeople(){

        List<Person> list = List.of(new Person("Rob", 1),new Person("Robert", 2),new Person("Dan", 2),new Person("Siri", 3));
        return list;
    }


    public static void main(String[] args) {

        List<Person> list = new FLatMapping().createPeople();
        List<Integer> listInt = List.of(1,2,3);
        System.out.println(listInt.stream().map(e->List.of(e-1,e+1)).collect(Collectors.toList()));

        System.out.println(listInt.stream().flatMap(e->List.of(e-1,e+1).stream()).collect(Collectors.toList()));


        //age and list of characters
        System.out.println(list.stream().collect(Collectors.groupingBy(e->e.getAge(),
                Collectors.flatMapping(e-> Arrays.stream(e.getName().split("")), toList()))));

        //age and list of unique characters

        System.out.println(list.stream().collect(groupingBy(e->e.getAge(),
                flatMapping(e->Arrays.stream(e.getName().split("")), toSet()))));
    }


}

