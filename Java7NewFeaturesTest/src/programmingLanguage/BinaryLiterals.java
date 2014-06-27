package programmingLanguage;

/*
 * In Java SE 7, the integral types (byte, short, int, and long) can also be expressed 
 * using the binary number system. To specify a binary literal, add the prefix 0b or 0B to the number. 
 */
public class BinaryLiterals 
{
	static byte aByteNumber = (byte)0b00101101;
	static short aShortNumber = (short)0b01001011;
	static int anIntValue = 0b1000101010101101;
	
	public static final short[] HAPPY_FACE = {
		   (short)0b0000011111100000,
		   (short)0b0000100000010000,
		   (short)0b0001000000001000,
		   (short)0b0010000000000100,
		   (short)0b0100000000000010,
		   (short)0b1000011001100001,
		   (short)0b1000011001100001,
		   (short)0b1000000000000001,
		   (short)0b1000000000000001,
		   (short)0b1001000000001001,
		   (short)0b1000100000010001,
		   (short)0b0100011111100010,
		   (short)0b0010000000000100,
		   (short)0b0001000000001000,
		   (short)0b0000100000010000,
		   (short)0b0000011111100000
		};
	
	public static void main(String[] args)
	{
		System.out.println("Byte number : " + aByteNumber);
		System.out.println("Short number : " + aShortNumber);
		System.out.println("Int number : " + anIntValue);
		System.out.println("Special stuff : ");
		System.out.println(HAPPY_FACE[1]);
	}
}
