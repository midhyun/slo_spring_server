package slo.slo_spring_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import slo.slo_spring_server.domain.user.User;
import slo.slo_spring_server.service.PersonService;

@Controller
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @GetMapping("")
    public String homePage(Model model) {
        model.addAttribute("person", new User());
        return "makePerson";
    }

    @GetMapping("/person")
    public String getPagePerson(Model model) {
        model.addAttribute("persons", personService.getAllPersons());
        return "result";
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public String addPagePerson(@ModelAttribute User user, Model model) {
        personService.createPerson(user);
        model.addAttribute("persons", personService.getAllPersons());

        return "result";
    }

    @GetMapping("/person/delete/{id}")
    public String deletePagePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return "redirect:/person";
    }

}
