package com.expreris.fotoalbum.controller.admin;

import com.expreris.fotoalbum.model.Category;
import com.expreris.fotoalbum.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
  
  @Autowired
  CategoryService categoryService;
  
  @GetMapping("")
  public String index(Model model) {
    model.addAttribute("categories", categoryService.getAll());
    return "/admin/categories/index";
  }
  
  @PostMapping("update/{id}")
  public String update(@ModelAttribute("category") Category category) {
    categoryService.update(category);
    return "redirect:/admin/category";
  }
  
  @PostMapping("create")
  public String create(@ModelAttribute("category") Category category) {
    categoryService.create(category);
    return "redirect:/admin/category";
  }
  
  @GetMapping("/delete/{id}")
  public String delete(@PathVariable Integer id) {
    categoryService.delete(id);
    return "redirect:/admin/category";
  }
}
