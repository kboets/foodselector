package foodselector.repository;

import org.springframework.data.repository.CrudRepository;

import foodselector.domain.Pasta;

public interface PastaRepository extends CrudRepository<Pasta, Long> {

}
