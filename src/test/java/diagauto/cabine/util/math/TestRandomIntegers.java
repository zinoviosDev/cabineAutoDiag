package diagauto.cabine.util.math;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestRandomIntegers {

	@DisplayName("Test RandomIntegers getRandomIntBetween")
	@Test
	void testGetRandomIntBetween() {
		int random = RandomIntegers.getRandomIntBetween(0, 100000);
		assertThat(random, is(both(greaterThan(-1)).and(lessThan(100000))));
		random = RandomIntegers.getRandomIntBetween(0, 0);
		assertThat(random, is(equalTo(0)));
		random = RandomIntegers.getRandomIntBetween(545, 545);
		assertThat(random, is(equalTo((545))));
	}
	
	@DisplayName("Test RandomIntegers randomMultipleInRange")
	@Test
	void testRandomMultipleInRange() {
		int random = RandomIntegers.randomMultipleInRange(150, 3);
		assertThat(random, is(both(greaterThan(0)).and(lessThan(150))));  
		assertThat(Multiple.isMultipleOfThree(random), is(true));
		
		random = RandomIntegers.randomMultipleInRange(150, 5);
		assertThat(random, is(both(greaterThan(0)).and(lessThan(150))));
		assertThat(Multiple.isMultipleOfFive(random), is(true));
		
		random = RandomIntegers.randomMultipleInRange(150, 15);
		assertThat(random, is(both(greaterThan(0)).and(lessThan(150))));
		assertThat(Multiple.isMultipleOfThreeAndFive(random), is(true));
		
		Throwable thrown = assertThrows(ArithmeticException.class, () -> RandomIntegers.randomMultipleInRange(150, 0));
		assertThat(thrown.getMessage(), is("multiple arg has to be > 0"));
		
		thrown = assertThrows(ArithmeticException.class, () -> RandomIntegers.randomMultipleInRange(5, 150));
		assertThat(thrown.getMessage(), is("max arg has to be > multiple"));
	}
}
