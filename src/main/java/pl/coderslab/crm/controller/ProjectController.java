package pl.coderslab.crm.controller;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.crm.entity.Project;
import pl.coderslab.crm.entity.Task;
import pl.coderslab.crm.services.ProjectServiceImpl;
import pl.coderslab.crm.services.TaskServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectServiceImpl projectService;

    Faker faker = new Faker();

    @Autowired
    TaskServiceImpl taskService;

    @GetMapping("/add")
    @ResponseBody
    public String addUser(){
        Project project = new Project();
        project.setName(faker.name().title());
        project.setDescription(faker.lorem().sentence());
        project.setWebsiteAddress(faker.lorem().word()+"@gmail.com");
        project.setIdentifier(faker.lorem().word());
        project.setActive(true);
        projectService.save(project);
        return "Success!";
    }

    @GetMapping("/add/form")
    public String addProjectByForm(Model model){
        Project project = new Project();
        model.addAttribute("project", project);
        return "projectAddForm";
    }

    @PostMapping("/add/form")
    public String addProjectrByForm(@ModelAttribute Project project){
        projectService.save(project);
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String deleteProjectById(@PathVariable Long id){
        Project project =projectService.findOneById(id);
        projectService.deleteProjectById(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/addTaskForm")
    public String addTaskToProject(@PathVariable Long id, Model model){
        Project project = projectService.findOneById(id);
        model.addAttribute("project", project);
        return "projectAddTaskForm";
    }

    @PostMapping("/{id}/addTaskForm")
    public String addTaskToProject(@ModelAttribute Project project){
        projectService.save(project);
        return "redirect:/";
    }

    @ModelAttribute("tasks")
    public List<Task> statuses(){
        return taskService.findAllTask();
    }


}
