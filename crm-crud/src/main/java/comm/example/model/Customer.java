package comm.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "Customer")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "address")
	private String address;
	@Column(name = "customer_type")
	private String customerType;
	@Version
	private int version;

	public Customer(String firstName, String lastName, String address, String customerType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.customerType = customerType;
	}
}
