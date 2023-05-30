package webApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import webApp.model.User;
import webApp.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserControllerImpl {
    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("getAllUsers", userService.getAllUsers());
        return "users";
    }

    @GetMapping
    public String getUserById(ModelMap model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "getUserById";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }


    public String addUser(User user) {
        return null;
    }
}
