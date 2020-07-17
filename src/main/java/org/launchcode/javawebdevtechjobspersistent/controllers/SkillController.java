package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Skill;
import org.launchcode.javawebdevtechjobspersistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

// TODO: add some "title" variables. (It's not part of the assignment, but it will make it seem more like coding_events.)
@Controller
@RequestMapping("skills")
public class SkillController {

    @Autowired
    private SkillRepository skillRepo;

    @GetMapping
    public String displayAllSkills(Model model){
        // model.addAttribute("title","Add Skill");
        model.addAttribute("skills",skillRepo.findAll());
        return "skills/index";
    }

    @GetMapping("add")
    public String displayAddSkillForm(Model model){
        model.addAttribute(new Skill());
        return "skills/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(
            @ModelAttribute @Valid Skill newSkill,
            Errors errors,
            Model model
    ){
        if(errors.hasErrors()){
            return "skills/add";
        }
        skillRepo.save(newSkill);
        return "redirect:";
    }

    @GetMapping("view/{skillId}")
    public String displayViewSkill(Model model, @PathVariable int skillId){
        Optional<Skill> optSkill = skillRepo.findById(skillId);
        if(optSkill.isPresent()){
            Skill skill = (Skill) optSkill.get();   // I just noticed this casting here.
            model.addAttribute("skill",skill);
            return "skills/view";
        } else {
            // model.addAttribute("title", "Invalid Skill Id: " + employerId);
            model.addAttribute("skills",skillRepo.findAll());
        }
        return "redirect:../";
    }
}
