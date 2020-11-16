package diagauto.cabine.services;

import java.util.List;

import diagauto.cabine.model.parcours.Parcours;
import diagauto.cabine.model.pathologies.Pathologie;

public interface DefinitionParcoursPatientService {

	public List<Pathologie> determinePathologies(int healthIndex);
	public Parcours determineParcours(List<Pathologie> pathologies);
}
