package streams.reduceandcollect;

import java.util.List;
import static java.util.stream.Collectors.*;

public class Practise {
	
	
	private List<Person> populateData() {
		return  List.of(new Person("name1", "India"), new Person("name2", "Brazil"), new Person("name3", "canada"),new Person("name4", "US"));
		
		
	}
	
	
	public static void main(String[] args) {
		
		List<Person> list = new Practise().populateData();
		System.out.println("Obtains US and nonUS based persons");
		System.out.println(list.stream().collect(groupingBy(e->e.getCountry().equals("US"))));
		System.out.println(list.stream().collect(partitioningBy(e->e.getCountry().equals("US"))));
		System.out.println(list.stream().collect(groupingBy(e->{
			if(e.getCountry().equals("US"))
				return "US";
			else
				return "Non US";
			
		})));
		
		
		
		System.out.println("Count US and nonUS based persons");	
		System.out.println(list.stream().collect(groupingBy(e->{
			if(e.getCountry().equals("US"))
				return "US";
			else
				return "Non US";
			
		}, counting())));
	
		System.out.println(list.stream().collect(partitioningBy(e->e.getCountry().equals("US"), counting())));
	
		
		
		System.out.println("obtain  persons in each country and count them by group");			
		System.out.println(list.stream().collect(groupingBy(e->e.getCountry(), counting())));
		

		System.out.println("obtain  US and nonUS based person using partiongby & map names to upper case");
		System.out.println(list.stream().collect(partitioningBy(e->e.getCountry().equals("US"),mapping(e->e.getName().toUpperCase(), toList()) )));

		
		System.out.println("obtain  US and nonUS based person using groupingby & map names to upper case");
		System.out.println(list.stream().collect(groupingBy(e->{
			
			return e.getCountry().equals("US")?"US":"NonUS";
			
		}, toList())));
		
	}
	
	
	
	

}
