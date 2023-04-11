package ftni.jwd59.Zavrsni.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftni.jwd59.Zavrsni.model.Igrac;
import ftni.jwd59.Zavrsni.service.IgracService;
import ftni.jwd59.Zavrsni.service.ReprezentacijaService;
import ftni.jwd59.Zavrsni.web.dto.IgracDTO;

@Component
public class IgracDtoToIgrac implements Converter<IgracDTO, Igrac> {

	@Autowired
	private IgracService igracService;
	@Autowired
	private ReprezentacijaService reprezentacijaService;

	@Override
	public Igrac convert(IgracDTO dto) {
		Igrac igrac;
		if (dto.getId() == null) {
			igrac = new Igrac();
		} else {
			igrac = igracService.findOne(dto.getId());
		}
		if (igrac != null) {
			igrac.setIme(dto.getIme());
			igrac.setPrezime(dto.getPrezime());
			igrac.setPostignutiGolovi(dto.getPostignutiGolovi());
			igrac.setReprezentacija(reprezentacijaService.findOne(dto.getReprezentacijaId()));

		}
		return igrac;
	}

}
