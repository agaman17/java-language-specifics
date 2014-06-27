package programmingLanguage;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * The try-with-resources statement is a try statement 
 * that declares one or more resources. 
 * A resource is as an object that must be closed after the program is finished with it. 
 * The try-with-resources statement ensures that each resource is closed at the end of the statement. 
 * Any object that implements java.lang.AutoCloseable, 
 * which includes all objects which implement java.io.Closeable, can be used as a resource.
 */
public class TryWithResources 
{
	public static void main(String[] args)
	{
		beforeJDK7();
		afterJDK7();
	}

	public static void beforeJDK7()
	{
		File file = null;
		PrintWriter pw = null;
		Scanner sc = null;
		try
		{
			file = new File("/home/agaman/Desktop/javaTestFile");
			if (!file.createNewFile())
				System.err.println("Could not create file!");
			pw = new PrintWriter(file);
			pw.println("Hello world!");
			pw.close();
			sc = new Scanner(file);
			System.out.println(sc.nextLine());
			sc.close();
			if (!file.delete())
				System.err.println("Could not delete file!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (pw != null)
					pw.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			try
			{
				if (sc != null)
					sc.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void afterJDK7()
	{
		File file = new File("/home/agaman/Desktop/javaTestFile");
		/*
		 * Notice that the try statement already binds the resources
		 * There is no need to close them programatically.
		 * If we want, though, we can close any resource declared in the 'try' statement
		 */
		try
		(
				PrintWriter pw = new PrintWriter(file);
				Scanner sc = new Scanner(file);
		)
		{
			if (!file.createNewFile())
				//System.err.println("Could not create file!");
			pw.println("Hello world!");
			pw.close();
			System.out.println(sc.nextLine());
			if (!file.delete())
				System.err.println("Could not delete file!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
