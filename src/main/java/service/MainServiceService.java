package service;

import dao.ServiceDb;
import model.services.MainService;

public class MainServiceService {
    ServiceDb serviceDb = new ServiceDb();

    public void createMainService(String name) {
        MainService mainService = new MainService(name);
        serviceDb.addMainService(mainService);

    }
}
