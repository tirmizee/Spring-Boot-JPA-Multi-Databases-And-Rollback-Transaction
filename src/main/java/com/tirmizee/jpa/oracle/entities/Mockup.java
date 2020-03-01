package com.tirmizee.jpa.oracle.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
	@SequenceGenerator(name="seqMockup", sequenceName="MOCKUP_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqMockup")
	private Integer id;
	
	@Column(name = "MOCKUP_NAME")
	private String mockupName;
	
	@Column(name = "MOCKUP_DESC")
	private String mockupDesc;
	
}
