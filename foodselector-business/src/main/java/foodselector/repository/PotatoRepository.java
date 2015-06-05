package foodselector.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import foodselector.domain.Potato;

public interface PotatoRepository extends JpaRepository<Potato, Long> {

}
