package model.dao;

import java.util.List;

/**
 * Created by Sergiy on 1/16/17.
 */
public interface CustomersDao<Customer> extends Dao<Customer> {

    public String findByName (String name);
    public List<Customer> getAll();
}
