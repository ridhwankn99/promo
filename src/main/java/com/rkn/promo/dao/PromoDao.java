package com.rkn.promo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rkn.promo.entity.Promo;

@Repository
public interface PromoDao extends JpaRepository<Promo, Long>{
	

}
