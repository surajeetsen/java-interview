package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Surajeet Sen
 */
public class StringHasAllUniqueCharsTest {

	@Test
	public void test() {
		StringHasAllUniqueChars hasUnique = new StringHasAllUniqueChars();
		Assert.assertTrue(hasUnique.areAllUniqueChars1("ABCDefghijklmn"));
		Assert.assertTrue(hasUnique.areAllUniqueChars2("abcdefxyz"));
		Assert.assertFalse(hasUnique.areAllUniqueChars1("abcdefghijklb"));
		Assert.assertTrue(hasUnique.areAllUniqueChars1("abcdef12345*&^%"));
		Assert.assertFalse(hasUnique.areAllUniqueChars1("abcdef12345*&^%*"));
	}

}
