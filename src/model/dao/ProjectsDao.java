package model.dao;

import java.util.List;

/**
 * Created by Sergiy on 1/22/17.
 */
public interface ProjectsDao<Project> extends Dao<Project> {
    String findByName(String name);
    public List<Project> getAll();
}
