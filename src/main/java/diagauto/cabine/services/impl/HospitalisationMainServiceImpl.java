package diagauto.cabine.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diagauto.cabine.model.activite.services.ServiceHospitalier;
import diagauto.cabine.model.parcours.Parcours;
import diagauto.cabine.model.pathologies.Pathologie;
import diagauto.cabine.model.patient.Patient;
import diagauto.cabine.services.AffectationPatientService;
import diagauto.cabine.services.DefinitionParcoursPatientService;
import diagauto.cabine.services.HospitalisationMainService;
import diagauto.cabine.services.InitialisationPatientService;

@Service
public class HospitalisationMainServiceImpl implements HospitalisationMainService {
	
	@Autowired InitialisationPatientService initPatientService;
	@Autowired DefinitionParcoursPatientService defParcoursService;
	@Autowired AffectationPatientService affectPatientService;

	@Override
	public List<ServiceHospitalier> getHealthServicesForPatient(Patient patient) {
		patient = initPatientService.createPatientMedicalRecord(patient);
		List<Pathologie> pathologies = defParcoursService.determinePathologies(patient.getHealthIndex());
		Parcours parcours = defParcoursService.determineParcours(pathologies);
		
		return affectPatientService.getServicesAffectationPatient(parcours.getDecisions());
	}
}
