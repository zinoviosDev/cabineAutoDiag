package diagauto.cabine.services;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import diagauto.cabine.model.pathologies.Fracture;
import diagauto.cabine.model.pathologies.ProblemeCardiaque;

@SpringBootTest
class TestDefinitionParcoursPatientService { 
	
	@Autowired
	DefinitionParcoursPatientService definitionParcoursPatientService;
	
	@DisplayName("Test definitionParcoursPatientService determinePathologies")
	@Test
	void testDeterminePathologies() {
		assertThat(definitionParcoursPatientService.determinePathologies(59), empty());
		assertThat(definitionParcoursPatientService.determinePathologies(3), hasSize(1));
		assertThat(definitionParcoursPatientService.determinePathologies(3), containsInAnyOrder(new ProblemeCardiaque("cardiaque",null)));
		assertThat(definitionParcoursPatientService.determinePathologies(5), hasSize(1));
		assertThat(definitionParcoursPatientService.determinePathologies(5), containsInAnyOrder(new Fracture("fracture", null)));
	}
}
