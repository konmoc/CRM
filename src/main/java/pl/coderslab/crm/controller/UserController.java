package pl.coderslab.crm.controller;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.crm.entity.User;
import pl.coderslab.crm.repository.RoleRepository;
import pl.coderslab.crm.services.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    Faker faker = new Faker();

    @Autowired
    UserServiceImpl userService;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/add")
    @ResponseBody
    public String addUser(){
        User user = new User();
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setLogin(faker.name().username());
        user.setPassword(faker.lorem().word());
        userService.save(user);
        return "Success!";
    }

    @GetMapping("/add/form")
    public String addUserByForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "userAddForm";
    }

    @PostMapping("/add/form")
    public String addUserByForm(@ModelAttribute User user){
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/show")
    public String showAllUsers(Model model){
        List<User> users = userService.findAllUser();
        model.addAttribute("users", users);
        return "userList";
    }
}
