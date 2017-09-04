package math;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Surajeet Sen
 */
public class PalindromeNumberTest {

	@Test
	public void test() {
		PalindromeNumber pm = new PalindromeNumber();
		
		Assert.assertTrue(pm.isPalindrome(121));
		Assert.assertTrue(pm.isPalindrome(1));
		Assert.assertTrue(pm.isPalindrome(1221));
		Assert.assertFalse(pm.isPalindrome(12));
		Assert.assertFalse(pm.isPalindrome(123));
	}

}
