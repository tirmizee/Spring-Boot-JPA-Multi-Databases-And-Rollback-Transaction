package com.tirmizee.jpa.maria.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="MOCKUP")
public class Mockup {

	@Id
	@Column(name="ID")
	private Integer id;
	
	@Column(name = "MOCKUP_NAME")
	private String mockupName;
	
	@Column(name = "MOCKUP_DESC")
	private String mockupDesc;
	
}
