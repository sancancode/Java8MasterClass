package streams.groupingby;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingBy {

	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
	
	Person p1 = new Person();
	p1.setAbc(123);
	p1.setfName("fName");
	p1.setLastName("dName");

	Person p2 = new Person();
	p2.setAbc(123);
	p2.setfName("fName");
	p2.setLastName("dName");

	Person p3 = new Person();
	p3.setAbc(123);
	p3.setfName("fName");
	p3.setLastName("zlName11");
	
	Person p4 = new Person();
	p4.setAbc(1233);
	p4.setfName("fName");
	p4.setLastName("slName11");

	
	
	
	
	//Using map of streams to modfiy list and collect a new list of string
	ArrayList<String> listCaps = (ArrayList<String>) list.stream().map(e->e.getLastName().toUpperCase()).collect(Collectors.toList());		
	System.out.println("Modify to all caps :" + listCaps);
	
	ArrayList<String> listCapss = new ArrayList() {{add("abcd");add("abcd");add("abc");}};

	ArrayList<String> listCapsss= new ArrayList() {{add("ab");add("abc dr");add("ab");}};
	
	long countl=1l;
	 Map<String,Long > mapp = new HashMap<>();
	 
	 Map<String,Long > mappCount = new HashMap<>();
	    
	 Map<String, Long> mapC  = listCaps.stream().collect(Collectors.groupingBy(e->e, Collectors.counting()));
	 System.out.println(mapC);
	 System.out.println("----");
	 for(String s : listCapsss){
	        
          countl = listCapss.stream().filter(e->e.contains(s)).count();
        
          mapp.put(s,countl);
        
        
        }

	 System.out.println(mapp);

	 System.out.println("aaaaaaaaaaaa");
	 
	 Map<String, List<Integer>> mapCccc  = listCaps.stream().
			 collect(Collectors.groupingBy(e->e,
					 Collectors.mapping(e->e.length(), Collectors.toList())));
	 
	 System.out.println(mapCccc);
	 
	 ArrayList<String>  listy= (ArrayList<String>) mapp.entrySet().stream().
			 sorted(Comparator.comparing(Map.Entry::getValue,Comparator.reverseOrder())).
			 map(Map.Entry::getKey).collect(Collectors.toList());
	
	 
	 listy.stream().forEach(System.out::println);
	 System.out.println("------");
	 
	Map<String, Long> mapC1= mapC.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).
			collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
	System.out.println(mapC1); 

	
	Map<String, Long> mapC11= mapC.entrySet().stream()
								.sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder())).
								collect(Collectors.toMap(e->e.getKey(), e->e.getValue(), (e1,e2)->e2, LinkedHashMap::new));
	System.out.println(mapC11); 
	

	Map<String, Long> mapC112= mapC.entrySet().stream()
								.sorted((e1,e2)->e1.getValue().compareTo(e2.getValue())).
								collect(Collectors.toMap(e->e.getKey(), e->e.getValue(), (e1,e2)->e2, LinkedHashMap::new));
	System.out.println(mapC112); 
	
	
	Map<String, Long> mapC111= mapC.entrySet().stream()
			.sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder())).
			collect(Collectors.toMap(e->e.getKey(), e->e.getValue(), (e1,e2)->e2, LinkedHashMap::new));

	
//	Java 8 get all employee having address start with P


	Address add1 = new GroupingBy().new Address();
	add1.setCity("city1");
	add1.setCountry("country");
	add1.setState("state");
	Address add2 = new GroupingBy().new Address();
	add2.setCity("city2");
	add2.setCountry("country");
	add2.setState("state");
	Address add3 = new GroupingBy().new Address();
	add3.setCity("city3");
	add3.setCountry("country");
	add3.setState("state");
	
	List<Address> listA = List.of(add1,add2);

	List<Address> listA1 = List.of(add3);
Employee e1 = new GroupingBy().new Employee();
Employee e2 = new GroupingBy().new Employee();
Employee e3 = new GroupingBy().new Employee();
e1.setAge(12);
e1.setName("name1");
e1.setAddresses(listA);

e2.setAge(12);
e2.setName("name2");
e2.setAddresses(listA);
		
		e3.setAge(12);
		e3.setName("name3");
		e3.setAddresses(listA1);
	
		List<Employee> listE = List.of(e1,e2,e3);
	
		
		listE = listE.stream().filter(e->e.getAddresses().stream().
				anyMatch(e12->e12.getCity().startsWith("city3"))).collect(Collectors.toList());
	
listE.forEach(e->System.out.println(e.getName()));
	}
	
	class Employee {
	    private String name;
	    private int age;
	    private List<Address> addresses;
	    //getter and setter
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
		public List<Address> getAddresses() {
			return addresses;
		}
		public void setAddresses(List<Address> addresses) {
			this.addresses = addresses;
		}
	}
	
	class Address {
	    private String city;
	    private String state;
	    public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		private String country;
	    //getter and setter
	}
}
