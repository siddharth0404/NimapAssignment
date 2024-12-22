package com.NimapCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NimapCRUD.dto.Category;

public interface CatRepo extends JpaRepository<Category, Integer>{

}
