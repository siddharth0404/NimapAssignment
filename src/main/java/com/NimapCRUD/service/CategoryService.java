package com.NimapCRUD.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NimapCRUD.dto.Category;
import com.NimapCRUD.repository.CatRepo;
import com.NimapCRUD.repository.ProdRepo;

@Service
public class CategoryService {
	
	@Autowired
	CatRepo crepo;
	
	@Autowired
	ProdRepo prepo;
	
	public void saveCategory(Category c)
	{
		crepo.save(c);
	}
	
	public List<Category> readCategory()
	{
		List<Category> categories = crepo.findAll();
		return categories;
	}
	
	public Optional<Category> getCategoryById(int id)
	{
		Optional<Category> op = crepo.findById(id);
		
		if(op.isPresent())
		{
			return crepo.findById(id);
		}
		return null;
	}
	
	public Category updateCategory(int id, Category c)
	{
		Optional<Category> op = crepo.findById(id);
		
		if(op.isPresent())
		{
			c.setId(id);
			c.setProducts(op.get().getProducts());
			return crepo.save(c);
		}
		return null;
	}
	
	public Category deleteCategory(int id)
	{
		Optional<Category> op = crepo.findById(id);
		
		if(op.isPresent())
		{
			crepo.deleteById(id);
			return op.get();
		}
		return null;
	}
}
