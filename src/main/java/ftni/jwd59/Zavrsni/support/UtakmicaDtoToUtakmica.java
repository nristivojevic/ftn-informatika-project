package ftni.jwd59.Zavrsni.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftni.jwd59.Zavrsni.model.Utakmica;
import ftni.jwd59.Zavrsni.service.ReprezentacijaService;
import ftni.jwd59.Zavrsni.service.UtakmicaService;
import ftni.jwd59.Zavrsni.web.dto.UtakmicaDTO;

@Component
public class UtakmicaDtoToUtakmica implements Converter<UtakmicaDTO, Utakmica>{

	@Autowired
	private UtakmicaService utakmicaService;
	@Autowired
	private ReprezentacijaService reprezentacijaService;
	
	@Override
	public Utakmica convert(UtakmicaDTO dto) {
		Utakmica utakmica;
		
		if (dto.getId() ==null) {
			utakmica=new Utakmica();
		}else {
			utakmica=utakmicaService.findOne(dto.getId());
		}
		if (utakmica !=null) {
			utakmica.setBrojGolovaA(dto.getBrojGolovaA());
			utakmica.setBrojGolovaB(dto.getBrojGolovaB());
			utakmica.setReprezentacijaA(reprezentacijaService.findOne(dto.getReprezentacijaAId()));
			utakmica.setReprezentacijaB(reprezentacijaService.findOne(dto.getReprezentacijaBId()));

			
			
		}
		
		
		return utakmica;
	}

	
	
}
