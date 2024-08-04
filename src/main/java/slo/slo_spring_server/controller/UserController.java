package slo.slo_spring_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import slo.slo_spring_server.domain.user.User;
import slo.slo_spring_server.service.UserService;

@Controller()
@RequestMapping("/user")
public class UserController {

    private final UserService personService;

    @Autowired
    public UserController(UserService personService) {
        this.personService = personService;
    }

    @GetMapping("")
    public String homePage(Model model) {
        model.addAttribute("person", new User());
        return "makeUser";
    }

    @GetMapping("/person")
    public String getPageUser(Model model) {
        model.addAttribute("persons", personService.getAllUsers());
        return "result";
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public String addPageUser(@ModelAttribute User user, Model model) {
        personService.createUser(user);
        model.addAttribute("persons", personService.getAllUsers());

        return "result";
    }

    @GetMapping("/person/delete/{id}")
    public String deletePageUser(@PathVariable Long id) {
        personService.deleteUser(id);
        return "redirect:/person";
    }

}
