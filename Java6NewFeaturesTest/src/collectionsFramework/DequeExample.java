package collectionsFramework;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

import common.DateHelpers;
/*
 * 
public interface Deque<E>
extends Queue<E>

A linear collection that supports element insertion and removal at both ends.
The name deque is short for "double ended queue" and is usually pronounced "deck".
Most Deque implementations place no fixed limits on the number of elements they may contain,
but this interface supports capacity-restricted deques as well as those with no fixed size limit.

This interface defines methods to access the elements at both ends of the deque.
Methods are provided to insert, remove, and examine the element.
Each of these methods exists in two forms:
	one throws an exception if the operation fails
	the other returns a special value (either null or false, depending on the operation). 
The latter form of the insert operation is designed specifically for use 
with capacity-restricted Deque implementations;
in most implementations, insert operations cannot fail. 



public interface BlockingDeque<E>
extends BlockingQueue<E>, Deque<E>

A Deque that additionally supports blocking operations that wait
for the deque to become non-empty when retrieving an element,
and wait for space to become available in the deque when storing an element.

BlockingDeque methods come in four forms, with different ways of handling operations
that cannot be satisfied immediately, but may be satisfied at some point in the future:
	one throws an exception
	the second returns a special value (either null or false, depending on the operation)
	the third blocks the current thread indefinitely until the operation can succeed
	and the fourth blocks for only a given maximum time limit before giving up.
 */
public class DequeExample {

	// First, use a sample deque as an array. For simple calls
	private static ArrayDeque<Integer> arrDeque = new ArrayDeque<Integer>();
	
	// Second, add some concurrency here
	private static LinkedBlockingDeque<Integer> lbDeque = new LinkedBlockingDeque<Integer>();
	
	public static void main(String[] args)
	{
		// Some test values
		Integer[] first = new Integer[] {1,2,3,4,5,6,7,8,9,10};
		Integer[] second = new Integer[] {11,12,13,14,15,16,17,18,19,20};
		Integer[] third = new Integer[] {21,22,23,24,25,26,27,28,29,30};
		Integer[] fourth = new Integer[] {31,32,33,34,35,36,37,38,39,40};
		Integer[] fifth = new Integer[] {41,42,43,44,45,46,47,48,49,50};
		
		Date start = new Date();
		// The simple array deque. Add some elements
		for (int i = 0; i < first.length; i++)
		{
			arrDeque.add(first[i]);
		}
		System.out.println("Added first array...");
		System.out.println("Still working for : " + DateHelpers.getTimeElapsedFromDate(start));
		for (int i = 0; i < second.length; i++)
		{
			arrDeque.add(second[i]);
		}
		System.out.println("Added second array...");
		System.out.println("Still working for : " + DateHelpers.getTimeElapsedFromDate(start));
		for (int i = 0; i < third.length; i++)
		{
			arrDeque.add(third[i]);
		}
		System.out.println("Added third array...");
		System.out.println("Still working for : " + DateHelpers.getTimeElapsedFromDate(start));
		for (int i = 0; i < fourth.length; i++)
		{
			arrDeque.add(fourth[i]);
		}
		System.out.println("Added fourth array...");
		System.out.println("Still working for : " + DateHelpers.getTimeElapsedFromDate(start));
		for (int i = 0; i < fifth.length; i++)
		{
			arrDeque.add(fifth[i]);
		}
		System.out.println("Added fifth array...");
		System.out.println("Still working for : " + DateHelpers.getTimeElapsedFromDate(start));
		System.out.println(arrDeque.toString());
		System.out.println("Done work in " + DateHelpers.getTimeElapsedFromDate(start) + " ms");
		
		start = new Date();
		System.out.println("Starting threaded work...");
		// Now, insert multiple values using threads
		ExecutorService executor = Executors.newFixedThreadPool(5);
		executor.execute(new SampleThreadedExample(first, lbDeque));
		executor.execute(new SampleThreadedExample(second, lbDeque));
		executor.execute(new SampleThreadedExample(third, lbDeque));
		executor.execute(new SampleThreadedExample(fourth, lbDeque));
		executor.execute(new SampleThreadedExample(fifth, lbDeque));
		executor.shutdown();
		while(!executor.isTerminated())
		{
			//System.out.println("Still working for : " + DateHelpers.getTimeElapsedFromDate(start));
		}
		System.out.println("Finished threaded work in " + DateHelpers.getTimeElapsedFromDate(start) + " ms");
		System.out.println(lbDeque.toString());
		System.out.println("Done...");
	}
}
