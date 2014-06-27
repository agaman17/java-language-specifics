package reflectionApi;

import java.lang.reflect.Method;
/*
 * 

public final class Method
extends AccessibleObject
implements GenericDeclaration, Member

A Method provides information about, and access to, a single method on a class or interface.
The reflected method may be a class method or an instance method (including an abstract method).

A Method permits widening conversions to occur when matching the actual parameters
to invoke with the underlying method's formal parameters,
but it throws an IllegalArgumentException if a narrowing conversion would occur. 

Note : The class was updated in java 5, improved in java 6
The following methods in java.lang.Class were generified: 
getInterfaces(), getClasses(). getConstructors(). getMethod(String, Class...), 
getConstructor(Class...), getDeclaredClasses(), getDeclaredConstructors(), 
getDeclaredMethod(String, Class...), and getDeclaredConstructor(Class...). 
As a result, code which uses these methods now produces warnings during compilation. 
 */
public class Main 
{
	@SuppressWarnings({"rawtypes","unchecked"})
	public static void main(String[] args)
	{
		try
		{
			RefClass rc = new RefClass();
			Class cl = rc.getClass();
			Method aMethod = cl.getDeclaredMethod("method");
			System.out.println("Selected method name : " + aMethod.getName());
			System.out.println("Selected method hashcode :" + aMethod.hashCode());
			System.out.println("Method to string : " + aMethod.toString());
		}
		catch (NoSuchMethodException nsme)
		{
			nsme.printStackTrace();
		}
	}
}
