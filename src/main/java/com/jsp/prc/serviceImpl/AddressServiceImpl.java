package com.jsp.prc.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.prc.entity.Adress;
import com.jsp.prc.repository.AdressRepository;
import com.jsp.prc.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private AdressRepository adressRepository;

	@Override
	public Adress createAdress(Adress adress) {
		return adressRepository.save(adress);
	}

	@Override
	public Adress findAdressById(String aid) {
		Optional<Adress> optional = adressRepository.findById(aid);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Adress> findAllAdress() {
		 return adressRepository.findAll();
	}

	@Override
	public Adress updateAdress(String aid, Adress adress) {
		Optional<Adress> optional = adressRepository.findById(aid);
		if(optional.isPresent()) {
			adress.setAid(aid);
			return adressRepository.save(adress);
		}
		return null;
	}

	@Override
	public Boolean deleteAdress(String aid) {
		Optional<Adress> optional = adressRepository.findById(aid);
		if(optional.isPresent()) {
			 adressRepository.deleteById(aid);
			 return true;
		}
		return false;
	}

}
