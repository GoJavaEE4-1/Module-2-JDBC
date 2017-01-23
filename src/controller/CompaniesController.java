package controller;

import model.dao.CompaniesDao;
import model.dao.CompaniesDaoImpl;
import model.dao.DevelopersDao;
import model.dao.DevelopersDaoImpl;
import view.ConsoleHelper;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Sergiy on 1/22/17.
 */
public class CompaniesController implements GeneralController{
    public void execute() throws IOException, ClassNotFoundException, SQLException {

        CompaniesDao companiesDao = new CompaniesDaoImpl();
        int controlValue;
        int id;
        String name;

        ConsoleHelper.writeMessage("----------------------COMPANIES CONSOLE---------------------" + "\n" +
                "1 - CREATE | 2 - DELETE | 3 - UPDATE | 4 - SHOW ALL COMPANIES | 5 - FIND BY NAME\\n");

        controlValue = ConsoleHelper.readInt();

        if (controlValue == 1) {
            ConsoleHelper.writeMessage("INPUT COMPANY NAME TO CREATE");
            name = ConsoleHelper.readString();
            companiesDao.create(name);
        } else if (controlValue == 2) {
            ConsoleHelper.writeMessage("INPUT ID TO DELETE COMPANY");
            id = ConsoleHelper.readInt();
            companiesDao.delete(id);
        } else if (controlValue == 3) {
            ConsoleHelper.writeMessage("INPUT COMPANY NAME TO UPDATE");
            name = ConsoleHelper.readString();
            companiesDao.update(name);
        } else if (controlValue == 4) {
            companiesDao.getAll();
        } else if (controlValue == 5) {
            ConsoleHelper.writeMessage("INPUT COMPANY NAME TO FIND");
            name = ConsoleHelper.readString();
            companiesDao.findByName(name);
        } else System.out.println("You have not entered correct value. Please, input 1, 2, 3, 4 or 5.");
    }
}
