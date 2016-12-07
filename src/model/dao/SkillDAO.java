package java_ee_module_2;
import java.util.ArrayList;

/*
 * Create SkillsDAO interface that implements DAO and also add methods specific for the skills table: findByName(String name). Create SkillsDAOImpl
 *  class which implements SkillsDAO interface and implements all methods using JDBC. 
 */

public interface SkillDAO extends DAO<Skill> {
	ArrayList<Skill> findByName(String name);
}
