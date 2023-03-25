package ru.derendyaev.SpringApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.derendyaev.SpringApp.models.Calc;
import ru.derendyaev.SpringApp.models.Greeting;

import javax.management.modelmbean.ModelMBeanOperationInfo;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping(value = "/task")
public class TaskController {

    @GetMapping(value = "")
    public String index(){
        return "index";
    }

    @GetMapping(value = "/8")
    public String task_8(Model model){
        model.addAttribute("name", "Dmitrii Derendyaev");
        int firstNumber = 5;
        int secondNumber = 2;

        if(firstNumber > secondNumber)
            model.addAttribute("result", "First was greater, result(5-2): " + (firstNumber-secondNumber));

        model.addAttribute("sqrt", Math.sqrt(2));

        return "/taskFolder/task_8";
    }

    @GetMapping(value = "/9")
    public String task_9(@RequestParam(value = "yourName", required = false) String yourName, Model model){
        model.addAttribute("yourName", yourName);

        model.addAttribute("greeting", new Greeting());

        return "taskFolder/task_9/task_9";
    }

    @PostMapping(value = "/9/post")
    public String task_9Post(@ModelAttribute(value = "greeting") @Valid Greeting greeting, Model model){

        return "taskFolder/task_9/result_9";
    }

    @GetMapping(value = "/10")
    public String task_10(){
        return "taskFolder/task_10/task_10";
    }

    @PostMapping("/10/post")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, Model model) {

        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a file to upload");
            return "taskFolder/task_10/task_10_error";
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get("D:\\mospolytech\\4 term\\Cross-platform\\PHP_Java\\SpringApp\\src\\main\\resources\\task_10_files" + file.getOriginalFilename());
            Files.write(path, bytes);

            model.addAttribute("message", "File uploaded successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "taskFolder/task_10/task_10_message";
    }

    @GetMapping(value = "/11")
    public String task_11(){
        return "taskFolder/task_11/task_11";
    }

    @PostMapping(value = "/11/calculate")
    public String calculate(@RequestParam("calc") String stringCalc, @RequestParam("specialCalc") String specialCalc,  Model model) throws IOException {
        if(stringCalc != null){
            Calc calc = new Calc(stringCalc);
            model.addAttribute("originalString", stringCalc);
            model.addAttribute("result", calc.calculate());
        } else {
            Calc calc = new Calc(specialCalc);

        }




        return "taskFolder/task_11/task_11_result";
    }

    @GetMapping(value = "/12")
    public String task_12(){
        return "404";
    }

    @GetMapping(value = "/13")
    public String task_13(){
        return "404";
    }
}
