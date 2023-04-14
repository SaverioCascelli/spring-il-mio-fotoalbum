package com.expreris.fotoalbum.service;

import com.expreris.fotoalbum.model.Category;
import com.expreris.fotoalbum.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CategoryService {
  
  @Autowired
  CategoryRepository categoryRepository;
  
  public Set<Category> getAll() {
    List<Category> categoryList = categoryRepository.findAll();
    return new HashSet<>(categoryList);
  }
}
