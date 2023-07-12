package org.crud.example.controllers;


import org.crud.example.dao.PersonDAO;
import org.crud.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {

  private final PersonDAO personDAO;

  @Autowired
  public PeopleController(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  @GetMapping()
  public String index(Model model) {
    model.addAttribute("people", personDAO.index());
    return "people/index";
  }

  @GetMapping("/{id}")
  public String show(@PathVariable("id") int id, Model model) {
    model.addAttribute("person", personDAO.show(id));
    return "people/show";
  }

  @GetMapping("/new")
  public String newPerson(@ModelAttribute("person") Person person) {
    return "people/new";
  }

  @PostMapping()
  public String create(@ModelAttribute("person") Person person) {
    personDAO.save(person);
    return "redirect:/people";
  }


}
