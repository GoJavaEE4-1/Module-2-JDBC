import controller.*;
import model.dao.ConnectDao;
import view.ConsoleHelper;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Sergiy on 1/22/17.
 */
public class TestRun {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        ConnectDao.ConnectDB();
        GeneralController generalController = null;
        int commandNumber;
        ConsoleHelper.writeMessage("Вас приветствует система CRUD!");

        while (true) {
            ConsoleHelper.writeMessage("\nВыберите раздел: 1 - Разработчики | 2 - Покупатели | 3 - Проекты | 4 - Компании | 5 - Навыки | 6 - Выход из системы");
            commandNumber = ConsoleHelper.readInt();
            switch (commandNumber) {
                case 1:
                    generalController = new DevelopersController();
                    generalController.execute();
                    break;
                case 2:
                    generalController = new CustomersController();
                    generalController.execute();
                    break;
                case 3:
                    generalController = new ProjectsController();
                    generalController.execute();
                    break;
                case 4:
                    generalController = new CompaniesController();
                    generalController.execute();
                    break;
                case 5:
                    generalController = new SkillsController();
                    generalController.execute();
                    break;
                case 6:
                    ConnectDao.closeConnect();
                    return;
                default:
                    break;
            }

        }
    }

}
