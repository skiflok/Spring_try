package com.example.controllers;


import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

  @GetMapping("/hello")
  public String helloPage(HttpServletRequest httpServletRequest) {
    String name = httpServletRequest.getParameter("name");
    String surname = httpServletRequest.getParameter("surname");
    System.out.format("name = %s, surname = %s\n", name, surname);
    return "first/hello";
  }

  @GetMapping("/goodbye")
  public String goodByePage(
      @RequestParam(value = "name", required = false) String name,
      @RequestParam(value = "surname", required = false) String surname,
      Model model) {
    model.addAttribute("message", String.format("goodbye    name = %s, surname = %s\n", name, surname));
//    System.out.format("goodbye    name = %s, surname = %s\n", name, surname);
    return "first/goodbye";
  }
}
