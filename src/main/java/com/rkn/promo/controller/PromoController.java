package com.rkn.promo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.formula.functions.Today;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/getPromo")
	public List<Promo> getAllPromo(){
		List<Promo>result = new ArrayList<>();
		promoDao.findAll().forEach(result::add);
		
		return result;
	}
	
	@GetMapping("/getPromo/{id}")
	
	public Promo getById(@PathVariable Long id) throws ParseException{
		Promo result = promoDao.findById(id).orElse(null);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //String dateInString = "07/06/2013";
        String dateValidInString = result.getEnd_valid_date();
        
        Date today = new Date();
            Date dateValidDate = formatter.parse(dateValidInString);
            System.out.println(dateValidDate);
            System.out.println(formatter.format(dateValidDate));
        if(dateValidDate.after(today)) {
        	System.out.println("Tidak Valid");
        }else if (dateValidDate.before(today)) {
			System.out.println("valid");
		}

		return result;
	}
	
	
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
