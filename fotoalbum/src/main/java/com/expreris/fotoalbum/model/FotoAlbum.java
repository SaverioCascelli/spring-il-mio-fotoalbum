package com.expreris.fotoalbum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Entity
@Table(name = "foto_album")
public class FotoAlbum {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @NotBlank
  private String title;
  @Lob
  @Column(columnDefinition = "varchar(255) default 'no description available'")
  private String description;
  @NotBlank
  private String imgUrl;
  @Column(columnDefinition = "boolean default true")
  private Boolean visible;
  @ManyToMany
  @JoinTable(
      name = "category_foto_album",
      joinColumns = @JoinColumn(name = "foto_album_id"),
      inverseJoinColumns = @JoinColumn(name = "category_id")
  )
  private Set<Category> categories;
  
  public FotoAlbum() {
  }
  
  
  public Integer getId() {
    return id;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public String getDescription() {
    return description;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }
  
  public String getImgUrl() {
    return imgUrl;
  }
  
  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }
  
  public Boolean getVisible() {
    return visible;
  }
  
  public void setVisible(Boolean visible) {
    this.visible = visible;
  }
  
  public Set<Category> getCategories() {
    return categories;
  }
  
  public void setCategories(Set<Category> categories) {
    this.categories = categories;
  }
  
  @PrePersist
  public void setDefaultValues() {
    if (description == null) {
      description = "Default description";
    }
  }
}
