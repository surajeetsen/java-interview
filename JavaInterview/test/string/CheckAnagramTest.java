package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Surajeet Sen
 */
public class CheckAnagramTest {

	@Test
	public void test() {
		CheckAnagram ca = new CheckAnagram();
		Assert.assertTrue(ca.isAnagram("listen", "silent"));
		Assert.assertFalse(ca.isAnagram("test", "tests"));
		Assert.assertFalse(ca.isAnagram("abcd", "abce"));
	}

}
