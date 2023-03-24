package ftni.jwd59.Zavrsni.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftni.jwd59.Zavrsni.model.Reprezentacija;
import ftni.jwd59.Zavrsni.service.ReprezentacijaService;
import ftni.jwd59.Zavrsni.support.ReprezentacijaToReprezentacijaDto;
import ftni.jwd59.Zavrsni.web.dto.ReprezentacijaDTO;

@RestController
@RequestMapping(value = "/api/reprezentacije", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReprezentacijaController {
	@Autowired
	private ReprezentacijaService reprezentacijaService;
	@Autowired
	private ReprezentacijaToReprezentacijaDto toReprezentacijaDto;

	@PreAuthorize("permitAll()")
	@GetMapping
	public ResponseEntity<List<ReprezentacijaDTO>> getAll() {

		List<Reprezentacija> lista = reprezentacijaService.findAll();
		return new ResponseEntity<>(toReprezentacijaDto.convert(lista), HttpStatus.OK);
	}

}
