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

import ftni.jwd59.Zavrsni.model.Igrac;
import ftni.jwd59.Zavrsni.service.IgracService;
import ftni.jwd59.Zavrsni.support.IgracToIgracDto;
import ftni.jwd59.Zavrsni.web.dto.IgracDTO;

@RestController
@RequestMapping(value = "/api/igraci", produces = MediaType.APPLICATION_JSON_VALUE)
public class IgracController {

	@Autowired
	private IgracService service;
	@Autowired
	private IgracToIgracDto toDto;

	@PreAuthorize("permitAll()")
	@GetMapping
	public ResponseEntity<List<IgracDTO>> getAll() {

		List<Igrac> lista = service.findAll();
		return new ResponseEntity<>(toDto.convert(lista), HttpStatus.OK);
	}

}
