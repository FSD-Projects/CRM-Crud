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
	private String fName;
	@Column(name = "last_name")
	private String lName;
	@Column(name = "address")
	private String address;
	@Column(name = "customer_type")
	private String customerType;
	@Version
	private int version;

	public Customer(String fName, String lName, String address, String customerType) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.customerType = customerType;
	}
}
