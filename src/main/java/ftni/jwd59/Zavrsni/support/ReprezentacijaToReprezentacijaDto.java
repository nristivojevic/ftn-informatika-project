package ftni.jwd59.Zavrsni.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftni.jwd59.Zavrsni.model.Reprezentacija;
import ftni.jwd59.Zavrsni.web.dto.ReprezentacijaDTO;

@Component
public class ReprezentacijaToReprezentacijaDto implements Converter<Reprezentacija, ReprezentacijaDTO> {

	@Override
	public ReprezentacijaDTO convert(Reprezentacija rep) {
		ReprezentacijaDTO dto = new ReprezentacijaDTO();
		dto.setId(rep.getId());
		dto.setNaziv(rep.getNaziv());
		dto.setOznaka(rep.getOznaka());

		return dto;
	}
	
	public List<ReprezentacijaDTO>convert(List<Reprezentacija>reprezentacije){
		List<ReprezentacijaDTO>dtos= new ArrayList<ReprezentacijaDTO>();
		
		for (Reprezentacija reprezentacija : reprezentacije) {
			dtos.add(convert(reprezentacija));
		}
		return dtos;
	}

}
