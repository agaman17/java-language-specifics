package programmingLanguage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
	@Author : agaman <alexandru.gaman@yahoo.com>
	@Date Created : Jun 27, 2014 @ 4:56:57 PM
 */

public class TypeInference
{
	public static void main(String[] args)
	{
		beforeJDK7();
		afterJDK7();
	}
	
	public static void beforeJDK7()
	{
		Map<String, List<String>> myMap = new HashMap<String, List<String>>();
		myMap.put("a", new LinkedList<String>());
		System.out.println(myMap.toString());
	}
	
	/*
	 * You can replace the type arguments required to invoke the constructor 
	 * of a generic class with an empty set of type parameters (<>)
	 * as long as the compiler can infer the type arguments from the context.
	 * This pair of angle brackets is informally called the diamond.
	 */
	// We need to ignore the raw type inference and the unchecked compiler warnings
	@SuppressWarnings({"rawtypes","unchecked"})
	public static void afterJDK7()
	{
		/*
		 * Note that to take advantage of automatic type inference during generic class instantiation,
		 * you must specify the diamond. 
		 * In the following example, the compiler generates an unchecked conversion 
		 * warning because the HashMap() constructor refers to the HashMap raw type, 
		 * not the Map<String, List<String>> type: 
		 */
		
		// But we still can use the entity
		Map<String, List<String>> myMap = new HashMap(); // unchecked conversion warning
		myMap.put("a", new LinkedList<String>());
		System.out.println(myMap.toString());
		
		List<String> list = new ArrayList<>();
		list.add("A");
		System.out.println(list.toString());
	}
	
}
