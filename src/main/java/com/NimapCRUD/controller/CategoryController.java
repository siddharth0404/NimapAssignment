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
import com.NimapCRUD.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService catService;
	
	@PostMapping("/catSave")
	public void saveCategory(@RequestBody Category c)
	{
		catService.saveCategory(c);
	}
	
	@GetMapping("/catReadAll")
	public List<Category> readCategory()
	{
		return catService.readCategory();
	}
	
	@GetMapping("/{id}")
	public Optional<Category> getCategoryById(@PathVariable int id)
	{
		return catService.getCategoryById(id);
	}
	
	@PatchMapping("/catUpdate")
	public Category updateCategory(@RequestParam int id, @RequestBody Category c)
	{
		return catService.updateCategory(id, c);
	}
	
	@DeleteMapping("/catDelete")
	public Category deleteCategory(@RequestParam int id)
	{
		return catService.deleteCategory(id);
	}
}
