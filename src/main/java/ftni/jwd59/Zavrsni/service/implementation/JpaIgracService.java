package ftni.jwd59.Zavrsni.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ftni.jwd59.Zavrsni.model.Igrac;
import ftni.jwd59.Zavrsni.repository.IgracRepository;
import ftni.jwd59.Zavrsni.service.IgracService;

@Service
public class JpaIgracService implements IgracService {

	@Autowired
	private IgracRepository repository;

	@Override
	public Igrac findOne(Long id) {
		return repository.findOneById(id);
	}

	@Override
	public Page<Igrac> findAll(int pageNo) {
		return repository.findAll(PageRequest.of(pageNo, 5));
	}

	@Override
	public Igrac update(Igrac igrac) {
		return repository.save(igrac);
	}

	@Override
	public Igrac delete(Long id) {
		Igrac igrac = findOne(id);
		if (igrac != null) {
			igrac.setReprezentacija(null);
			repository.delete(igrac);
			return igrac;
		}
		return null;
	}

	@Override
	public Page<Igrac> find(Long reprezentacijaId, int pageNo) {
		if (reprezentacijaId == null) {
			return repository.findAll(PageRequest.of(pageNo, 5));
		}
		return repository.findByReprezentacijaId(reprezentacijaId, PageRequest.of(pageNo, 3));
	}
}
