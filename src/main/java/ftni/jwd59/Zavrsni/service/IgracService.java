package ftni.jwd59.Zavrsni.service;


import org.springframework.data.domain.Page;

import ftni.jwd59.Zavrsni.model.Igrac;

public interface IgracService {

	Igrac findOne(Long id);

	Page<Igrac> findAll(int pageNo);

	Igrac update(Igrac igrac);

	Igrac delete(Long id);
	
	Page<Igrac>find(Long reprezentacijaId, int pageNo);
}
