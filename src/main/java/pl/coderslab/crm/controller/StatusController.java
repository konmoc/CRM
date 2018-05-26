package pl.coderslab.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.crm.entity.Status;
import pl.coderslab.crm.services.StatusServiceImpl;


@Controller
@RequestMapping("/status")
public class StatusController {
    
    @Autowired
    StatusServiceImpl statusService;



    @GetMapping("/add/form")
    public String addStatusByForm(Model model){
        Status status = new Status();
        model.addAttribute("status", status);
        return "statusAddForm";
    }

    @PostMapping("/add/form")
    public String addTaskByForm(@ModelAttribute Status status){
        statusService.save(status);
        return "redirect:/";
    }
}
