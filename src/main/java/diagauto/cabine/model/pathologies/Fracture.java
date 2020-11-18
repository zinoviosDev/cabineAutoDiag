package diagauto.cabine.model.pathologies;

import java.io.Serializable;
import java.util.List;

import diagauto.cabine.model.activite.services.ServiceHospitalier;
import diagauto.cabine.model.activite.services.Traumatologie;
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
public class Fracture extends Pathologie  implements Serializable {

	private static final long serialVersionUID = -2652885697618869642L;
	
	public Fracture(String nom, List<String> symptomes) {
		super(nom, symptomes);
	}

	@Override
	public ServiceHospitalier getServiceHospitalier() {
		return new Traumatologie("traumatologie", String.valueOf(RandomIntegers.getRandomIntBetween(1, 100000000)));
	}
	
}