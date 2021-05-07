package com.hsvf.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsvf.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
