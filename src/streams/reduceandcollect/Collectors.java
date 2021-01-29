package streams.reduceandcollect;

import java.util.*;
import java.util.stream.Stream;

public class Collectors {
	
	
	static class Product{  
	    int id;  
	    String name;  
	    float price;  
	      
	    public Product(int id, String name, float price) {  
	        this.id = id;  
	        this.name = name;  
	        this.price = price;  
	    }  
	}  
	
	
	private static void groupingBy() {

		
		
		List<String> names =
		          Arrays.asList("Jon", "Ajeet", "Steve",
		             "Ajeet", "Jon", "Ajeet");

		
          Map<String, Long>	map123 =	names.stream().collect(java.util.stream.Collectors.groupingBy(e->"Ajeet", java.util.stream.Collectors.counting()));
		
		map123.entrySet().stream().forEach(e->System.out.println(e.getKey() + " key    " + e.getValue() + " value"));
		
		
		
		
		//Set of price
		List<Product> productsList = new ArrayList<Product>();  
        //Adding Products  
        productsList.add(new Product(1,"HP Laptop",25000f));  
        productsList.add(new Product(2,"Dell Laptop",30000f));  
        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
        productsList.add(new Product(4,"Sony Laptop",28000f));  
		
		Set<Float> setPrice = productsList.stream().map(e->e.price).collect(java.util.stream.Collectors.toSet());
		setPrice.stream().forEach(e->System.out.println(e));
	
		
		//to linked list
		
		Collection<Float> result = productsList.stream().map(e->e.price)
				  .collect(java.util.stream.Collectors.toCollection(()->new LinkedList<Float>()));
		
		System.out.println("Linked list ");
		result.stream().forEach(e->System.out.println(e));
		
		
		//adding all prices
		
		Float d = productsList.stream().map(e->e.price).reduce((sum, a)->(sum+a)).get();
		System.out.println(d + " float sum");
		
		
	//	int id = productsList.stream().map(e->e.id).;
		//System.out.println(d + " float sum");
		
		
		//adding prices using collecor
				Double dd = productsList.stream().map(e->e.price).collect(java.util.stream.Collectors.summingDouble(e->e));
				System.out.println(dd);
				
		
		//avg prices using collecor
		Double ddd = productsList.stream().map(e->e.price).collect(java.util.stream.Collectors.averagingDouble(e->e));
		System.out.println(ddd);
		
		
		Float ddf = productsList.stream().map(e->e.price).collect(java.util.stream.Collectors.maxBy(Comparator.comparingDouble(e->e))).get();
		System.out.println(ddf);	
		
		Float ddff = productsList.stream().map(e->e.price).collect(java.util.stream.Collectors.minBy(Comparator.comparingDouble(e->e))).get();
		System.out.println(ddff);	
		
		///counting elements
		Long count = productsList.stream().collect(java.util.stream.Collectors.counting());
		
		System.out.println(count);
		
		
		
		
		
		//String collectors
		
		List<String> list = Arrays.asList("abc","bcd", "cdeee");
		
		String s = list.stream().collect(java.util.stream.Collectors.maxBy((e1,e2)->e1.length()-e2.length())).get();
		System.out.println(s);
		
		s = list.stream().collect(java.util.stream.Collectors.minBy((e1,e2)->e2.length()-e1.length())).get();
		System.out.println(s);
		
	
		
		//groupingby
		

		
          Map<String, Long>	map =	names.stream().collect(java.util.stream.Collectors.groupingBy(e->e, java.util.stream.Collectors.counting()));
		
		map.entrySet().stream().forEach(e->System.out.println(e.getKey() + " key    " + e.getValue() + " value"));
		
	
		
		//tomap
		Map<String, String> map1 = Stream.of("a", "b", "c")
				.collect(java.util.stream.Collectors.toMap(e->e, e->e.toUpperCase()));
		System.out.println(map1);
		
		
		Map<String, String> mapDD = Stream.of("a", "b", "c", "b", "a")
				.collect(java.util.stream.Collectors.toMap(e->e,String::toUpperCase, String::concat));
		System.out.println(mapDD);
		
		
		
		Map<String, String> mapD = Stream.of("a", "b", "c", "b", "a")
				.collect(java.util.stream.Collectors.toMap(e->e,String::toUpperCase, String::concat, TreeMap::new));
		System.out.println(mapD);
		
		
		
		List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");
		
		Map<String, Integer> mapDDD = items.stream().collect(java.util.stream.Collectors.toMap(e->e, e->1, (e1,e2)->(e1+e2)));
		System.out.println(mapDDD);
		
		Map<Object, Object> mapDDDD= mapDDD.entrySet().stream().
									sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
									collect(java.util.stream.Collectors.
											toMap(Map.Entry::getKey,
													Map.Entry::getValue, (old, newV)->old,
													()->new LinkedHashMap<Object, Object>()));
	
		System.out.println(mapDDDD);	
		
		Map<String, List<Product>> mapE = productsList.stream().collect(java.util.stream.Collectors.groupingBy(e->e.name)); 
		
		System.out.println(mapE);
		
		//t means (Map.Entry<K, V> e) -> e.getKey() where K is the type of the keys and V the type of the values of the Map<K, V> – Lino 23 mins ago 		
		
	
		
		List<String> amex =
                Arrays.asList("Aplha", "Beta", "Gamma","Delta", "Epsilon");
	
		System.out.println(amex.stream().collect(java.util.stream.Collectors.minBy((e1,e2)->(e1.length()-e2.length()) )));
		
		System.out.println(amex.stream().collect(java.util.stream.Collectors.minBy(Comparator.comparing(e->e.length()) )));
		
		System.out.println(amex.stream().reduce((e1,e2)-> e1.length()<e2.length()?e1:e2 ));
		
		System.out.println(amex.stream().reduce((e1,e2)-> e1.length()>e2.length()?e1:e2 ));
	
		
		List<Integer> amexInt =
                Arrays.asList(1, 2, 3);
		
		System.out.println(amexInt.stream().reduce((e1,e2)-> e1<e2?e1:e2 ));
		
		List<String> letters = Arrays.asList("a","bb","ccc");
		String result123 = letters
		  .stream()
		  .reduce((partialString, element) -> partialString.length()< element.length()?partialString:element).get();	
		System.out.println(result123);
	
	Stream<String> streamString = Stream.of("aaa","bbb", "ccc");
	
	streamString.forEach(e->System.out.println(e));
	}
	
	
	
	public static void main(String[] args) {
		
		groupingBy();
	}

}
