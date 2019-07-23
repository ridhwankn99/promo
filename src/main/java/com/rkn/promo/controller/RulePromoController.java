//package com.rkn.promo.controller;
//
//import org.kie.api.runtime.KieSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.rkn.promo.entity.Promo;
//
//@RestController
//public class RulePromoController {
//	@Autowired
//	private KieSession session;
//
//	@PostMapping("/promo")
//	public Promo orderNow(@RequestBody Promo promo) {
//		session.insert(promo);
//		session.fireAllRules();
//		return promo;
//	}
//}
