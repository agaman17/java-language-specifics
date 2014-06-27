package common;

import java.util.Date;

public class DateHelpers 
{
	public static String getTimeElapsedFromDate(Date date)
	{
		long diffInMillis = new Date().getTime() - date.getTime();
		return String.valueOf(diffInMillis);
	}
}
