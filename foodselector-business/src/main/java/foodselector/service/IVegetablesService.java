package foodselector.service;

import foodselector.domain.Vegetables;

public interface IVegetablesService extends IAbstractService<Vegetables, Long> {

	Vegetables findByName(String name);
}
