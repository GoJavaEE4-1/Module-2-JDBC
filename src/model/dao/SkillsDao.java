package model.dao;

import model.entity.Skill;

import java.util.List;

/**
 * Created by Sergiy on 1/22/17.
 */
public interface SkillsDao<Skill> extends Dao<Skill>{
    String findByName(String name);
    public List<Skill> getAll();
}
