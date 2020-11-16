package diagauto.cabine.model.patient;

import java.io.Serializable;
import java.util.List;

import diagauto.cabine.model.parcours.Parcours;
import diagauto.cabine.model.pathologies.Pathologie;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level=AccessLevel.PRIVATE)
@Getter @Setter @ToString
@EqualsAndHashCode(callSuper = false)
public class Patient implements Serializable {

	static final long serialVersionUID = 1958476081780821740L;
	
	String ssn;
	String prenom;
	Integer healthIndex;
	
	Parcours parcours;
	List<Pathologie> pathologies;
	
	public Patient(String ssn, Integer healthIndex) {
		this.ssn = ssn;
		this.healthIndex = healthIndex;
	}

	public Patient(String ssn) {
		this.ssn = ssn;
	}
	
	
}