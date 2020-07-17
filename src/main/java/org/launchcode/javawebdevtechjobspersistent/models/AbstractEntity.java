package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

/* NOTE: AbstractEntity replaces JobField from techjobs-mvc */

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    private int id;

    // "Some employer names will be longer than 50 characters." Then I will make it 150 characters. There is room.
    @NotBlank(message = "Name cannot be empty")
    @Size(min = 1, max = 150, message = "Name value should be between 1 and 150 characters")
    private String name;    // or should this be value

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}