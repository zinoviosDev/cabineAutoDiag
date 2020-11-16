package diagauto.cabine.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import diagauto.cabine.model.activite.Decision;
import diagauto.cabine.model.activite.services.ServiceHospitalier;
import diagauto.cabine.services.AffectationPatientService;

@Service @Qualifier("affectationPatientService")
public class AffectationPatientServiceImpl implements AffectationPatientService {

	@Override
	public List<ServiceHospitalier> getServicesAffectationPatient(List<Decision> decisions) {
		
		List<ServiceHospitalier> servicesHosp = new ArrayList<>();
		for(Decision decision : decisions) {
			servicesHosp.add(decision.getService());
		}
		return servicesHosp;
	}

}
