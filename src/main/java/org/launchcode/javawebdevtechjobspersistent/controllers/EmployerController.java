package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Employer;
import org.launchcode.javawebdevtechjobspersistent.models.data.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("employers")
public class EmployerController {

    @Autowired
    private EmployerRepository employerRepo;

    @GetMapping
    public String displayAllEmployers(Model model){
        // model.addAttribute("title","Add Employer");
        model.addAttribute("employers",employerRepo.findAll());
        return "employers/index";
    }

    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        // model.addAttribute("title","Add Employer");
        model.addAttribute(new Employer());
        return "employers/add";
    }

    @PostMapping("add")
    public String processAddEmployerForm(
            @ModelAttribute @Valid Employer newEmployer,
            Errors errors,
            Model model
    ) {

        if (errors.hasErrors()) {
            return "employers/add";
        }

        employerRepo.save(newEmployer);
        return "redirect:";
    }

    @GetMapping("view/{employerId}")
    public String displayViewEmployer(Model model, @PathVariable int employerId) {

        Optional<Employer> optEmployer = employerRepo.findById(employerId);
        if (optEmployer.isPresent()) {
            Employer employer = (Employer) optEmployer.get();       // Do we still need to scope?
            model.addAttribute("employer", employer);
            return "employers/view";
        } else {
            // model.addAttribute("title", "Invalid Employer Id: " + employerId);
            model.addAttribute("employers",employerRepo.findAll());
        }
        return "redirect:../";
    }
}
