package math;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Surajeet Sen
 */
public class AddDigitsTest {

	@Test
	public void test() {
		AddDigits ad = new AddDigits();
		
		Assert.assertEquals(1, ad.addDigits(100));
		Assert.assertEquals(0, ad.addDigits(0));
		Assert.assertEquals(9, ad.addDigits(999));
		Assert.assertEquals(ad.addDigits(321), ad.addDigits(123));
		Assert.assertEquals(ad.addDigits(654321), ad.addDigits(123456));
	}

}