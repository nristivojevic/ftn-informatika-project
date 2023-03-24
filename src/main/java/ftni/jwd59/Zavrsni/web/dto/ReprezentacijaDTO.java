package ftni.jwd59.Zavrsni.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ReprezentacijaDTO {

	private Long id;
	@NotBlank(message = "Naziv nije unet")
	private String naziv;

	@Size(min = 3, max = 3, message = "Troslovna oznaka")
	private String oznaka;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOznaka() {
		return oznaka;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

}
