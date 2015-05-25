package logic;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SortAlgorithmTest {
	
	@Test
	public void setInputTest()
	{
		SortAlgorithm<State> algorithm = new SortAlgorithm<State>() {
			
			@Override
			public List<Step<State>> run() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public State getState() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<Instruction> getInstructions() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		int[] originalArray = new int[]{1,2,3};
		
		algorithm.setInput(new SortAlgorithmInput(originalArray));
		
		int[] expectedArray = originalArray;
		int[] actualArray = algorithm.a;
		
		
		Assert.assertArrayEquals(expectedArray, actualArray);

		algorithm.a[0]=24;
		
		int expected = 1;
		int actual = originalArray[0];
		
		Assert.assertEquals(expected, actual);
	}
}
