package com.mitocode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.beans.Marca;
import com.mitocode.dao.DAOMarca;

@Service
public class ServiceMarcaImpl implements ServiceMarca {

	@Autowired
	private DAOMarca daoMarca; 
	
	public void registrar(Marca marca) throws Exception {
		daoMarca.registrar(marca);
	}
}
