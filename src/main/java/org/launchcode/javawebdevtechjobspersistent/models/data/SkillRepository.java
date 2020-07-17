package org.launchcode.javawebdevtechjobspersistent.models.data;

import org.launchcode.javawebdevtechjobspersistent.models.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
// Just for the heck of it, I'll add Transactional.

@Repository
@Transactional
public interface SkillRepository extends CrudRepository<Skill,Integer> {
}
