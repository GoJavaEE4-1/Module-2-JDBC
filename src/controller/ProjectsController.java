package controller;

import model.dao.ProjectsDao;
import model.dao.ProjectsDaoImpl;
import model.dao.SkillsDao;
import model.dao.SkillsDaoImpl;
import view.ConsoleHelper;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Sergiy on 1/22/17.
 */
public class ProjectsController implements GeneralController{
    public void execute() throws IOException, ClassNotFoundException, SQLException {

        ProjectsDao projectsDao = new ProjectsDaoImpl();
        int controlValue;
        int id;
        String name;

        ConsoleHelper.writeMessage("----------------------PROJECTS CONSOLE---------------------" + "\n" +
                "1 - CREATE | 2 - DELETE | 3 - UPDATE | 4 - SHOW ALL PROJECTS | 5 - FIND BY NAME\\n");

        controlValue = ConsoleHelper.readInt();

        if (controlValue == 1) {
            ConsoleHelper.writeMessage("INPUT PROJECT NAME TO CREATE");
            name = ConsoleHelper.readString();
            projectsDao.create(name);
        } else if (controlValue == 2) {
            ConsoleHelper.writeMessage("INPUT ID TO DELETE PROJECT");
            id = ConsoleHelper.readInt();
            projectsDao.delete(id);
        } else if (controlValue == 3) {
            ConsoleHelper.writeMessage("INPUT PROJECT NAME TO UPDATE");
            name = ConsoleHelper.readString();
            projectsDao.update(name);
        } else if (controlValue == 4) {
            projectsDao.getAll();
        } else if (controlValue == 5) {
            ConsoleHelper.writeMessage("INPUT PROJECT NAME TO FIND");
            name = ConsoleHelper.readString();
            projectsDao.findByName(name);
        } else System.out.println("You have not entered correct value. Please, input 1, 2, 3, 4 or 5.");
    }
}
