package collectionsFramework;
import java.util.concurrent.LinkedBlockingDeque;

public class SampleThreadedExample implements Runnable
{
	private Integer[] _elements;
	private LinkedBlockingDeque<Integer> _lbd;
	
	public SampleThreadedExample(Integer[] elements, LinkedBlockingDeque<Integer> lbd)
	{
		_elements = new Integer[elements.length];
		for (int i = 0; i < elements.length; i++)
		{
			_elements[i] = elements[i];
		}
		_lbd = lbd;
	}

	@Override
	public void run() {
		for (int i = 0; i < _elements.length; i++)
		{
			_lbd.add(_elements[i]);
		}
	}
	
	
}