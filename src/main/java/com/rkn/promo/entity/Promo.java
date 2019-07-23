package com.rkn.promo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Data
@ToString(callSuper = true)
@Entity
@Table(name = "promo")
public class Promo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String kode_promo;
	private Date start_valid_date;
	
	@Column
	private Date end_valid_date;
	
	private Long kuota;



}
