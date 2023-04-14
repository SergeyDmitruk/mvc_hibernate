package by.dmitruk.app.controllers;

import by.dmitruk.app.model.User;
import by.dmitruk.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
@Autowired
UserService userService;


@GetMapping(value = "/users")
public String getAllUsers(Model model) {
    model.addAttribute("users", userService.getAllUsers());
    return "index";
}

@GetMapping(value = "user/{id}")
public String getUserById(Model model, @PathVariable int id) {
    model.addAttribute("users", userService.getUserById(id));
    return "index";
}

@GetMapping(value = "users/add")
public String goToPageCreateUser(Model model) {
    model.addAttribute("user", new User());
    model.addAttribute("labelUpUser", false);
    return "form";
}

@PostMapping(value = "/users")
public String addUser(Model model, User user) {
    model.addAttribute("newUser", user);
    userService.createUser(user);
    return "redirect:/users";
}

@GetMapping("users/edit/{id}")
public String updateUserForm(Model model, @PathVariable int id) {
    model.addAttribute("user", userService.getUserById(id));
    model.addAttribute("labelUpUser", true);
    return "form";
}

@PatchMapping("users/edit/{id}")
public String updateUser(Model model, User user, @PathVariable int id) {
    model.addAttribute("userUp", user);
    userService.updateUser(user, id);
    return "redirect:/users";
}

@GetMapping("users/delete/{id}")
public String deleteUser(@PathVariable int id) {
    userService.deleteUserById(id);
    return "redirect:/users";
}

}
