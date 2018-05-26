package pl.coderslab.crm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.crm.entity.Project;
import pl.coderslab.crm.services.ProjectServiceImpl;
import pl.coderslab.crm.services.UserServiceImpl;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectServiceImpl projectService;

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/")
    public String showHome(Model model){
        List<Project> projects = projectService.findAllProjects();
        model.addAttribute("projects", projects);
        return "home";
    }


}
