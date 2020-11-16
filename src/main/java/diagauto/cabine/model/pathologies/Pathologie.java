package diagauto.cabine.model.pathologies;

import java.io.Serializable;
import java.util.List;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level=AccessLevel.PRIVATE)
@Getter @Setter @ToString
@EqualsAndHashCode(callSuper = false)
public abstract class Pathologie  implements Serializable {

	static final long serialVersionUID = -9205218402314389685L;
	
	String nom;
	List<String> symptomes;
	
	public Pathologie(String nom, List<String> symptomes) {
		this.nom = nom;
		this.symptomes = symptomes;
	}
}