package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

// Hint: Look at EventDetails from coding events
// It's like that but no contactEmail

@Entity
public class Skill extends AbstractEntity {

    @ManyToMany(mappedBy = "skills")
    private List<Job> jobs = new ArrayList<>(); //  final

    // I think this can be blank.
    @Size(max = 500, message = "Whoa! That's too long. Keep it under 500 characters!")
    private String description;

    public Skill(){}

    public Skill(@Size(max = 500, message = "Whoa! That's too long. Keep it under 500 characters!") String description){
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    // Since we aren't using final.
    public void setJobs(List<Job> jobs) { this.jobs = jobs; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}