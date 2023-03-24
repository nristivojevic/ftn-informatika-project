package ftni.jwd59.Zavrsni.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ftni.jwd59.Zavrsni.model.Utakmica;
import ftni.jwd59.Zavrsni.repository.UtakmicaRepository;
import ftni.jwd59.Zavrsni.service.UtakmicaService;

@Service
public class JpaUtakmicaService implements UtakmicaService {

	@Autowired
	private UtakmicaRepository repository;

	@Override
	public Utakmica findOne(Long id) {
		return repository.findOneById(id);
	}

	@Override
	public Page<Utakmica> findAll(int pageNo) {
		return repository.findAll(PageRequest.of(pageNo, 3));
	}

	@Override
	public Utakmica save(Utakmica e) {
		return repository.save(e);
	}

	@Override
	public Utakmica update(Utakmica e) {
		return repository.save(e);
	}

	@Override
	public Utakmica delete(Long id) {
		Utakmica utakmica = findOne(id);
		if (utakmica != null) {
			utakmica.setReprezentacijaA(null);
			utakmica.setReprezentacijaB(null);
			repository.delete(utakmica);
			return utakmica;
		}

		return null;
	}

}
