package bubblesort;

import java.util.List;

import logic.SortAlgorithmInput;
import logic.Step;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {

	@Test
	public void testBubbleSortResult() {
		BubbleSort bs = new BubbleSort();
		bs.setInput(new SortAlgorithmInput(new int[]{7,5,6,4,2,1}));
		
		List<Step<BubbleSortState>> steps = bs.run();
		
		int[] excepted = new int[]{1,2,4,5,6,7};
		int[] actual = steps.get(steps.size()-1).getState().getArray();
		Assert.assertArrayEquals(excepted, actual);
		
	}

}
