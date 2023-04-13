package com.expreris.fotoalbum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @NotBlank
  private String name;
  @ManyToMany(mappedBy = "categories")
  private List<FotoAlbum> fotos;
  
  public Category() {
  }
  
  public List<FotoAlbum> getFotos() {
    return fotos;
  }
  
  public void setFotos(List<FotoAlbum> fotos) {
    this.fotos = fotos;
  }
  
  public Integer getId() {
    return id;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Category category)) return false;
    
    return getId().equals(category.getId());
  }
  
  @Override
  public int hashCode() {
    return getId().hashCode();
  }
}
