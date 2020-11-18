package diagauto.cabine.model.pathologies;

import java.io.Serializable;
import java.util.List;

import diagauto.cabine.model.activite.services.Cardiologie;
import diagauto.cabine.model.activite.services.ServiceHospitalier;
import diagauto.cabine.util.math.RandomIntegers;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level=AccessLevel.PRIVATE)
@Getter @Setter @ToString
@EqualsAndHashCode(callSuper = false)
public class ProblemeCardiaque extends Pathologie  implements Serializable {
	
	public ProblemeCardiaque(String nom, List<String> symptomes) {
		super(nom, symptomes);
	}

	private static final long serialVersionUID = 8665997904725113645L;

	public ServiceHospitalier getServiceHospitalier() {
		return new Cardiologie("cardiologie", String.valueOf(RandomIntegers.getRandomIntBetween(1, 100000000)));
	}
}