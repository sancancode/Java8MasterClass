package streams.refactoring;

import java.util.*;
import java.util.stream.Collectors;

public class Example1 {

	    static class Product {
	        public final String name;
	        public final String category;

	        public Product(String name, String category) {
	            this.name = name;
	            this.category = category;
	        }

	        @Override
	        public String toString() {
	            return "Product{name='" + name + '\'' + ", category='" + category + '\'' + '}';
	        }
	    }

	    public static Product winklePickers = new Product("winkle pickers", "shoes");
	    public static Product bovverBoots = new Product("bovver boots", "shoes");
	    public static Product fez = new Product("fez", "hats");
	    public static Product deerstalker = new Product("deerstalker", "hats");
	    public static Product duncesCap = new Product("dunce's cap", "hats");
	    public static Product yFronts = new Product("y-fronts", "pants");
	    public static Product boxers = new Product("boxers", "dogs");

	    public static Map<String, List<Product>> oldWay(List<Product> products) {
	        SortedMap<String, List<Product>> categories = new TreeMap<>();

	        for (Product p : products) {
	            if (categories.containsKey(p.category)) {
	                categories.get(p.category).add(p);
	            } else {
	                List<Product> categoryProducts = new ArrayList<>();
	                categoryProducts.add(p);
	                categories.put(p.category, categoryProducts);
	            }
	        }

	        return categories;
	    }
	    
	    
	    private static  Map<Object, List<Product>> java8Way(List<Product> list) {
	    	Map<Object, List<Product>> categories = new TreeMap<>();
	    	
	    	categories =	list.stream().collect(Collectors.groupingBy(e->e.category, TreeMap::new, Collectors.toList()));
	    	
	    	return categories;

		}
	    
	    
	    public static void main(String[] args) {
			
	        List<Product> products = List.of(
	                winklePickers, bovverBoots, fez, deerstalker, duncesCap, yFronts, boxers);
		
	    System.out.println(oldWay(products));
	    
	    System.out.println(java8Way(products));
	    
	    }
}
