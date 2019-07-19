package com.rkn.promo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
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
	private String start_valid_date;
	private String end_valid_date;
	
	private long kuota;

}
