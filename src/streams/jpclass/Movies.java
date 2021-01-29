package streams.jpclass;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import static java.util.stream.Collectors.*;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import java.util.stream.Stream;



public class Movies {
	
	
	
	public static void main(String[] args)  throws Exception{
		
		
		Set<Movie> movies = new HashSet<>() ;

        Stream<String> lines = 
            Files.lines(
                Paths.get("files", "movies.txt"), 
                Charset.forName("windows-1252")
            ) ;
        
        
        lines.forEach(
                (String line) -> {
                    String[] elements = line.split("/") ;
                    String title = elements[0].substring(0, elements[0].toString().lastIndexOf("(")).trim() ;
                    String releaseYear = elements[0].substring(elements[0].toString().lastIndexOf("(") + 1, elements[0].toString().lastIndexOf(")")) ;
            
                    if (releaseYear.contains(",")) {
                        // Movies with a coma in their title are discarded
                        return ;
                    }
            
                    Movie movie = new Movie(title, Integer.valueOf(releaseYear)) ;
            
                    for (int i = 1 ; i < elements.length ; i++) {
                        String [] name = elements[i].split(", ") ;
                        String lastName = name[0].trim() ;
                        String firstName = "" ;
                        if (name.length > 1) {
                            firstName = name[1].trim() ;
                        }

                        Actor actor = new Actor(lastName, firstName) ;
                        movie.addActor(actor) ;
                    }
            
                    movies.add(movie) ;
                }
        ) ;
        
        
        System.out.println(movies);
	
	
        
        Set<Actor> actors = movies.stream().flatMap(e->e.actors().stream()).collect(Collectors.toSet());
        
        System.out.println("# actors = " + actors.size()) ;
        System.out.println("# movies = " + movies.size()) ;
	
	    Set<Integer> releaseYears = movies.stream().map(Movie::releaseYear).collect(Collectors.toSet());
	
	    System.out.println("# of realease years " +  releaseYears.size());
	    
	    
	    System.out.println("max release year " + releaseYears.stream().max(Comparator.naturalOrder()).orElseGet(()->0));
	  
	    
	    System.out.println("min release year " + releaseYears.stream().min(Comparator.naturalOrder()).orElseGet(()->0));
		  
	    

        // Movie in which the greatest number of actors have played
	    
	    
	    Movie max = movies.stream().max((e1,e2)-> Integer.compare(e1.actors().size(), e2.actors().size())).get();
	    
	    System.out.println("movie with max actors " + max.title() + " " +max.actors().size());
	    
	    
	    //Year with the greatest number of movies released
	    
	  Entry<Integer, Long> releaseYear =   movies.stream().
			  									collect(Collectors.groupingBy(e->e.releaseYear(),
			  									Collectors.counting())).entrySet().stream().max(Entry.comparingByValue()).get();
	    	
	  System.out.println(releaseYear);
	    		//new TreeMap(Map.Entry.comparingByValue()),Collectors.counting()));
	    
	  
	  
	  Map<Actor, Long> map = movies.stream().flatMap(e->e.actors().stream()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	  System.out.println(map);
	  
      // Actor that played in the greatest number of movies
	 Entry<Actor, Long> entry = movies.stream().flatMap(e->e.actors().stream()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
	  .max(Entry.comparingByValue()).get();
	  
	 System.out.println(entry);
	  
	  
	 

     // Actor that played in the greatest number of movies during a year
	 
	 movies.stream().collect(toMap(e->e, e->e.actors()));
	
	/*
	 * map1.entrySet().stream(). collect(groupingBy(e->e,
	 * groupingBy(e->e.getValue().stream()));
	 */ 
	
	
	 
	 Entry<Integer, Entry<Actor, AtomicLong>> entry4 =
     		movies.stream()
             .collect(
                     Collectors.groupingBy(
                             movie -> movie.releaseYear(), 
                             // Collector<? super T, A, D>
                             Collector.of(
                                     () -> new HashMap<Actor, AtomicLong>(), 
                                     (map1234, movie) -> {
                                         movie.actors().forEach(
                                                 actor -> map1234.computeIfAbsent(actor, a -> new AtomicLong()).incrementAndGet()
                                         ) ;
                                     },
                                     (map1, map2) -> {
                                         map2.entrySet().stream().forEach(
                                                 entry123 -> map1.computeIfAbsent(entry.getKey(), a -> new AtomicLong()).addAndGet(entry123.getValue().get())
                                         ) ;
                                         return map1 ;
                                     }, 
                                     new Collector.Characteristics [] {
                                         Collector.Characteristics.CONCURRENT.CONCURRENT
                                     }
                             )
                     )
             )
             .entrySet()
             .stream()
             .collect(
                     Collectors.toMap(
                             entry5 -> entry5.getKey(),
                             entry5 -> entry5.getValue()
                                                 .entrySet()
                                                 .stream()
                                                 .max(Entry.comparingByValue(Comparator.comparing(l -> l.get())))
                                                 .get()
                     )
             )
             .entrySet()
             .stream()
             .max(Comparator.comparing(entry1234 -> entry1234.getValue().getValue().get()))
             .get() ;
	 
			
	    
	}

}
