package com.jsp.prc.service;

import java.util.List;
import com.jsp.prc.entity.Adress;

public interface AddressService {

	Adress createAdress(Adress adress);

	Adress findAdressById(String aid);

	List<Adress> findAllAdress();

	Adress updateAdress(String aid, Adress adress);

	Boolean deleteAdress(String aid);

}
