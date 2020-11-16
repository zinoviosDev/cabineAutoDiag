package diagauto.cabine.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import diagauto.cabine.model.patient.Patient;
import diagauto.cabine.services.AcquisitionDonneesCapteurService;
import diagauto.cabine.services.InitialisationPatientService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Service @Qualifier("initialisationParcoursPatientService")
@FieldDefaults(level=AccessLevel.PRIVATE)
public class InitialisationPatientServiceImpl implements InitialisationPatientService {
	
	@Autowired AcquisitionDonneesCapteurService capteurService;

	@Override
	public Patient createPatientMedicalRecord(Patient patient) {
		
		int healthIndex = capteurService.getPatientHealthIndex();
		if(patient != null) {
			patient.setHealthIndex(healthIndex);
		}
		return patient;
	}
}
