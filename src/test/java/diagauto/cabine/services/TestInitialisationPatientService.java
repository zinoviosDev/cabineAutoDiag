package diagauto.cabine.services;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import diagauto.cabine.model.patient.Patient;
import diagauto.cabine.services.impl.InitialisationPatientServiceImpl;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@SpringBootTest
@FieldDefaults(level=AccessLevel.PRIVATE)
class TestInitialisationPatientService {
	
	@Mock
	AcquisitionDonneesCapteurService acquisitionDonneesCapteurService;
	
	@InjectMocks
	InitialisationPatientService initialisationPatientService = new InitialisationPatientServiceImpl();
	
	static Patient[] patients = new Patient[3];
	
	@BeforeAll
	public static void init() {
		patients[0] = new Patient("179072605774", 33);
		patients[1] = new Patient("278072605774", 55);
		patients[2] = new Patient("177072605774", 15);
	}
	
	@BeforeEach
	void setMockOutput() {
		when(acquisitionDonneesCapteurService.getPatientHealthIndex()).thenReturn(3);
	}
	
	@DisplayName("Test initialisationPatientService CreatePatientMedicalRecord")
	@Test
	void testCreatePatientMedicalRecord() {
		for(Patient patient : patients) {
			assertThat(initialisationPatientService.createPatientMedicalRecord(patient), is(notNullValue()));
			assertThat(initialisationPatientService.createPatientMedicalRecord(patient).getHealthIndex(), is(notNullValue()));
		}
	}
}
