package webApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webApp.service.UserService;

@Controller
@RequestMapping("/users")
public class UserControllerImpl {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "user/allUsers";
    }

    @GetMapping("/{id}")
    public String getUserById(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/byId";
    }

}
