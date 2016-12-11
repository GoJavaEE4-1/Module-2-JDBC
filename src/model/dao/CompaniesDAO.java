package model.dao;


import java.util.List;

/**
 * Created by Sergiy on 12/4/16.
 */

//Create CompaniesDAO interface that implements DAO
//        and also add methods specific for the companies table:
//        findByName(String name). Create CompaniesDAOImpl class
//which implements CompaniesDAO interface and implements all methods using JDBC.


public interface CompaniesDAO<Company> extends DAO<Company> {

    public Company findByName(String name);
    public List<Company> getAll();

}
