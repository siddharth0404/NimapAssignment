package com.NimapCRUD.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.NimapCRUD.dto.Category;
import com.NimapCRUD.dto.Product;
import com.NimapCRUD.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService prodService;
	
	@PostMapping("/prodSave")
	public void saveProduct(@RequestBody Product p)
	{
		prodService.saveProduct(p);
	}
	
	@GetMapping("/prodReadAll")
	public List<Product> readProduct()
	{
		return prodService.readProduct();
	}
	
	@GetMapping("/{id}")
	public Optional<Product> getProductById(@PathVariable int id)
	{
		return prodService.getProductById(id);
	}
	
	@PatchMapping("/prodUpdate")
	public Product updateProduct(@RequestParam int id, @RequestBody Product p)
	{
		return prodService.updateProduct(id, p);
	}
	
	@DeleteMapping("/prodDelete")
	public Product deleteProduct(@RequestParam int id)
	{
		return prodService.deleteProduct(id);
	}
	
}
