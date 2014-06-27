package lambdaExpressions;

/*
 * @Author : agaman <alexandru.gaman@yahoo.com>
 * @Date Created : Jun 27, 2014 @ 5:50:05 PM
 */

public class Dude
{
	public static class StupidityLevels
	{
		public static final int HIGH = 10;
		public static final int MED_HIGH = 7;
		public static final int MED = 5;
		public static final int MED_LOW = 3;
		public static final int LOW = 1;
	}

	int stupidityLevel;

	public Dude(int sl)
	{
		stupidityLevel = sl;
	}

	public int getStupidityLevel()
	{
		return stupidityLevel;
	}

	public void setStupidityLevel(int stupidityLevel)
	{
		this.stupidityLevel = stupidityLevel;
	}
	
	public String toString()
	{
		return String.format("{ stupidityLevel : %s }", stupidityLevel);
	}
}
