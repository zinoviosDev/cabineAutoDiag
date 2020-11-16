package diagauto.cabine.util.math;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestMultiple {
	
	@DisplayName("Test Multiple isMultipleOfThree")
	@Test
	void testIsMultipleOfThree() {
		assertThat(Multiple.isMultipleOfThree(0), is(true));
		assertThat(Multiple.isMultipleOfThree(3), is(true));
		assertThat(Multiple.isMultipleOfThree(6), is(true));
		assertThat(Multiple.isMultipleOfThree(15), is(true));
		assertThat(Multiple.isMultipleOfThree(17), is(false));
	}

	@DisplayName("Test Multiple isMultipleOfFive")
	@Test
	void testIsMultipleOfFive() {
		assertThat(Multiple.isMultipleOfFive(0), is(true));
		assertThat(Multiple.isMultipleOfFive(5), is(true));
		assertThat(Multiple.isMultipleOfFive(10), is(true));
		assertThat(Multiple.isMultipleOfFive(15), is(true));
		assertThat(Multiple.isMultipleOfFive(17), is(false));
	}
	
	@DisplayName("Test Multiple isMultipleOfThreeAndFive")
	@Test
	void testIsMultipleOfThreeAndFive() {
		assertThat(Multiple.isMultipleOfThreeAndFive(0), is(true));
		assertThat(Multiple.isMultipleOfThreeAndFive(5), is(false));
		assertThat(Multiple.isMultipleOfThreeAndFive(10), is(false));
		assertThat(Multiple.isMultipleOfThreeAndFive(15), is(true));
		assertThat(Multiple.isMultipleOfThreeAndFive(17), is(false));
	}
	
	@DisplayName("Test Multiple generateMultipleOfThree")
	@Test
	void testGenerateMultipleOfThree() {
		assertThat(Multiple.isMultipleOfThree(Multiple.generateMultipleOfThree()), is(true));
		assertThat(Multiple.isMultipleOfThree(Multiple.generateMultipleOfThreeAndFive()), is(true));
	}
	
	@DisplayName("Test Multiple generateMultipleOfFive")
	@Test
	void testGenerateMultipleOfFive() {
		assertThat(Multiple.isMultipleOfFive(Multiple.generateMultipleOfThreeAndFive()), is(true));
		assertThat(Multiple.isMultipleOfFive(Multiple.generateMultipleOfFive()), is(true));
	}
	
	@DisplayName("Test Multiple generateMultipleOfThreeAndFive")
	@Test
	void testGenerateMultipleOfThreeAndFive() {
		assertThat(Multiple.isMultipleOfThreeAndFive(Multiple.generateMultipleOfThreeAndFive()), is(true));
	}
}
