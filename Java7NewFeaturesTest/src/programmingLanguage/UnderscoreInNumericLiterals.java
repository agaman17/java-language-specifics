package programmingLanguage;
/*
	@Author : agaman
	@Date Created : Jun 27, 2014 @ 4:37:10 PM
 */

/*
 * In Java SE 7 and later, any number of underscore characters (_) can appear anywhere
 * between digits in a numerical literal. 
 * This feature enables you, for example, to separate groups of digits in numeric literals, 
 * which can improve the readability of your code.

	For instance, if your code contains numbers with many digits, 
	you can use an underscore character to separate digits in groups of three, 
	similar to how you would use a punctuation mark like a comma, or a space, as a separator.
	
	Caution : 
	You can place underscores only between digits; you cannot place underscores in the following places:

    At the beginning or end of a number
    Adjacent to a decimal point in a floating point literal
    Prior to an F or L suffix
    In positions where a string of digits is expected
 */
public class UnderscoreInNumericLiterals
{
	public static void main(String[] args)
	{
		long creditCardNumber = 1234_5678_9012_3456L;
		long socialSecurityNumber = 999_99_9999L;
		float pi = 	3.14_15F;
		long hexBytes = 0xFF_EC_DE_5E;
		long hexWords = 0xCAFE_BABE;
		long maxLong = 0x7fff_ffff_ffff_ffffL;
		byte nybbles = 0b0010_0101;
		long bytes = 0b11010010_01101001_10010100_10010010;
		
		System.out.println(creditCardNumber);
		System.out.println(socialSecurityNumber);
		System.out.println(pi);
		System.out.println(hexBytes);
		System.out.println(hexWords);
		System.out.println(maxLong);
		System.out.println(nybbles);
		System.out.println(bytes);
	}
	
}
