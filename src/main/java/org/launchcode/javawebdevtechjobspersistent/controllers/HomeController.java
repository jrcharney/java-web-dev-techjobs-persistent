package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Employer;
import org.launchcode.javawebdevtechjobspersistent.models.Job;
import org.launchcode.javawebdevtechjobspersistent.models.Skill;
import org.launchcode.javawebdevtechjobspersistent.models.data.EmployerRepository;
import org.launchcode.javawebdevtechjobspersistent.models.data.JobRepository;
import org.launchcode.javawebdevtechjobspersistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    @Autowired
    private EmployerRepository employerRepo;

    @Autowired
    private SkillRepository skillRepo;

    @Autowired
    private JobRepository jobRepo;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("title", "My Jobs");
        model.addAttribute("jobs",jobRepo.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Job");
        model.addAttribute("employers",employerRepo.findAll());
        model.addAttribute("skills",skillRepo.findAll());
        model.addAttribute(new Job());
        return "add";
    }

    // Some name changes
    // Sadly, I wanted skills as skillId, skillObjs as skills. This would've been more consistent.
    @PostMapping("add")
    public String processAddJobForm(
            @ModelAttribute @Valid Job newJob, Errors errors, Model model,
            @RequestParam int employerId,
            @RequestParam List<Integer> skills
    ) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            return "add";
        }

        Optional<Employer> optEmployer = employerRepo.findById(employerId);
        Employer employer = optEmployer.get();
        newJob.setEmployer(employer);

        //List<Skill> skillObjs = (List<Skill>) skillRepo.findAllById(skills);
        //newJob.setSkills(skillObjs);

        jobRepo.save(newJob);
        return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {

        Optional<Job> optJob = jobRepo.findById(jobId);
        if(optJob.isPresent()){
            Job job = (Job) optJob.get();
            model.addAttribute("job",job);  // jobby job job jobjob job! :-P
            return "view";
        } else {
            return "redirect:..";
        }
    }


}
