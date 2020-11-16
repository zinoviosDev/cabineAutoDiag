package diagauto.cabine.model.activite;

import java.io.Serializable;

import diagauto.cabine.model.activite.services.ServiceHospitalier;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level=AccessLevel.PRIVATE)
@Getter @Setter @ToString
@EqualsAndHashCode(callSuper = false)
public class Decision  implements Serializable {
	
	private static final long serialVersionUID = 1144844718735828042L;
	
	String code;
	String description;
	
	ServiceHospitalier service;
	
}