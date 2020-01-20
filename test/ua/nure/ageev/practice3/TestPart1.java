package ua.nure.ageev.practice3;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestPart1 {

	@Test
	void testConvert1() {
		String input = "ivanov;Ivan Ivanov;ivanov@mail.com";
		String expect = "ivanov: ivanov@mail.com";
		Assert.assertEquals(expect + "\n", Part1.convert1(input));
	}

	@Test
	void testConvert2() {
		String input = "ivanov;Ivan Ivanov;ivanov@mail.com";
		String expect = "Ivanov Ivan (email: ivanov@mail.com)";
		Assert.assertEquals(expect + "\n", Part1.convert2(input));
	}
}
