package com.rkn.promo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rkn.promo.dao.PromoDao;
import com.rkn.promo.entity.Promo;



@RestController
@RequestMapping(value = "/promo")
public class PromoController {
	@Autowired
	private PromoDao promoDao;
	Promo promo;
	
	private Log log = LogFactory.getLog(getClass());
	
	@GetMapping("/getPromo")
	public List<Promo> getAllPromo(){
		List<Promo>result = new ArrayList<>();
		promoDao.findAll().forEach(result::add);
		
		return result;
	}
	
	@PostMapping("/kodePromo")
	public ResponseEntity<?> insert(@RequestBody Promo promo){
		Date dateValid = promoDao.findEndDate(promo.getKode_promo());;
		//Promo pr = new Promo();
		Date today = new Date();
		Long kuota = promoDao.findKuota(promo.getKode_promo());	
		System.out.println(kuota);
		Promo pr = promoDao.findKodePromo(promo.getKode_promo());
		try {
			Promo p = promoDao.findKodePromo(promo.getKode_promo());
			if(dateValid.after(today)&&kuota > 0) {	
				kuota --;
				pr.setKuota(kuota);
				promoDao.save(pr);
				return  ResponseEntity.ok("Kode Promo Tersedia "+",Sisa Kuota = "+kuota);
			}else if (dateValid.before(today)) {
				return ResponseEntity.ok("Kode Promo Tidak Tersedia");
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}
	
//	@PostMapping("/kodePromo")
//	public ResponseEntity<?> insert(@RequestBody Promo promo){
//		Date dateValid = promo.getEnd_valid_date(); 
//		Date today = new Date();
//		
//		try {
//			Promo p = promoDao.findKodePromo(promo.getKode_promo());
//			if(dateValid.after(today) || dateValid.before(promo.getStart_valid_date())) {
//				return ResponseEntity.ok("Kode Promo Tidak Tersedia");
//			}else if (dateValid.before(today)|| dateValid.after(promo.getStart_valid_date())) {
//				return ResponseEntity.ok("Kode Promo Tersedia");
//			}
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		return new ResponseEntity<>(HttpStatus.ACCEPTED);
//	}
	
	@PostMapping(value = "add")
	public Promo add (@RequestBody Promo promo) {
		try {
			return promoDao.save(promo);
		} catch (Exception e) {
			return null;
		}
	}
	
	@PutMapping(value = "update/{id}")
	public Promo update(@RequestBody Promo promo, @PathVariable Long id) {
		Promo promoSelected = promoDao.findById(id).orElse(null);
		if(promoSelected !=null) {
			promoSelected.setKode_promo(promo.getKode_promo());
			promoSelected.setStart_valid_date(promo.getStart_valid_date());
			promoSelected.setEnd_valid_date(promo.getEnd_valid_date());
			promoSelected.setKuota(promo.getKuota());
			
			
			return promoDao.save(promoSelected);
		}else {
			return null;
		}
	}
	
	@DeleteMapping(value = "delete/{id}")
	public HashMap<String, Object> delete(@PathVariable Long id) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		promoDao.deleteById(id);
		result.put("message", "Berhasil dihapus");
		return result;
	}
}
