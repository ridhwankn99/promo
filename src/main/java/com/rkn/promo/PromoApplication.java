package com.rkn.promo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rkn.promo.dao.PromoDao;
import com.rkn.promo.entity.Promo;

@SpringBootApplication
public class PromoApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(PromoApplication.class, args);
	}
	
	@Autowired
	private PromoDao promoDao;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		//promoDao.findAll().forEach(System.out::println);
		///Date dateValid = promoDao.findEndDate("EA234B");
//		Promo promo = new Promo();
		//System.out.println(promoDao.findEndDate("EA234B"));

//		promoDao.findEndDate("EA234B");
		
//		System.out.println(promoDao.findEndDate("EA234B"));
	}
	

}
