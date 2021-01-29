package streams.jpclass;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class McDonalds {

	public static void main(String[] args)  throws Exception{
		
		
		
		"abc".chars().mapToObj(e->(char)e).forEach(e->System.out.println(e));
		
		Path p = Paths.get("files", "mcdonalds.csv");
	
		try(Stream<String> lines = Files.lines(p)) { 
		
		System.out.println(p);
		
		
		List<McDonald> listMcd =  lines.map(e-> {
			
			McDonald mdo = new McDonald();
			String[] strings = e.split(",");
			 mdo.setLatitude(Double.parseDouble(strings[0])) ;
	            mdo.setLongitude(Double.parseDouble(strings[1])) ;
	            mdo.setName(strings[2].substring(1) + strings[3].substring(0, strings[3].length() - 1)) ;
	            mdo.setAddress(strings[4].substring(1)) ;
	            mdo.setCity(strings[5].trim()) ;
	            mdo.setState(strings[6].trim()) ;
	            if (mdo.getState().endsWith("\"")) {
	                mdo.setState(mdo.getState().substring(0, mdo.getState().length() - 1)) ;
	            }
	            if (mdo.getState().contains(" ")) {
	                mdo.setState(mdo.getState().substring(0, mdo.getState().indexOf(" "))) ;
	            }
	            if (mdo.getState().length() > 2) {
	                mdo.setState(strings[7].trim()) ;
	            }
		
		return mdo;
		}).collect(Collectors.toList());
		
		 System.out.println("# of McDos = " + listMcd.size()) ;
         		
		long count = listMcd.stream().map(e->e.getCity() ).distinct().count();
		System.out.println("The number of cities that have a McDonald : " + count) ;

	    
	//TreeMap<String, Long>	listMcd.stream().collect(Collectors.groupingBy(e->e.getCity(), new TreeMap(Comparator.naturalOrder().reversed()), Collectors.counting()));
	
		Map<String, Long> map = listMcd.stream().collect(Collectors.groupingBy(e->e.getCity(), Collectors.counting()));
	
		
		Entry<String, Long> entry = map.entrySet().stream().max((Entry.comparingByValue())).get();
		
		System.out.println("The city has the most MacDonald : " + entry.getKey() + " count = " + entry.getValue()) ;
		
		}
		
		catch(Exception e) {
			
			
		}
	}
	
	// System.out.println("The city has the most MacDonald : " + entry) ;
	
	
	
	
	
	
	
}
