package ftni.jwd59.Zavrsni.web.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ftni.jwd59.Zavrsni.model.Igrac;
import ftni.jwd59.Zavrsni.service.IgracService;
import ftni.jwd59.Zavrsni.support.IgracDtoToIgrac;
import ftni.jwd59.Zavrsni.support.IgracToIgracDto;
import ftni.jwd59.Zavrsni.web.dto.IgracDTO;

@RestController
@RequestMapping(value = "/api/igraci", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class IgracController {

	@Autowired
	private IgracService service;
	@Autowired
	private IgracToIgracDto toDto;
	@Autowired
	private IgracDtoToIgrac to;

	@PreAuthorize("permitAll()")
	@GetMapping
	public ResponseEntity<List<IgracDTO>> getAll(@RequestParam(required = false) Long reprezentacijaId,
			@RequestParam(required = false) Integer odGol,
			@RequestParam(required = false) Integer doGol,
			@RequestParam(value = "pageNo", defaultValue = "0") int pageNo) {

		Page<Igrac> page;
		page = service.find(reprezentacijaId, odGol, doGol, pageNo);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(page.getTotalPages()));

		return new ResponseEntity<>(toDto.convert(page.getContent()), headers, HttpStatus.OK);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<IgracDTO> getOne(@PathVariable Long id) {
		Igrac igrac=service.findOne(id);
		if (igrac != null) {
			return new ResponseEntity<>(toDto.convert(igrac), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IgracDTO> update(@PathVariable Long id, @RequestBody IgracDTO dto) {
		if (!id.equals(dto.getId())) {
			return new ResponseEntity<IgracDTO>(HttpStatus.BAD_REQUEST);
		}
		Igrac igrac = to.convert(dto);
		Igrac sacuvan = service.update(igrac);
		return new ResponseEntity<>(toDto.convert(sacuvan), HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Igrac obrisan = service.delete(id);

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
