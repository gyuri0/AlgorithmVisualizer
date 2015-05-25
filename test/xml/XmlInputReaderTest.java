package xml;

import org.junit.Assert;
import org.junit.Test;

import logic.SortAlgorithmInput;

public class XmlInputReaderTest {
	@Test
	public void getSortAlgorithmInputFromXmlTest()
	{
		SortAlgorithmInput sai = XmlInputReader.getSortAlgorithmInputFromXml("test.xml");
		
		int[] expected = new int[]{5,2,6};
		int[] actual = sai.getArray();
		
		Assert.assertArrayEquals(expected, actual);
	}
}
