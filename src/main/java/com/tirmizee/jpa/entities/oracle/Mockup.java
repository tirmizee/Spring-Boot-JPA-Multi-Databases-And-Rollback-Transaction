package com.tirmizee.jpa.entities.oracle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="MOCKUP")
public class Mockup {

	@Id
	@Column(name="ID")
	@SequenceGenerator(name="seqMockup", sequenceName="MOCKUP_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqMockup")
	private Integer id;
	
	@Column(name = "MOCKUP_NAME")
	private String mockupName;
	
	@Column(name = "MOCKUP_DESC")
	private String mockupDesc;
	
}
