package com.rkn.promo.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rkn.promo.entity.Promo;
import com.rkn.promo.entity.PromoReturn;

@Service
public class PromoService {
	
	private final KieContainer kieContainer;

	@Autowired
	public PromoService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}
	

	public PromoReturn getPromoDiscount(Promo promo) {
		//get the stateful session
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		PromoReturn promoReturn = new PromoReturn();
		kieSession.insert(promo);
		kieSession.insert(promoReturn);
		kieSession.fireAllRules();
		kieSession.dispose();
		return promoReturn;
	}
	
}
