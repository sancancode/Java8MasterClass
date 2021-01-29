package streams.iterate;

import java.util.stream.Stream;

public class IterateNumbers {


    public static void main(String[] args) {


        //print till 100
        Stream.iterate(1, n->n+1).limit(100).forEach(e-> System.out.print(e + "\t"));


        System.out.println("----------");
        //print till 100 using has next
        Stream.iterate(1,n->n<=100,  n->n+1).forEach(e-> System.out.print(e +"\t"));


        System.out.println("----------");
        System.out.println("using take while");
        //print till 100 using take while
        Stream.iterate(1,  n->n+1).takeWhile(e->e<=100).forEach(e-> System.out.print(e +"\t"));

        System.out.println("----------");
        System.out.println("using drop while");
        //print till 51-100 using drop while
        Stream.iterate(1,  n->n+1).limit(100).dropWhile(e->e<=50).forEach(e-> System.out.print(e +"\t"));

        System.out.println("----------");
        //print even numbers 0 to 100 - not very good approach
        Stream.iterate(1,n->n+1).filter(n->n%2==0).limit(50).forEach(e-> System.out.print(e +"\t"));


        System.out.println("----------###");
        //print fibonacci
        Stream.iterate(new int[]{0,1},n->new int[]{n[1],n[0]+n[1]}).limit(5).forEach(e-> System.out.print(e[0] +"\t"));


        System.out.println("----------###");
        //sum of  fibonacci series  - each cycle
        Stream.iterate(new int[]{0,1,0},n->new int[]{n[1],n[0]+n[1], n[2]+n[1]}).limit(5).forEach(e-> System.out.print(e[2] +"\t"));



        System.out.println("----------###");
        //sum of  all fibonacci
        int sum =  Stream.iterate(new int[]{0,1},n->new int[]{n[1],n[0]+n[1]}).limit(6).mapToInt(e->e[0]).sum();
        System.out.println(sum + " sum fibonacci");

    }



}
