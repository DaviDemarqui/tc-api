package com.demarqui.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demarqui.app.repository.ClienteRepository;

@Service
@Transactional
public class ClienteService {
	
	@Autowired
	ClienteRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	
}
