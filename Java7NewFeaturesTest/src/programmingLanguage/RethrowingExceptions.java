package programmingLanguage;

import java.io.FileNotFoundException;

/*
	@Author : agaman
	@Date Created : Jun 27, 2014
*/
public class RethrowingExceptions 
{
	public static void main(String[] args)
	{
		
	}
	
	/*
	 * This examples's try block could throw either ExceptionOne or ExceptionTwo. 
	 * Suppose you want to specify these exception types in the throws clause of the 
	 * beforeJDK7 method declaration. 
	 * In releases prior to Java SE 7, you cannot do so. 
	 * Because the exception parameter of the catch clause, e, 
	 * is type Exception, and the catch block rethrows the exception parameter e, 
	 * you can only specify the exception type Exception in the throws clause of the 
	 * rethrowException method declaration
	 */
	public static void beforeJDK7(String exceptionName) throws Exception
	{
		try
		{
			if(exceptionName.compareToIgnoreCase("exceptionone") == 0)
				throw new ExceptionOne();
			if(exceptionName.compareToIgnoreCase("exceptiontwo") == 0)
				throw new ExceptionTwo();
			throw new FileNotFoundException(); // Throw an exception like a boss
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	/*
	 * However, in Java SE 7, you can specify the exception types ExceptionOne and ExceptionTwo
	 *  in the throws clause in the afterJDK7 method declaration. 
	 *  The Java SE 7 compiler can determine that the exception thrown by the statement 
	 *  throw e must have come from the try block, and the only exceptions thrown by the try block 
	 *  can be ExceptionOne and ExceptionTwo. Even though the exception parameter of the 
	 *  catch clause, e, is type Exception, the compiler can determine that it is an instance of 
	 *  either ExceptionOne or ExceptionTwo:
	 */
	public static void afterJDK7(String exceptionName) throws ExceptionOne, ExceptionTwo
	{
		try
		{
			if(exceptionName.compareToIgnoreCase("exceptionone") == 0)
				throw new ExceptionOne();
			if(exceptionName.compareToIgnoreCase("exceptiontwo") == 0)
				throw new ExceptionTwo();
			//throw new FileNotFoundException(); // We cannot throw this unless we add it to the
												// throws declaration of the class
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	static class ExceptionOne extends Exception
	{
		private static final long serialVersionUID = 1407491671554991524L;
	}
	
	static class ExceptionTwo extends Exception
	{
		private static final long serialVersionUID = 6333850917278009461L;
	}
}
