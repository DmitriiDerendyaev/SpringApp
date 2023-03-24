package ru.derendyaev.SpringApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {

    @GetMapping("/8")
    public String index(Model model){
        model.addAttribute("firstParam", "Hello task_8");
        return "taskFolder/task_8";
    }
}
