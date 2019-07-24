package com.rkn.promo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;



@ToString(callSuper = true)
@Entity
@Table(name = "promo")
public class Promo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String kode_promo;
	
	private Date start_valid_date;
	
	private Date end_valid_date;
	
	private Long kuota;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKode_promo() {
		return kode_promo;
	}

	public void setKode_promo(String kode_promo) {
		this.kode_promo = kode_promo;
	}

	public Date getStart_valid_date() {
		return start_valid_date;
	}

	public void setStart_valid_date(Date start_valid_date) {
		this.start_valid_date = start_valid_date;
	}

	public Date getEnd_valid_date() {
		return end_valid_date;
	}

	public void setEnd_valid_date(Date end_valid_date) {
		this.end_valid_date = end_valid_date;
	}

	public Long getKuota() {
		return kuota;
	}

	public void setKuota(Long kuota) {
		this.kuota = kuota;
	}


}
