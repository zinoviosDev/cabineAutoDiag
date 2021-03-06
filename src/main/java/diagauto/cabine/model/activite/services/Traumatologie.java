package diagauto.cabine.model.activite.services;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level=AccessLevel.PRIVATE)
@Getter @Setter @ToString
@EqualsAndHashCode(callSuper = true)
public class Traumatologie extends ServiceHospitalier {

	private static final long serialVersionUID = -4034114153151906593L;
	
	public Traumatologie(String nom, String code) {
		super(nom, code);
	}
}