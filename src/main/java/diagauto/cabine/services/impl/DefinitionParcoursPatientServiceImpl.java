package diagauto.cabine.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import diagauto.cabine.model.activite.Decision;
import diagauto.cabine.model.activite.services.Cardiologie;
import diagauto.cabine.model.activite.services.ServiceHospitalier;
import diagauto.cabine.model.activite.services.Traumatologie;
import diagauto.cabine.model.parcours.Parcours;
import diagauto.cabine.model.pathologies.Fracture;
import diagauto.cabine.model.pathologies.Pathologie;
import diagauto.cabine.model.pathologies.ProblemeCardiaque;
import diagauto.cabine.services.DefinitionParcoursPatientService;
import diagauto.cabine.util.math.Multiple;
import diagauto.cabine.util.math.RandomIntegers;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Service @Qualifier("definitionParcoursPatientService")
@FieldDefaults(level=AccessLevel.PRIVATE)
public class DefinitionParcoursPatientServiceImpl implements DefinitionParcoursPatientService {

	@Override
	public List<Pathologie> determinePathologies(int healthIndex) {
		List<Pathologie> pathologies = new ArrayList<>();
		if(healthIndex == 0) {
			// aucune pathologie
		}
		else if(Multiple.isMultipleOfThreeAndFive(healthIndex)) {
			pathologies.add(new Fracture("fracture", null));
			pathologies.add(new ProblemeCardiaque("cardiaque", null));
		}
		else if(Multiple.isMultipleOfThree(healthIndex)) {
			pathologies.add(new ProblemeCardiaque("cardiaque",null));
		}
		else if(Multiple.isMultipleOfFive(healthIndex)) {
			pathologies.add(new Fracture("fracture", null));
		}
		return pathologies;
	}

	@Override
	public Parcours determineParcours(List<Pathologie> pathologies) {

		Parcours parcours = new Parcours();
		parcours.setIdentifiant(String.valueOf(RandomIntegers.getRandomIntBetween(1, 100000000)));
		parcours.setPathologies(pathologies);
		
		List<Decision> decisions = new ArrayList<>();
		for(Pathologie pathologie : pathologies) {
			Decision decision = new Decision();
			decision.setCode(String.valueOf(RandomIntegers.getRandomIntBetween(1, 100000000)));
			decision.setDescription("pathologie " + pathologie.getNom());
			decision.setService(this.findServiceForPathologie(pathologie));
			decisions.add(decision);
		}
		parcours.setDecisions(decisions);
		return parcours;
	}
	
	private ServiceHospitalier findServiceForPathologie(Pathologie pathologie) {
		ServiceHospitalier service = null;
		if(pathologie instanceof Fracture) {
			service = new Traumatologie("traumatologie", String.valueOf(RandomIntegers.getRandomIntBetween(1, 100000000)));
		}
		else if(pathologie instanceof ProblemeCardiaque) {
			service = new Cardiologie("cardiologie", String.valueOf(RandomIntegers.getRandomIntBetween(1, 100000000)));
		}
		return service;
	}

}
