package model.dao;

public interface ProjectsDAO<Project> extends DAO<Project> {
    public Project findByName(String name);
}
