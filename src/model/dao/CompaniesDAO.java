package model.dao;

import model.entity.Company;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Sergiy on 12/4/16.
 */

//Create CompaniesDAO interface that implements DAO
//        and also add methods specific for the companies table:
//        findByName(String name). Create CompaniesDAOImpl class
//which implements CompaniesDAO interface and implements all methods using JDBC.


public interface CompaniesDAO<T> extends DAO<T> {

    Company get (long id)
            throws SQLException;

    Collection<Company> findByName(String name)
            throws SQLException;

}
