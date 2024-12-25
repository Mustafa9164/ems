package com.jsp.prc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jsp.prc.entity.Adress;
import com.jsp.prc.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/save")
	public ResponseEntity<Adress> createAddress(@RequestBody Adress adress){
		return new ResponseEntity<Adress>(addressService.createAdress(adress),HttpStatus.CREATED);
	}
	
	@GetMapping("/byid")
	public ResponseEntity<Adress> findAdressById(@RequestParam String aid){
		return new ResponseEntity<Adress>(addressService.findAdressById(aid),HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity< List<Adress> > findAllAdress(){
		return new ResponseEntity< List<Adress> >(addressService.findAllAdress(),HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Adress> updateAdress(@RequestParam String aid,@RequestBody Adress adress){
		return new ResponseEntity<Adress>(addressService.updateAdress(aid,adress),HttpStatus.OK);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> deleteAdress(@RequestParam String aid){
		return new ResponseEntity<Boolean>(addressService.deleteAdress(aid),HttpStatus.OK);
	}

}
