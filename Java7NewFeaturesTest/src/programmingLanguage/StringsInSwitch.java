package programmingLanguage;


/*
 * In the JDK 7 release, you can use a String object in the expression of a switch statement:
 */
public class StringsInSwitch 
{
	public static void main(String[] args)
	{
		System.out.println(getSomeData("a"));
		System.out.println(getSomeData("b"));
		System.out.println(getSomeData("c"));
	}
	
	private static String getSomeData (String param)
	{
		switch (param.toLowerCase()) 
		{
		case "a":
			return "You have supplied \"A\" as parameter";
			// break
		case "b":
			return "You have supplied \"B\" as parameter";
			// break
		default:
			return "Expression not supported";
			//break;
		}
	}
}
