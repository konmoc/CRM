package pl.coderslab.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.crm.entity.Priority;
import pl.coderslab.crm.services.PriorityServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/priority")
public class PriorityController {

    @Autowired
    PriorityServiceImpl priorityService;

    @GetMapping("/add/form")
    public String addPriorityByForm(Model model){
        Priority priority = new Priority();
        model.addAttribute("priority",priority);
        return "priorityAddForm";
    }

    @PostMapping("/add/form")
    public String addPriorityByForm(@ModelAttribute Priority priority){
        priorityService.save(priority);
        return "redirect:/";
    }

    @GetMapping("/show")
    public String showAllPriorities(Model model){
        List<Priority> priorities = priorityService.findAllPriority();
        model.addAttribute("priorities",priorities);
        return "priorityList";
    }

    @RequestMapping("/delete/{id}")
    public String deletePriority(@PathVariable Long id){
        Priority priority =priorityService.findPriorityById(id);
        priorityService.deletePriorityById(id);
        return "redirect:/";
    }



}
