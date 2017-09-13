package array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Surajeet Sen
 */
public class OddOccurrenceTest {

	@Test
	public void test() {
		OddOccurrence oc = new OddOccurrence();
		Assert.assertEquals(1, oc.getNumberOccuringOddNumberOfTimes(new int[]{1,1,1,2,2}));
		Assert.assertEquals(-1, oc.getNumberOccuringOddNumberOfTimes(null));
		Assert.assertEquals(1, oc.getNumberOccuringOddNumberOfTimes(new int[]{1}));
		Assert.assertEquals(-1, oc.getNumberOccuringOddNumberOfTimes(new int[]{1,1}));
		Assert.assertEquals(3, oc.getNumberOccuringOddNumberOfTimes(new int[]{1,2,3,1,2}));
		Assert.assertEquals(-1, oc.getNumberOccuringOddNumberOfTimes(new int[]{1,1,2,2}));
	}

}
