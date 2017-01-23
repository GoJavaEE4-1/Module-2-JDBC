package controller;

import model.dao.DevelopersDao;
import model.dao.DevelopersDaoImpl;
import view.ConsoleHelper;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Sergiy on 1/22/17.
 */
public class DevelopersController implements GeneralController{
    public void execute() throws IOException, ClassNotFoundException, SQLException {

        DevelopersDao developersDao = new DevelopersDaoImpl();
        int controlValue;
        int id;
        String name;

        ConsoleHelper.writeMessage("----------------------DEVELOPERS CONSOLE---------------------" + "\n" +
                "1 - CREATE | 2 - DELETE | 3 - UPDATE | 4 - SHOW ALL DEVELOPERS | 5 - FIND BY NAME\\n");

        controlValue = ConsoleHelper.readInt();

        if (controlValue == 1) {
            ConsoleHelper.writeMessage("INPUT DEVELOPER NAME TO CREATE");
            name = ConsoleHelper.readString();
            developersDao.create(name);
        } else if (controlValue == 2) {
            ConsoleHelper.writeMessage("INPUT ID TO DELETE DEVELOPER");
            id = ConsoleHelper.readInt();
            developersDao.delete(id);
        } else if (controlValue == 3) {
            ConsoleHelper.writeMessage("INPUT DEVELOPER NAME TO UPDATE");
            name = ConsoleHelper.readString();
            developersDao.update(name);
        } else if (controlValue == 4) {
            developersDao.getAll();
        } else if (controlValue == 5) {
            ConsoleHelper.writeMessage("INPUT DEVELOPER NAME TO FIND");
            name = ConsoleHelper.readString();
            developersDao.findByName(name);
        } else System.out.println("You have not entered correct value. Please, input 1, 2, 3, 4 or 5.");
    }
}

