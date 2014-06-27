package lambdaExpressions;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/*
	@Author : agaman <alexandru.gaman@yahoo.com>
	@Date Created : Jun 27, 2014 @ 5:52:10 PM
 */

public class Main
{
	public static void main(String[] args)
	{
		Dude someDude = new Dude(Dude.StupidityLevels.LOW);
		Dude someOtherDude = new Dude(Dude.StupidityLevels.MED);
		Dude someOtherOtherDude = new Dude(Dude.StupidityLevels.HIGH);
		
		List<Dude> dudes = new LinkedList<>();
		dudes.add(someDude);
		dudes.add(someOtherDude);
		dudes.add(someOtherOtherDude);
		
		processElements(dudes,d -> d.getStupidityLevel() == Dude.StupidityLevels.HIGH);
	}
	
	public static void printPersonsWithPredicate(
		    List<Dude> roster, Predicate<Dude> tester) {
		    for (Dude p : roster) {
		        if (tester.test(p)) {
		            p.toString();
		        }
		    }
		}
	
	
}
