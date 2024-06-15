package edu.remad.tutoring2.models;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Stores complete address of an {@link UserEntity}
 */
@Entity
@Table(name = "Address")
public class AddressEntity {

	/**
	 * the primary key for an address
	 */
	@Id
	@Column(name="address_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	/**
	 * the street
	 */
	private String addressStreet;

	/**
	 * house number
	 */
	private String addressHouseNo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user")
	private UserEntity user;

	/**
	 * customer's zip code
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "zipcode_id", referencedColumnName = "id")
	private ZipCodeEntity addressZipCode;

	/**
	 * Constructor
	 *
	 * @param addressStreet  address's street
	 * @param addressHouseNo address's house number
	 * @param addressZipCode address's zipcode
	 */
	public AddressEntity(String addressStreet, String addressHouseNo, ZipCodeEntity addressZipCode) {
		this.addressStreet = addressStreet;
		this.addressHouseNo = addressHouseNo;
		this.addressZipCode = addressZipCode;
	}

	/**
	 * Constructor
	 * 
	 * @param id             address's id
	 * @param addressStreet  address's street
	 * @param addressHouseNo address's house number
	 * @param addressZipCode address's zipcode
	 */
	public AddressEntity(Long id, String addressStreet, String addressHouseNo, ZipCodeEntity addressZipCode) {
		this.id = id;
		this.addressStreet = addressStreet;
		this.addressHouseNo = addressHouseNo;
		this.addressZipCode = addressZipCode;
	}
	
	/**
	 * Constructor
	 * 
	 * @param id             address's id
	 * @param addressStreet  address's street
	 * @param addressHouseNo address's house number
	 * @param user user's entity
	 * @param addressZipCode address's zipcode
	 */
	public AddressEntity(Long id, String addressStreet, String addressHouseNo, UserEntity user, ZipCodeEntity addressZipCode) {
		this.id = id;
		this.addressStreet = addressStreet;
		this.addressHouseNo = addressHouseNo;
		this.user = user;
		this.addressZipCode = addressZipCode;
	}

	/**
	 * Constructor
	 */
	public AddressEntity() {
	}

	/**
	 * Gets Id
	 *
	 * @return Adress's Id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Gets street
	 *
	 * @return adress's street
	 */
	public String getAddressStreet() {
		return addressStreet;
	}

	/**
	 * Sets street
	 *
	 * @param addressStreet address's street to set
	 */
	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	/**
	 * Gets house number
	 *
	 * @return address's house number
	 */
	public String getAddressHouseNo() {
		return addressHouseNo;
	}

	/**
	 * Sets house number
	 *
	 * @param addressHouseNo address's house number
	 */
	public void setAddressHouseNo(String addressHouseNo) {
		this.addressHouseNo = addressHouseNo;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public ZipCodeEntity getAddressZipCode() {
		return addressZipCode;
	}

	public void setAddressZipCode(ZipCodeEntity addressZipCode) {
		this.addressZipCode = addressZipCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(addressHouseNo, addressStreet, addressZipCode, id, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressEntity other = (AddressEntity) obj;
		return Objects.equals(addressHouseNo, other.addressHouseNo)
				&& Objects.equals(addressStreet, other.addressStreet)
				&& Objects.equals(addressZipCode, other.addressZipCode) && id == other.id
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "AddressEntity [id=" + id + ", addressStreet=" + addressStreet + ", addressHouseNo=" + addressHouseNo
				+ ", user=" + user + ", addressZipCode=" + addressZipCode + "]";
	}
}
