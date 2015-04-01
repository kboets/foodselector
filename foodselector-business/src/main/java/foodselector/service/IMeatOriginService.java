package foodselector.service;

import foodselector.domain.MeatOrigin;

public interface IMeatOriginService extends IAbstractService<MeatOrigin, Long>{

	MeatOrigin getMeatOriginByName(String name);
}
