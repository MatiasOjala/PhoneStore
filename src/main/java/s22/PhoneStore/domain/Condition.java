package s22.PhoneStore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Condition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long conditionid;
	private String name;
	// Tiedot puhelimen kunnosta ja kunnon "nimi"
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="condition")
	private List<Phone> phones;
	
	
	public Condition() {
		
		super();
		// TODO Auto-generated constructor stub
	}


	public Condition(String name) {
		super();
		this.name = name;
	}


	public Long getConditionid() {
		return conditionid;
	}


	public void setConditionid(Long conditionid) {
		this.conditionid = conditionid;
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
		return "Condition [conditionid=" + conditionid + ", name=" + name + "]";
	}
	

}
