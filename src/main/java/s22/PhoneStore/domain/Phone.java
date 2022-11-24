package s22.PhoneStore.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Phone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String make, model, capacity;
	private int makeYear;
	private double price;
	// Tiedot mitä itse puhelin pitää sisällään.
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="coonditionid")
	private Coondition coondition;
	
	
	public Phone() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Phone(Long id, String make, String model, String capacity, int makeYear, double price, Coondition coondition) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.capacity = capacity;
		this.makeYear = makeYear;
		this.price = price;
		this.coondition = coondition;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getCapacity() {
		return capacity;
	}


	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}


	public int getMakeYear() {
		return makeYear;
	}


	public void setMakeYear(int makeYear) {
		this.makeYear = makeYear;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Coondition getCoondition() {
		return coondition;
	}


	public void setCoondition(Coondition coondition) {
		this.coondition = coondition;
	}


	@Override
	public String toString() {
		return "Phone [id=" + id + ", make=" + make + ", model=" + model + ", capacity=" + capacity + ", makeYear="
				+ makeYear + ", price=" + price + ", coondition=" + coondition + "]";
	}
	
	
}
