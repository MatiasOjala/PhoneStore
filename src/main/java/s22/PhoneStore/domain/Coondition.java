package s22.PhoneStore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

// Minun täytyi muuttaa Condition -> Coonditioniksi, sillä oli ilmeisesti kielletty sana. Ainakaan SQL ei tykännyt.

@Entity
public class Coondition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long coonditionid;
	private String name;
	// Tiedot puhelimen kunnosta ja kunnon "nimi"
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="coondition")
	private List<Phone> phones;
	
	
	public Coondition() {
		
		super();
		// TODO Auto-generated constructor stub
	}


	public Coondition(String name) {
		super();
		this.name = name;
	}


	public Long getCoonditionid() {
		return coonditionid;
	}


	public void setCoonditionid(Long coonditionid) {
		this.coonditionid = coonditionid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Phone> getPhones() {
		return phones;
	}


	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}


	@Override
	public String toString() {
		return "Coondition [coonditionid=" + coonditionid + ", name=" + name + "]";
	}
	

}
