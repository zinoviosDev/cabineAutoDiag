package diagauto.cabine.services.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import diagauto.cabine.services.AcquisitionDonneesCapteurService;
import diagauto.cabine.util.math.Multiple;
import diagauto.cabine.util.math.RandomIntegers;

@Service @Qualifier("acquisitionDonneesCapteurService")
public class AcquisitionDonneesCapteurServiceImpl implements AcquisitionDonneesCapteurService {
	
	public Integer getPatientHealthIndex() {
		return simulateGetDatasFromSensor();
	}
	
	private static int simulateGetDatasFromSensor() {
		int result = 1;
		int randomBetween0And3 = RandomIntegers.getRandomIntBetween(0, 3);
		
		while (result == 1) {
			switch (randomBetween0And3) {
			case 1:
				result = Multiple.generateMultipleOfThree();
				break;
			case 2:
				result = Multiple.generateMultipleOfFive();
				break;
			case 3:
				result = Multiple.generateMultipleOfThreeAndFive();
				break;
			default: // Aucun problème de santé
				result = 0;
			}
		}
		
		return result;
	}

}
