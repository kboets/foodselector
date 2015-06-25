package foodselector.service;

import foodselector.domain.Potato;

public interface IPotatoService extends IAbstractService<Potato, Long> {

	Potato findByDescriptionCode(String descriptionCode);
}
