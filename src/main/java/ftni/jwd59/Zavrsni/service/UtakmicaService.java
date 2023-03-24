package ftni.jwd59.Zavrsni.service;

import org.springframework.data.domain.Page;

import ftni.jwd59.Zavrsni.model.Utakmica;

public interface UtakmicaService {

	Utakmica findOne(Long id);

	Page<Utakmica> findAll(int pageNo);

	Utakmica save(Utakmica e);

	Utakmica update(Utakmica e);

	Utakmica delete(Long id);
	
}
