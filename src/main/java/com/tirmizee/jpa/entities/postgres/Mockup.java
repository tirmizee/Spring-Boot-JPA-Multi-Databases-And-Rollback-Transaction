package com.tirmizee.jpa.entities.postgres;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
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
