package edu.miu.cs.cs544.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
@Table(name= "User")
public class User {

	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String password;
	private int enabled;
	private String role;
	
}
