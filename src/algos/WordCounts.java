package algos;

import java.util.*;
import java.util.stream.Collectors;

public class WordCounts {
    
    public WordCounts(String sentence) {
        super();
        setSentence(sentence);
    }
 
    private static String sentence;
    private static String[] words;

    
    //get map of word and their count
    public static Map<String, Long> getWordCounts(){     

    	
    	return Arrays.stream(words).collect(Collectors.groupingBy(e->e, Collectors.counting()));
    
    }
     
    
//map of length and their corresponding string    
    public static Map<Integer, List<String>> getWordLength(){  
    	return Arrays.stream(words).collect(Collectors.groupingBy(e->e.length()));
    }
     
    
    
    public static Map<Integer, Collection<String>> getWordLength_Set(){    

    	return Arrays.stream(words).collect(Collectors.groupingBy(e->e.length(),
                Collectors.toCollection(()->new HashSet<String>())));
    
    }
     
    public static Map<Integer, List<String>> getWordLength_List(){ 
    	return Arrays.stream(words)
                .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));
    }
     
    public static Map<Integer, String> getWordLength_String(){   
    	return Arrays.stream(words)
                .collect(Collectors.groupingBy(String::length, Collectors.joining("|","[","]")));
    }
     
     /*
    public Map<Integer, IntSummaryStatistics> getWordLength_summarizingInt(){ 
    }*/
 
    protected static String getSentence() {
        return sentence;
    }
 
    protected static void setSentence(String sentence) {       
        sentence = sentence.replaceAll("[;,.]","");
        words = sentence.split(" ");
    }
 
    public static void main(String[] args) {
		
    	setSentence("how do you do");
    	
    	Map<String, Long> map =getWordCounts();
    	map.entrySet().stream().forEach(e-> System.out.println( e.getKey() + "    key" +    e.getValue() +  "   value "));;
    	System.out.println("------------------");
    	Map<Integer, List<String>> map1= getWordLength();
    	
    	Map<Integer, Collection<String>> map2 =getWordLength_Set();
    	
    	Map<Integer, List<String>> map31 = getWordLength_List();
    	
    	Map<Integer, String> map32 = getWordLength_String();
    	map32.entrySet().stream().forEach(e-> System.out.println( e.getKey() + "    key" +    e.getValue() +  "   value "));;
	}
    
    
    
    
}
