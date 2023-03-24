package ftni.jwd59.Zavrsni.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ftni.jwd59.Zavrsni.model.Reprezentacija;
import ftni.jwd59.Zavrsni.repository.ReprezentacijaRepository;
import org.springframework.stereotype.Service;

import ftni.jwd59.Zavrsni.service.ReprezentacijaService;

@Service
public class JpaReprezentacijaService implements ReprezentacijaService {

	@Autowired
	private ReprezentacijaRepository repository;

	@Override
	public Reprezentacija findOne(Long id) {
		return repository.findOneById(id);
	}

	@Override
	public List<Reprezentacija> findAll() {
		return repository.findAll();
	}

}
