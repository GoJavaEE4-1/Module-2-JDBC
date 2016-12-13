package model.dao;
import model.entity.Company;

/*
* Create CompaniesDAO interface that implements DAO and also add methods specific for the companies table: findByName(String name).
* Create CompaniesDAOImpl class which implements CompaniesDAO interface and implements all methods using JDBC.
 */
public interface CompanyDAO2 extends DAO<Company> {
    Company findByName(String name);
}
