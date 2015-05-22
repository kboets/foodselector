package foodselector.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import foodselector.domain.Spices;

public interface SpicesRepository extends JpaRepository<Spices, Long> {

}
