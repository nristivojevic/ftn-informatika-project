package ftni.jwd59.Zavrsni.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftni.jwd59.Zavrsni.model.Igrac;
import ftni.jwd59.Zavrsni.web.dto.IgracDTO;


@Component
public class IgracToIgracDto  implements Converter<Igrac, IgracDTO>{

	@Override
	public IgracDTO convert(Igrac igrac) {
		IgracDTO dto= new IgracDTO();
		dto.setId(igrac.getId());
		dto.setIme(igrac.getIme());
		//napisao sam za prezime getIme()
		dto.setPrezime(igrac.getPrezime());
		dto.setPostignutiGolovi(igrac.getPostignutiGolovi());
		return dto;
	}
	
	public List<IgracDTO>convert(List<Igrac>igraci){
		List<IgracDTO>dtos=new ArrayList<IgracDTO>();
		
		for (Igrac igrac : igraci) {
			dtos.add(convert(igrac));
		}
		return dtos;
	}
	

}
