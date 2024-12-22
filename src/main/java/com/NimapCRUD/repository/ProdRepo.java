package com.NimapCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NimapCRUD.dto.Product;

public interface ProdRepo extends JpaRepository<Product, Integer>{

}
