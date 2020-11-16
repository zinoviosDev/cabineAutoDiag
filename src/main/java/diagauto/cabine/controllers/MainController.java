package diagauto.cabine.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import diagauto.cabine.model.activite.services.ServiceHospitalier;
import diagauto.cabine.model.parcours.Parcours;
import diagauto.cabine.model.pathologies.Pathologie;
import diagauto.cabine.model.patient.Patient;
import diagauto.cabine.services.AffectationPatientService;
import diagauto.cabine.services.DefinitionParcoursPatientService;
import diagauto.cabine.services.InitialisationPatientService;

@Controller
public class MainController {
	
	@Autowired InitialisationPatientService initPatientService;
	@Autowired DefinitionParcoursPatientService defParcoursService;
	@Autowired AffectationPatientService affectPatientService;

	@GetMapping("/")
	public String home(Model model) {
		Patient patient = new Patient(null);
		patient.setPrenom("Paul");
		
		patient = initPatientService.createPatientMedicalRecord(patient);
		List<Pathologie> pathologies = defParcoursService.determinePathologies(patient.getHealthIndex());
		Parcours parcours = defParcoursService.determineParcours(pathologies);
		List<ServiceHospitalier> servicesHospitaliers = affectPatientService.getServicesAffectationPatient(parcours.getDecisions());
		
		model.addAttribute("patient", patient);
		model.addAttribute("services", servicesHospitaliers);
		return "home :: parcours_patient";
	}
}
