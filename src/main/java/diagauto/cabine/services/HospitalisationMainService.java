package diagauto.cabine.services;

import java.util.List;

import diagauto.cabine.model.activite.services.ServiceHospitalier;
import diagauto.cabine.model.patient.Patient;

public interface HospitalisationMainService {

	public List<ServiceHospitalier> getHealthServicesForPatient(Patient patient);
}
