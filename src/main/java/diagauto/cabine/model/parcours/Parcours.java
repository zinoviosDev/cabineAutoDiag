package diagauto.cabine.model.parcours;

import java.io.Serializable;
import java.util.List;

import diagauto.cabine.model.activite.Decision;
import diagauto.cabine.model.activite.services.ServiceHospitalier;
import diagauto.cabine.model.pathologies.Pathologie;
import diagauto.cabine.model.patient.Patient;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level=AccessLevel.PRIVATE)
@Getter @Setter @ToString
@EqualsAndHashCode(callSuper = false)
public class Parcours  implements Serializable {

	static final long serialVersionUID = -2811520365834148331L;
	
	String identifiant;

	Patient patient;
	List<Pathologie> pathologies;
	List<Decision> decisions;
	List<ServiceHospitalier> services;
}