package foodselector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import foodselector.domain.VegetablesFamily;
import foodselector.repository.VegetablesFamilyRepository;

@Service
public class VegetablesFamilyService extends AbstractService<VegetablesFamily, Long> implements	IVegetablesFamilyService {

	private VegetablesFamilyRepository vegetablesFamilyRepository;

	@Autowired
	public void setVegetablesFamilyRepository(VegetablesFamilyRepository vegetablesFamilyRepository) {		
		this.vegetablesFamilyRepository = vegetablesFamilyRepository;
		super.setRepository(vegetablesFamilyRepository);
	}
	
	
}
