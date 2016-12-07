/*
 * Create DevelopersDAO interface that implement DAO and also add method specific for the developer table, like: findByName(String name), 
 * findByFullName(String firstName, String lastName). Create DevelopersDAOImpl class which implements DeveloperDAO interface and implement all methods using JDBC.
 */

public interface DeveloperDAO extends DAO<Developer> {
	Developer findByName(String name);
	Developer findByFullName(String firstName, String lastName);
}
