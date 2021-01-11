package streams.groupingby;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class TestCollector {


//count
public static void main(String[] args) {
    Author a1 = new Author();
    List<Author> listA = List.of(a1);
    a1.setName("Dan Brown");
    Article art1 = new Article();
    art1.setArticleType("video");
    art1.setInceptionYear(2000);
    art1.setTitle("Hero");
    art1.setAuthors(listA);



    Author a2 = new Author();
    List<Author> listA1 = List.of(a2);
    a2.setName("Dan Brown");
    Article art2 = new Article();
    art2.setArticleType("video");
    art2.setInceptionYear(2001);
    art2.setTitle("Hero");
    art2.setAuthors(listA1);

    List<Article> listArt = List.of(art1, art2);

//count
    System.out.println(listArt.stream().count());
//count using collector
    System.out.println(listArt.stream().collect(Collectors.counting()));

    //min
    System.out.println(listArt.stream().min(Comparator.comparing(e->e.getInceptionYear())).get().getTitle());

    //min using collector
    System.out.println(listArt.stream().collect(Collectors.minBy(Comparator.comparing(Article::getInceptionYear))).get().getTitle());//   min(Comparator.comparing(e->e.getInceptionYear())).get().getTitle());

    //stats
    IntSummaryStatistics stats = listArt.stream().mapToInt(e->e.getInceptionYear()).summaryStatistics();
    System.out.println(stats.getMax() + " max");
    System.out.println(stats.getMin() + " min");

    //joining

    System.out.println(listArt.stream().map(e->e.getTitle()).collect(joining(", ")));
    System.out.println(listArt.stream().map(e->e.getTitle()).collect(Collectors.joining(",","[","]")));

    //articles list per year
    System.out.println(listArt.stream().collect(groupingBy(e->e.getInceptionYear())));

    //articles per year
    System.out.println(listArt.stream().collect(groupingBy(e->e.getInceptionYear(), counting())));

    //max number of articles per year
    System.out.println(listArt.stream().collect(groupingBy(e->e.getInceptionYear(), counting()))
            .entrySet().stream().max((e1,e2)->e1.getValue().compareTo(e2.getValue())).get());

    //number of articles per author

    System.out.println(listArt.stream().flatMap(e->e.getAuthors().stream()).collect(toList()).stream()
            .collect(groupingBy(Author::getName,counting())));

    //number of articles per author to Int

    System.out.println(listArt.stream().flatMap(e->e.getAuthors().stream()).collect(toList()).stream()
            .collect(groupingBy(Author::getName, collectingAndThen(counting(),e->e.intValue()))));


    //Author with most articles
    System.out.println(listArt.stream().flatMap(e->e.getAuthors().stream()).collect(groupingBy(e->e,counting()))
                       .entrySet().stream().max(Comparator.comparing(e->e.getValue())).get());

}


}
