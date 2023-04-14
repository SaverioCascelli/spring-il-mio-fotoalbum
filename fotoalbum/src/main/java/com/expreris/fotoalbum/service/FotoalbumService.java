package com.expreris.fotoalbum.service;

import com.expreris.fotoalbum.model.FotoAlbum;
import com.expreris.fotoalbum.repository.CategoryRepository;
import com.expreris.fotoalbum.repository.FotoalbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FotoalbumService {
  @Autowired
  FotoalbumRepository fotoalbumRepository;
  
  public List<FotoAlbum> getAll() {
    return fotoalbumRepository.findAll();
  }
  
  public Optional<FotoAlbum> getById(Integer id) {
    return fotoalbumRepository.findById(id);
  }
  
  public void create(FotoAlbum fotoAlbum) {
    FotoAlbum toPersist = new FotoAlbum();
    toPersist.setCategories(fotoAlbum.getCategories());
    toPersist.setTitle(fotoAlbum.getTitle());
    toPersist.setVisible(fotoAlbum.getVisible());
    toPersist.setImgUrl(fotoAlbum.getImgUrl());
    if (fotoAlbum.getDescription().length() != 0) {
      toPersist.setDescription(fotoAlbum.getDescription());
    } else toPersist.setDescription(null);
    fotoalbumRepository.save(toPersist);
  }
}
