package programmingLanguage;

import java.util.ArrayList;
import java.util.List;

/*
	@Author : agaman <alexandru.gaman@yahoo.com>
	@Date Created : Jun 27, 2014 @ 5:31:51 PM
 */

public class ImprovedCompilerWarnings
{
	/*
	 * Heap Pollution

		Most parameterized types, such as ArrayList<Number> and List<String>, are non-reifiable types. 
		A non-reifiable type is a type that is not completely available at runtime. 
		At compile time, non-reifiable types undergo a process called type erasure 
		during which the compiler removes information related to type parameters and type arguments. 
		This ensures binary compatibility with Java libraries and applications that were created 
		before generics. Because type erasure removes information from parameterized types at 
		compile-time, these types are non-reifiable.

		Heap pollution occurs when a variable of a parameterized type refers to an object 
		that is not of that parameterized type. This situation can only occur if the program performed 
		some operation that would give rise to an unchecked warning at compile-time. 
		An unchecked warning is generated if, either at compile-time 
		(within the limits of the compile-time type checking rules) or at runtime, 
		the correctness of an operation involving a parameterized type 
		(for example, a cast or method call) cannot be verified.
	 */
	@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
	public static void main(String[] args)
	{
		List l = new ArrayList<Number>();
	    List<String> ls = l;       // unchecked warning
	    l.add(0, new Integer(42)); // another unchecked warning
	    String s = ls.get(0);      // ClassCastException is thrown
	}
	
	/*
	 * The Java compiler generates the following warnings for this example:

    addToList:
        At the method's declaration: 
        	[unchecked] Possible heap pollution from parameterized vararg type T
        When the method is called: 
        	[unchecked] unchecked generic array creation for varargs parameter of type List<String>[]
    addToList2: 
    	When the method is called (no warning is generated at the method's declaration): [unchecked] unchecked generic array creation for varargs parameter of type List<String>[]
    addToList3: 
    	No warnings are generated either at the method's declaration or when it is called.

	 */
	static class ArrayBuilder {

		  @SuppressWarnings("unchecked")
		public static <T> void addToList (List<T> listArg, T... elements) {
		    for (T x : elements) {
		      listArg.add(x);
		    }
		  }

		  @SuppressWarnings("unchecked")
		public static <T> void addToList2 (List<T> listArg, T... elements) {
		    for (T x : elements) {
		      listArg.add(x);
		    }
		  }

		  @SuppressWarnings("unchecked")
		public static <T> void addToList3 (List<T> listArg, T... elements) {
		    for (T x : elements) {
		      listArg.add(x);
		    }
		  }

		  // ...

		}
}
