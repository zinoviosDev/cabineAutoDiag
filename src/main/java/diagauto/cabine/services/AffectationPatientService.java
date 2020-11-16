package diagauto.cabine.services;

import java.util.List;

import diagauto.cabine.model.activite.Decision;
import diagauto.cabine.model.activite.services.ServiceHospitalier;

public interface AffectationPatientService {

	public List<ServiceHospitalier> getServicesAffectationPatient(List<Decision> decisions);
	
}
