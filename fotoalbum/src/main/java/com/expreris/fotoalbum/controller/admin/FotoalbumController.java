package com.expreris.fotoalbum.controller.admin;

import com.expreris.fotoalbum.service.FotoalbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/fotoalbum")
public class FotoalbumController {

  @Autowired
  FotoalbumService fotoalbumService;
  
  @GetMapping("")
  public String index(Model model){
  return "/admin/index";
  }
}
