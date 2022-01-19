package service;

import dao.ServiceDb;
import model.services.MainService;
import model.user.Expert;

public class MainServiceService {
    ServiceDb serviceDb = new ServiceDb();

    public void createMainService(String name) {
        MainService mainService = new MainService(name);
        serviceDb.addMainService(mainService);

    }
    public void deleteMainService(String name) {
        MainService mainService=serviceDb.findServiceByName(name);
        serviceDb.deleteMainService(mainService);


    }
}
