package com.NimapCRUD.service;

import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NimapCRUD.dto.Category;
import com.NimapCRUD.dto.Product;
import com.NimapCRUD.repository.CatRepo;
import com.NimapCRUD.repository.ProdRepo;

@Service
public class ProductService {

	@Autowired
	CatRepo crepo;
	
	@Autowired
	ProdRepo prepo;
	
	public void saveProduct(Product p)
	{
		prepo.save(p);
	}
	
	public List<Product> readProduct()
	{
		List<Product> products = prepo.findAll();
		return products;
	}
	
	public Optional<Product> getProductById(int id)
	{
		Optional<Product> op = prepo.findById(id);
		
		if(op.isPresent())
		{
			return prepo.findById(id);
		}
		return null;
	}
	
	public Product updateProduct(int id, Product p)
	{
		Optional<Product> op = prepo.findById(id);
		
		if(op.isPresent())
		{
			p.setId(id);
			return prepo.save(p);
		}
		return null;
	}
	
	public Product deleteProduct(int id)
	{
		Optional<Product> op = prepo.findById(id);
		
		if(op.isPresent())
		{
			prepo.deleteById(id);
			return op.get();
		}
		return null;
	}
}
