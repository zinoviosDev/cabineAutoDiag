package diagauto.cabine.services;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import diagauto.cabine.util.math.Multiple;

@SpringBootTest
class TestAcquisitionDonneesCapteurService {
	
	@Autowired
	AcquisitionDonneesCapteurService acquisitionDonneesCapteurService;

	@DisplayName("Test AcquisitionDonneesCapteurService GetPatientHealthIndex")
	@Test
	void testGetPatientHealthIndex() {
		int healthIndex = acquisitionDonneesCapteurService.getPatientHealthIndex();
		assertThat(
				healthIndex == 0
				|| Multiple.isMultipleOfThree(healthIndex) 
				|| Multiple.isMultipleOfFive(healthIndex)
				, is(true)
		);
	}
}
