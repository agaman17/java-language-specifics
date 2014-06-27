package programmingLanguage;

import java.io.File;
import java.io.IOException;

/*
 * In Java SE 7 and later, a single catch block can handle more than one type of exception. 
 * This feature can reduce code duplication and lessen the temptation to catch an overly broad exception.
 */
public class CatchingMultipleExceptions 
{
	public static void main(String[] args)
	{
		beforeJDK7();
		afterJDK7();
	}
	
	/*
	 * In releases prior to Java SE 7, it is difficult to create a common method to 
	 * eliminate the duplicated code because the variable ex has different types.
	 */
	public static void beforeJDK7()
	{
		try
		{
			File file = new File("/home/agaman/Desktop");
			
			file.canRead(); // Throws Security Exception
			System.out.println(file.getCanonicalPath()); // Throws IO Exception, sec. exception
			File.createTempFile("prefix", "suffix"); // Throws Illegal arg Exception, ioe, se
			System.out.println(File.listRoots().toString());
		}
		catch(SecurityException se)
		{
			se.printStackTrace();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		catch(IllegalArgumentException iae)
		{
			iae.printStackTrace();
		}
		/*
		 * Don't you ever get tired of this ton of catch blocks?
		 */
	}
	
	/*
	 * The catch clause specifies the types of exceptions that the block can handle, 
	 * and each exception type is separated with a vertical bar (|).
	 * 
	 * Note: If a catch block handles more than one exception type,
	 * then the catch parameter is implicitly final. 
	 * In this example, the catch parameter ex is final 
	 * and therefore you cannot assign any values to it within the catch block.
	 */
	public static void afterJDK7()
	{
		try
		{
			File file = new File("/home/agaman/Desktop");
			
			file.canRead(); // Throws Security Exception
			System.out.println(file.getCanonicalPath()); // Throws IO Exception, sec. exception
			File.createTempFile("prefix", "suffix"); // Throws Illegal arg Exception, ioe, se
			System.out.println(File.listRoots().toString());
		}
		catch(SecurityException | IOException | IllegalArgumentException e)
		{
			if (e.getClass().equals(SecurityException.class))
				System.out.println("Got Security Exception");
			if (e.getClass().equals(IOException.class))
				System.out.println("Got IO Exception");
			if (e.getClass().equals(IllegalArgumentException.class))
				System.out.println("Got Illegal argument Exception");
		}
		/*
		 * Much more elegant catch block with reusable code
		 * Note that we can catch a wider array of errors and treat them in the same block
		 * So we can run a method or smth that resolves the exceptions
		 */
	}
}
