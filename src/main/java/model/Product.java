package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private BigDecimal price;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private Category category;
	@ManyToMany(mappedBy = "products")
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "product_manufacturer", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "manufacturer_id"))
	private Set<Manufacturer> manufacturers = new HashSet<>();

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String name, String description, BigDecimal price, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Manufacturer> getManufacturers() {
		return manufacturers;
	}

	public void setManufacturers(Set<Manufacturer> manufacturers) {
		this.manufacturers = manufacturers;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", category=" + category + "]";
	}

}
