package com.rkn.promo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rkn.promo.entity.Promo;

@Repository
public interface PromoDao extends JpaRepository<Promo, Long>{
	@Query("SELECT b FROM Promo b WHERE b.kode_promo =kode_promo")
	public Promo findKodePromo(@Param ("kode_promo") String kode_promo);

//	Promo findOne(String kode_promo);
	

}
