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
public class Cardiologie extends ServiceHospitalier {

	private static final long serialVersionUID = -6585258071354244835L;
	
	public Cardiologie(String nom, String code) {
		super(nom, code);
	}
}