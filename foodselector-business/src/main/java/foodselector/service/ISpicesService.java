package foodselector.service;

import org.springframework.data.domain.Page;

import foodselector.domain.Spices;

public interface ISpicesService extends IAbstractService<Spices, Long> {

	Page<Spices> getSpicesPage(Integer pageNumber);
}
