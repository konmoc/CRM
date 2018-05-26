package pl.coderslab.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.crm.entity.*;
import pl.coderslab.crm.services.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskServiceImpl taskService;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    ProjectServiceImpl projectService;

    @Autowired
    PriorityServiceImpl priorityService;

    @Autowired
    StatusServiceImpl statusService;

    @GetMapping("/add")
    @ResponseBody
    public String addTask(){
        Task task = new Task();
        task.setCreationDate(LocalDateTime.now());
        task.setTopic("Make it faster");
        task.setDescription("It works so slow!");
        taskService.save(task);
        return "Success!";
    }

    @GetMapping("/add/form")
    public String addTaskByForm(Model model){
        Task task = new Task();
        model.addAttribute("task", task);
        return "taskAddForm";
    }

    @PostMapping("/add/form")
    public String addTaskByForm(@ModelAttribute Task task){
        task.setCreationDate(LocalDateTime.now());
        taskService.save(task);
        return "redirect:/";
    }

    @ModelAttribute("users")
    public List<User> users(){
        return userService.findAllUser();
    }
    @ModelAttribute("projects")
    public List<Project> projects(){
        return projectService.findAllProjects();
    }
    @ModelAttribute("priorities")
    public List<Priority> priorities(){
        return priorityService.findAllPriority();
    }
    @ModelAttribute("statuses")
    public List<Status> statuses(){
        return statusService.findAllStatus();
    }
}
