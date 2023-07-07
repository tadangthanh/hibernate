package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "manufacturer")
public class Manufacturer implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String country;
	@ManyToMany
	@JoinTable(name = "prod_manufacturer", joinColumns = @JoinColumn(name = "manufacturer_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
//	@ManyToMany(mappedBy = "manufacturers")
	private Set<Product> products = new HashSet<>();

	public Manufacturer() {
		// TODO Auto-generated constructor stub
	}

	public Manufacturer(int id, String name, String country, Set<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Manufacturer [id=" + id + ", name=" + name + ", country=" + country + "]";
	}

}
