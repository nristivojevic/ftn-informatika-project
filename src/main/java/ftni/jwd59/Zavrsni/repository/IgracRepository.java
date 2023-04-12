package ftni.jwd59.Zavrsni.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftni.jwd59.Zavrsni.model.Igrac;

@Repository
public interface IgracRepository extends JpaRepository<Igrac, Long> {

	Igrac findOneById(Long id);

	Page<Igrac> findAll(Pageable pageable);

	Page<Igrac> findByPostignutiGoloviBetween(Integer odGol, Integer doGol, Pageable pageable);
}
