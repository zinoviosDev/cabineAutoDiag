package diagauto.cabine.model.activite.services;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level=AccessLevel.PRIVATE)
@Getter @Setter @ToString
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor @NoArgsConstructor
public abstract class ServiceHospitalier implements Serializable {

	private static final long serialVersionUID = -2491870555449940005L;
	
	String nom;
	String code;
}