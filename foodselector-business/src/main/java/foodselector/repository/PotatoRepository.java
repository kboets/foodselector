package foodselector.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import foodselector.domain.Potato;

public interface PotatoRepository extends JpaRepository<Potato, Long> {

	@Query("select p from Potato p where p.potatoType = ?1")
	Potato findByDescriptionCode(String description);
}
