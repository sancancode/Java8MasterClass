package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class BiFunctionExample {

	
	//int + number = string
	
	BiFunction<Integer, Number, String> integerAdder = (integer, number) -> 
         Double.toString(number.doubleValue() + integer);
    ;
		
	
	public static void main(String[] args) {
		
		BiFunction<Integer, Number, String> biF = (integer, number)-> Double.toString(number.doubleValue() + integer );
	
		String s = biF.apply(10, 2.0);
		
		System.out.println(s);
		
		
		BiFunction<Integer, Integer, Integer> bifAdd = (a,b)-> a+b;
		
		List<Integer> list = new ArrayList() {{add(1);add(2);add(3);add(4);}};
		
		getAnotherList(list, 4, bifAdd);
		
		
		
		BiFunction<String, Integer, String> bifString = (e1,e2)->e1.substring(e2);
		
		List<String> strList = Arrays.asList("apple", "bat", "car");
		
		getAnotherListString(strList, 2, bifString);
		
	}
	
	
	private static void getAnotherList(List<Integer> list, int newInt, BiFunction<Integer, Integer, Integer> bif1) {

		List<Integer> listNew = new ArrayList<Integer>();
		
		
		list.stream().forEach(e->listNew.add(bif1.apply(e, newInt)));
		
		listNew.stream().forEach(e->System.out.println(e + " listNew"));
		
	}

	private static  void getAnotherListString(List<String> list, int subIndex, BiFunction<String, Integer, String> bif) {

		List<String> newList = new ArrayList<String>();
		
		list.stream().forEach(e->newList.add(bif.apply(e, subIndex)));
		
		newList.stream().forEach(e->System.out.println(e + " listNewString"));
		
	}
	
	
}
