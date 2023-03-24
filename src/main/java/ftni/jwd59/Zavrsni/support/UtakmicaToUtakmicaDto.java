package ftni.jwd59.Zavrsni.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftni.jwd59.Zavrsni.model.Utakmica;
import ftni.jwd59.Zavrsni.web.dto.UtakmicaDTO;

@Component
public class UtakmicaToUtakmicaDto implements Converter<Utakmica, UtakmicaDTO>{

	@Override
	public UtakmicaDTO convert(Utakmica utakmica) {
		UtakmicaDTO dto= new UtakmicaDTO();
		
		dto.setId(utakmica.getId());
		dto.setBrojGolovaA(utakmica.getBrojGolovaA());
		dto.setBrojgolovaB(utakmica.getBrojGolovaB());
		dto.setReprezentacijaAId(utakmica.getReprezentacijaA().getId());
		dto.setReprezentacijaBId(utakmica.getReprezentacijaB().getId());
		dto.setReprezentacijaANaziv(utakmica.getReprezentacijaA().getNaziv());
		dto.setReprezentacijaBNaziv(utakmica.getReprezentacijaB().getNaziv());
		dto.setReprezentacijaBId(utakmica.getReprezentacijaB().getId());
		
		
		return dto;
	}
	
	public List<UtakmicaDTO>convert(List<Utakmica>utakmice){
		List<UtakmicaDTO>dtos=new ArrayList<UtakmicaDTO>();
		
		for (Utakmica utakmica : utakmice) {
			dtos.add(convert(utakmica));
		}
		return dtos;
	}

	
	
	
}
