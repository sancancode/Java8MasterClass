package streams.reduceandcollect;

import java.util.Arrays;
import java.util.List;

public class ReduceExample {

	
	//concatenate a arraylist of string
	private static void concat() {
		
		List<String> list = Arrays.asList("abc", "bcd", "cde");
		
		String a = list.stream().reduce((e1, e2)->e1+ " "+ e2).get();
		
		String aa = list.stream().reduce("aaa", (e1,e2)->e1+" "+e2);
		
		System.out.println(a + "   reduce normal");
		System.out.println(aa + "      reduce with identity");
		// TODO Auto-generated method stub

	}
	
	//reduce using collect
	
	private static void concatCollectReduce() {
		
		List<String> list = Arrays.asList("abc", "bcd", "cde");
		
		//String a = list.stream().collect(StringBuilder::new, (sb, s1) -> sb.append(" ").append(s1), (s1,s2)->s1+s2);
		
		//System.out.println(a);
		
		// TODO Auto-generated method stub

	}	
	
	
	
	
	
	
	private static void concatArray() {
		
		String[] array = {"abc", "bcd", "cde"};
		
		String a = Arrays.stream(array).reduce((e1, e2)->e1+ " "+ e2).get();
		
		System.out.println(a);
		

	}
	
	
	public static void main(String[] args) {
		concat();
		concatArray();
	}
	
	
	
}
