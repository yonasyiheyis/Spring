package edu.miu.cs.cs544.domain;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name= "Customers")
public class Customer {
	
	@Id
	@GeneratedValue
	private int id;
	@Size(max= 30)
	private String fname;
	@Size(max = 30)
	private String lname;
	@Temporal(TemporalType.DATE)
	@Past
	private Date bday;
	@Email
	private String email;
	
	public Customer(String fname, String lname, Date bday, String email) {
		this.fname = fname;
		this.lname = lname;
		this.bday = bday;
		this.email = email;
	}
	
	

}
