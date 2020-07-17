package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    @OneToMany      //(mappedBy = "employer")   // If we use @JoinColumn we can't use mappedBy in @[One|Many]to[One|Many]
    @JoinColumn
    private List<Job> jobs = new ArrayList<>();

    // NOTE: An Employer can only have ONE location.
    @NotNull(message = "Location Required.")
    private String location;


    // Default constructor (a.k.a. "no-arg" constructor). Hibernate needs this to create an object.
    public Employer(){}

    // Turns out Employer shouldn't have a name field.
    //public Employer(String name, String location)
    Employer(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Job> getJobs() { return jobs; }

    public void setJobs(List<Job> jobs) {
        //this.jobs = jobs;
        this.jobs.addAll(jobs);
    }
}
