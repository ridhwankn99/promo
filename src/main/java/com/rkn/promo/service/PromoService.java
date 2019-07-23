package com.rkn.promo.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rkn.promo.entity.Promo;

@Service
public class PromoService {
	private final KieContainer kieContainer;

	@Autowired
	public PromoService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}

	public Promo getPromoDiscount(Promo promo) {
		//get the stateful session
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.insert(promo);
		kieSession.fireAllRules();
		kieSession.dispose();
		return promo;
	}
}
