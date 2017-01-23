package controller;

import model.dao.CustomersDao;
import model.dao.CustomersDaoImpl;
import model.dao.SkillsDao;
import model.dao.SkillsDaoImpl;
import view.ConsoleHelper;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Sergiy on 1/22/17.
 */
public class CustomersController implements GeneralController{
    public void execute() throws IOException, ClassNotFoundException, SQLException {

        CustomersDao customersDao = new CustomersDaoImpl();
        int controlValue;
        int id;
        String name;

        ConsoleHelper.writeMessage("----------------------CUSTOMERS CONSOLE---------------------" + "\n" +
                "1 - CREATE | 2 - DELETE | 3 - UPDATE | 4 - SHOW ALL CUSTOMERS | 5 - FIND BY NAME\\n");

        controlValue = ConsoleHelper.readInt();

        if (controlValue == 1) {
            ConsoleHelper.writeMessage("INPUT CUSTOMER NAME TO CREATE");
            name = ConsoleHelper.readString();
            customersDao.create(name);
        } else if (controlValue == 2) {
            ConsoleHelper.writeMessage("INPUT ID TO DELETE CUSTOMER");
            id = ConsoleHelper.readInt();
            customersDao.delete(id);
        } else if (controlValue == 3) {
            ConsoleHelper.writeMessage("INPUT CUSTOMER NAME TO UPDATE");
            name = ConsoleHelper.readString();
            customersDao.update(name);
        } else if (controlValue == 4) {
            customersDao.getAll();
        } else if (controlValue == 5) {
            ConsoleHelper.writeMessage("INPUT CUSTOMER NAME TO FIND");
            name = ConsoleHelper.readString();
            customersDao.findByName(name);
        } else System.out.println("You have not entered correct value. Please, input 1, 2, 3, 4 or 5.");
    }
}
