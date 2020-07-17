package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Job extends AbstractEntity {

    /*
    @Id
    @GeneratedValue
    private int id;

    private String name;
    */

    //private String employer;
    @ManyToOne
    private Employer employer;

    //private String skills;  // Formerly coreCompetency
    @ManyToMany
    private List<Skill> skills = new ArrayList<>();     // TODO: Add final!

    public Job() {
    }

    //public Job(String anEmployer, String someSkills)
    public Job(Employer employer, List<Skill> skills)
    {
        //super();                        // Don't forget, we use super here to increase the id
        this.employer = employer;
        this.skills = skills;
    }

    // Getters and setters.
    /*
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    */

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    // TODO: Adjust this if we add final to skills.
    /*
    public void setSkills(String skills) {
        this.skills = skills;
    }

     */

    public void setSkills(List<Skill> skills) {
        this.skills.addAll(skills);
    }



    /*
    // TODO: Use these later.
    public void addSkill(Skill skill){
        this.skills.add(skill);
    }

    public  void removeSkill(Skill skill){
        this.skills.remove(skill);
    }

     */

}
