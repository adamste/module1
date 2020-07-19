package setepi.com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	private StringCalculator stringCalculator;

	@BeforeEach
	public void setup() {

		stringCalculator = new StringCalculator();
	}

	@Test
	public void shouldReturnZeroWhenGivenEmptyInput() {

		assertEquals(0, stringCalculator.add(""));
		assertEquals(0, stringCalculator.add(null));
	}

	@Test
	public void shouldReturnZeroWhenGivenZero() {

		assertEquals(0, stringCalculator.add("0"));
	}

	@Test
	public void shouldReturnSumWhenNumberGiven() {

		assertEquals(1, stringCalculator.add("1,"));
		assertEquals(9, stringCalculator.add("9"));
		assertEquals(99999909, stringCalculator.add("99999909"));
	}

	@Test
	public void shouldReturnSumWhenTwoNumbersGiven() {

		assertEquals(0, stringCalculator.add("0,0"));
		assertEquals(3, stringCalculator.add("1,2"));
		assertEquals(7, stringCalculator.add("3,4"));
		assertEquals(14, stringCalculator.add("5,9"));
		assertEquals(25, stringCalculator.add("15,10"));
	}

	@Test
	public void shouldReturnSumWhenManyNumbersGiven() {

		assertEquals(145, stringCalculator.add("15,10,120"));
		assertEquals(3000000, stringCalculator.add("1000000,1000000,1000000"));
		assertEquals(0, stringCalculator.add("1000000,-1000000,0"));
		assertEquals(7, stringCalculator.add("1,1,1,1,1,1,1"));
	}

	@Test
	public void shouldThrowExceptionWhenWrongInputGiven() {

		assertThrows(NumberFormatException.class, () -> stringCalculator.add("test"));
		assertThrows(NumberFormatException.class, () -> stringCalculator.add("t,13"));
		assertThrows(NumberFormatException.class, () -> stringCalculator.add("1a,13"));
		assertThrows(NumberFormatException.class, () -> stringCalculator.add("1,1a3"));
		assertThrows(NumberFormatException.class, () -> stringCalculator.add(" 1, 3"));
		assertThrows(NumberFormatException.class, () -> stringCalculator.add(",5"));
	}
}