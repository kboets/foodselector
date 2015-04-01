package foodselector.service;

import foodselector.domain.Meat;

public interface IMeatService extends IAbstractService<Meat, Long> {

	Meat findByName(String name);
}
