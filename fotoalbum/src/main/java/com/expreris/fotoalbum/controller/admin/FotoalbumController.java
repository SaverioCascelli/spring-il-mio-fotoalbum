package com.expreris.fotoalbum.controller.admin;

import com.expreris.fotoalbum.model.Category;
import com.expreris.fotoalbum.model.FotoAlbum;
import com.expreris.fotoalbum.service.CategoryService;
import com.expreris.fotoalbum.service.FotoalbumService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/admin/fotoalbum")
public class FotoalbumController {
  
  @Autowired
  FotoalbumService fotoalbumService;
  @Autowired
  CategoryService categoryService;
  
  @GetMapping("")
  public String index(Model model) {
    List<FotoAlbum> albums = fotoalbumService.getAll();
    model.addAttribute("fotoList", albums);
    return "/admin/fotoalbum/index";
  }
  
  @GetMapping("/edit/{id}")
  public String edit(@PathVariable("id") Integer id, Model model) {
    FotoAlbum fotoAlbum = fotoalbumService.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    model.addAttribute(("categories"), categoryService.getAll());
    model.addAttribute("fotoAlbum", fotoAlbum);
    return "/admin/fotoalbum/update";
  }
  
  @PostMapping("/edit")
  public String editPost(@Valid @ModelAttribute("fotoAlbum") FotoAlbum fotoAlbum, BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
      model.addAttribute("categories", categoryService.getAll());
      return "/admin/fotoalbum/update";
    }
    fotoalbumService.update(fotoAlbum);
    return "redirect:/admin/fotoalbum";
  }
  
  
  @GetMapping("/{id}")
  public String show(@PathVariable("id") Integer id, Model model) {
    FotoAlbum fotoAlbum = fotoalbumService.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    model.addAttribute("fotoAlbum", fotoAlbum);
    return "/admin/fotoalbum/show";
  }
  
  @GetMapping("/create")
  public String create(Model model) {
    FotoAlbum fa = new FotoAlbum();
    model.addAttribute("fotoAlbum", fa);
    model.addAttribute("categories", categoryService.getAll());
    return "/admin/fotoalbum/create";
  }
  
  @PostMapping("/create")
  public String create(@Valid @ModelAttribute("fotoAlbum") FotoAlbum fotoAlbum, BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
      model.addAttribute("categories", categoryService.getAll());
      return "/admin/fotoalbum/create";
    }
    fotoalbumService.create(fotoAlbum);
    return "redirect:/admin/fotoalbum";
  }
  
  @GetMapping("/delete/{id}")
  public String delete(@PathVariable("id") Integer id) {
    fotoalbumService.delete(id);
    return "redirect:/admin/fotoalbum";
  }
  
  
}
