package logic;

import org.junit.Assert;
import org.junit.Test;

public class UtilTest {
	
	@Test
	public void swapTest()
	{
		int[] array = new int[]{5,7,2};
		Util.swap(array, 0, 2);
		
		int[] excepted = new int[]{2,7,5};
		int[] actual = array;
		
		Assert.assertArrayEquals(excepted, actual);
	}
	
}
