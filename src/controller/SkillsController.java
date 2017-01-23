package controller;

import model.dao.CompaniesDao;
import model.dao.CompaniesDaoImpl;
import model.dao.SkillsDao;
import model.dao.SkillsDaoImpl;
import view.ConsoleHelper;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Sergiy on 1/22/17.
 */
public class SkillsController implements GeneralController{
    public void execute() throws IOException, ClassNotFoundException, SQLException {

        SkillsDao skillsDao = new SkillsDaoImpl();
        int controlValue;
        int id;
        String name;

        ConsoleHelper.writeMessage("----------------------SKILLS CONSOLE---------------------" + "\n" +
                "1 - CREATE | 2 - DELETE | 3 - UPDATE | 4 - SHOW ALL SKILLS | 5 - FIND BY NAME\\n");

        controlValue = ConsoleHelper.readInt();

        if (controlValue == 1) {
            ConsoleHelper.writeMessage("INPUT SKILL NAME TO CREATE");
            name = ConsoleHelper.readString();
            skillsDao.create(name);
        } else if (controlValue == 2) {
            ConsoleHelper.writeMessage("INPUT ID TO DELETE SKILL");
            id = ConsoleHelper.readInt();
            skillsDao.delete(id);
        } else if (controlValue == 3) {
            ConsoleHelper.writeMessage("INPUT SKILL NAME TO UPDATE");
            name = ConsoleHelper.readString();
            skillsDao.update(name);
        } else if (controlValue == 4) {
            skillsDao.getAll();
        } else if (controlValue == 5) {
            ConsoleHelper.writeMessage("INPUT SKILL NAME TO FIND");
            name = ConsoleHelper.readString();
            skillsDao.findByName(name);
        } else System.out.println("You have not entered correct value. Please, input 1, 2, 3, 4 or 5.");
    }
}
