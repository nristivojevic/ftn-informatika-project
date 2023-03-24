package ftni.jwd59.Zavrsni.web.dto;

public class UtakmicaDTO {
	
	private Long id;
	
	private Long reprezentacijaAId;
	
	private Long reprezentacijaBId;
	
	private String reprezentacijaBNaziv;
	
	private String reprezentacijaANaziv;
	
	
	private int brojGolovaA;
	
	private int brojGolovaB;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getReprezentacijaAId() {
		return reprezentacijaAId;
	}

	public void setReprezentacijaAId(Long reprezentacijaAId) {
		this.reprezentacijaAId = reprezentacijaAId;
	}

	public long getReprezentacijaBId() {
		return reprezentacijaBId;
	}

	public void setReprezentacijaBId(Long reprezentacijaBId) {
		this.reprezentacijaBId = reprezentacijaBId;
	}

	public int getBrojGolovaA() {
		return brojGolovaA;
	}

	public void setBrojGolovaA(int brojGolovaA) {
		this.brojGolovaA = brojGolovaA;
	}

	public int getBrojGolovaB() {
		return brojGolovaB;
	}

	public void setBrojgolovaB(int brojGolovaB) {
		this.brojGolovaB = brojGolovaB;
	}

	public String getReprezentacijaBNaziv() {
		return reprezentacijaBNaziv;
	}

	public void setReprezentacijaBNaziv(String reprezentacijaBNaziv) {
		this.reprezentacijaBNaziv = reprezentacijaBNaziv;
	}

	public String getReprezentacijaANaziv() {
		return reprezentacijaANaziv;
	}

	public void setReprezentacijaANaziv(String reprezentacijaANaziv) {
		this.reprezentacijaANaziv = reprezentacijaANaziv;
	}

	public void setBrojGolovaB(int brojGolovaB) {
		this.brojGolovaB = brojGolovaB;
	}
	
	
	

}
