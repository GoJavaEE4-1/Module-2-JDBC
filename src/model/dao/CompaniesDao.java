package model.dao;

import java.util.List;

/**
 * Created by Sergiy on 1/22/17.
 */
public interface CompaniesDao<Company> extends Dao<Company> {

    public String findByName(String name);

    public List<Company> getAll();
}
