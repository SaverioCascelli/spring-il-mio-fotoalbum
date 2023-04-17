package com.expreris.fotoalbum.service;

import com.expreris.fotoalbum.model.Category;
import com.expreris.fotoalbum.model.FotoAlbum;
import com.expreris.fotoalbum.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CategoryService {
  
  @Autowired
  CategoryRepository categoryRepository;
  
  public Set<Category> getAll() {
    List<Category> categoryList = categoryRepository.findAll();
    return new HashSet<>(categoryList);
  }
  
  public boolean update(Category category) {
    categoryRepository.save(category);
    return true;
  }
  
  public boolean create(Category category) {
    categoryRepository.save(category);
    return true;
  }
  
  public boolean delete(Integer id) {
    Optional<Category> cat = categoryRepository.findById(id);
    if (cat.isEmpty()) {
      return false;
    }
    List<FotoAlbum> fa = cat.get().getFotos();
    for (FotoAlbum fotoAlbum : fa) {
      fotoAlbum.getCategories().remove(cat.get());
    }
    categoryRepository.delete(cat.get());
    return true;
  }
}
