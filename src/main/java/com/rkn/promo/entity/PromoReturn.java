package com.rkn.promo.entity;

import java.util.Date;

public class PromoReturn {
	private String kode_promo;
	
	private int discount;
	
	private Long sisa_kuota;

	public String getKode_promo() {
		return kode_promo;
	}

	public void setKode_promo(String kode_promo) {
		this.kode_promo = kode_promo;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Long getSisa_kuota() {
		return sisa_kuota;
	}

	public void setSisa_kuota(Long sisa_kuota) {
		this.sisa_kuota = sisa_kuota;
	}

	

	
	

}
