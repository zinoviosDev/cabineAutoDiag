package diagauto.cabine.services;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import diagauto.cabine.DemoApplication;
import diagauto.cabine.model.activite.services.Cardiologie;
import diagauto.cabine.model.activite.services.ServiceHospitalier;
import diagauto.cabine.model.activite.services.Traumatologie;
import diagauto.cabine.model.patient.Patient;
import diagauto.cabine.util.math.Multiple;

@SpringBootTest
class TestHospitalisationMainService {
	
	private static Logger LOG = LoggerFactory.getLogger(DemoApplication.class);
	
	@Autowired HospitalisationMainService service;
	
	private static Patient[] patients = new Patient[3];
	
	@BeforeAll
	public static void init() {
		patients[0] = new Patient("179072605774");
		patients[1] = new Patient("278072605774");
		patients[2] = new Patient("177072605774");
				
	}

	@DisplayName("Test HospitalisationMainService GetHealthServicesForPatient")
	@Test
	void testGetHealthServicesForPatient() {
		for(Patient patient : patients) {
			List<ServiceHospitalier> servicesHospitaliers = service.getHealthServicesForPatient(patient);
			int healthIndex = patient.getHealthIndex();
			LOG.debug("Index de santé du patient = " + healthIndex);
			
			if(0 == healthIndex) {
				assertThat(servicesHospitaliers, hasSize(0));
			}
			else if(Multiple.isMultipleOfThreeAndFive(healthIndex)) {
				assertThat(servicesHospitaliers, hasSize(2));
				assertThat(servicesHospitaliers, hasItem(isA(Cardiologie.class)));
				assertThat(servicesHospitaliers, hasItem(isA(Traumatologie.class)));
			}
			else if(Multiple.isMultipleOfThree(healthIndex)) {
				assertThat(servicesHospitaliers, hasSize(1));
				assertThat(servicesHospitaliers, hasItem(isA(Cardiologie.class)));
			}
			else if(Multiple.isMultipleOfFive(healthIndex)) {
				assertThat(servicesHospitaliers, hasSize(1));
				assertThat(servicesHospitaliers, hasItem(isA(Traumatologie.class)));
			}
			else {
				assertThat(servicesHospitaliers, hasSize(0));
			}
		}
	}
}
