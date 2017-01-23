package model.dao;


import java.util.List;

public interface DevelopersDao<Developer> extends Dao<Developer> {

    public String findByName(String name);
    public List<Developer> getAll();
}

