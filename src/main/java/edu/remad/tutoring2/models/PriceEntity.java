package edu.remad.tutoring2.models;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "price_entity")
public class PriceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "price_id")
	private long id;

	@OneToOne
	@JoinColumn(name = "user", referencedColumnName = "id")
	private UserEntity user;

	private BigDecimal price;

	@OneToOne
	@JoinColumn(name = "serviceContract", referencedColumnName = "service_contract_no")
	private ServiceContractEntity serviceContract;

	public PriceEntity() {
	}

	public PriceEntity(long id, UserEntity user, BigDecimal price, ServiceContractEntity serviceContract) {
		this.id = id;
		this.user = user;
		this.price = price;
		this.serviceContract = serviceContract;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public ServiceContractEntity getServiceContract() {
		return serviceContract;
	}

	public void setServiceContract(ServiceContractEntity serviceContract) {
		this.serviceContract = serviceContract;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, price, serviceContract, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PriceEntity other = (PriceEntity) obj;
		return id == other.id && Objects.equals(price, other.price)
				&& Objects.equals(serviceContract, other.serviceContract) && user.getId() == other.user.getId();
	}

	@Override
	public String toString() {
		return "PriceEntity [id=" + id + ", user=" + user + ", price=" + price + ", serviceContract=" + serviceContract
				+ "]";
	}
}
