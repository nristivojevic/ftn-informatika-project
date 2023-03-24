package ftni.jwd59.Zavrsni.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ftni.jwd59.Zavrsni.model.Utakmica;
import ftni.jwd59.Zavrsni.service.UtakmicaService;
import ftni.jwd59.Zavrsni.support.UtakmicaDtoToUtakmica;
import ftni.jwd59.Zavrsni.support.UtakmicaToUtakmicaDto;
import ftni.jwd59.Zavrsni.web.dto.UtakmicaDTO;

@RestController
@RequestMapping(value = "/api/utakmice")
@Validated
public class UtakmicaController {

	@Autowired
	private UtakmicaService service;
	@Autowired
	private UtakmicaToUtakmicaDto toDto;
	@Autowired
	private UtakmicaDtoToUtakmica to;

	@PreAuthorize("permitAll()")
	@GetMapping("/{id}")
	public ResponseEntity<UtakmicaDTO> getOne(@PathVariable Long id) {
		Utakmica e = service.findOne(id);
		if (e != null) {
			return new ResponseEntity<>(toDto.convert(e), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PreAuthorize("permitAll()")
	@GetMapping
	public ResponseEntity<List<UtakmicaDTO>> getAll(
			@RequestParam(value = "pageNo", defaultValue = "0") int pageNo) {

		Page<Utakmica> page;
		page = service.findAll(pageNo);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(page.getTotalPages()));

		return new ResponseEntity<>(toDto.convert(page.getContent()), headers, HttpStatus.OK);

	}

	@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UtakmicaDTO> create(@Valid @RequestBody UtakmicaDTO dto) {
		Utakmica e = to.convert(dto);
		if (e.getReprezentacijaA() == null && e.getReprezentacijaB() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Utakmica sacuvan = service.save(e);
		return new ResponseEntity<>(toDto.convert(sacuvan), HttpStatus.CREATED);
	}

	@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UtakmicaDTO> update(@PathVariable Long id, @Valid @RequestBody UtakmicaDTO dto) {
		if (!id.equals(dto.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Utakmica e = to.convert(dto);
		if (e.getReprezentacijaA() == null && e.getReprezentacijaB() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Utakmica sacuvan = service.save(e);
		return new ResponseEntity<>(toDto.convert(sacuvan), HttpStatus.OK);

	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Utakmica obrisan = service.delete(id);

		if (obrisan != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<Void> handler() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
