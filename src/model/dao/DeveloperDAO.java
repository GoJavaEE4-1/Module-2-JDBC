package java_ee_module_2;
/*
 * Create DevelopersDAO interface that implement DAO and also add method specific for the developer table, like: findByName(String name), 
 * findByFullName(String firstName, String lastName). Create DevelopersDAOImpl class which implements DeveloperDAO interface and implement all methods using JDBC.
 */

public interface DeveloperDAO<T> extends DAO<T> {
	T findByName(String name);
	T findByFullName(String firstName, String lastName);
}