package com.hsvf.dsvendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsvf.dsvendas.dto.SaleDTO;
import com.hsvf.dsvendas.dto.SaleSuccessDTO;
import com.hsvf.dsvendas.dto.SaleSumDTO;
import com.hsvf.dsvendas.entities.Sale;
import com.hsvf.dsvendas.repositories.SaleRepository;
import com.hsvf.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pateable){
		sellerRepository.findAll();
		Page<Sale> result =  repository.findAll(pateable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller(){
		return repository.successGroupedBySeller();
	}
}
