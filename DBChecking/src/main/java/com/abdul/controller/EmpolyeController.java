package com.abdul.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abdul.entity.EmpolyeEntity;
import com.abdul.respo.EmpolyeRespo;

@RestController
public class EmpolyeController
{

	@Autowired
	private EmpolyeRespo empolyeRespo;
	
	
	@GetMapping("/allemployee")
	public List<EmpolyeEntity> getAllEmpolye()
	{         
		List<EmpolyeEntity> empolye=empolyeRespo.findAll();
		
		return empolye;
	}
	
	@PostMapping("/addempolye")
	public List<EmpolyeEntity> addEmpolye(EmpolyeEntity empolye)
	{

		     empolyeRespo.save(empolye);
		     
		     return empolyeRespo.findAll();
	}
	
	
}
