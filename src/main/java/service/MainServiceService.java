package service;

import dao.ServiceDb;
import dto.MainServiceDto;
import model.services.MainService;
import service.mapper.MainServiceMapper;

public class MainServiceService {
    ServiceDb serviceDb = new ServiceDb();
    MainServiceMapper mainServiceMapper = new MainServiceMapper();
    public void createMainService(String name) {
        MainService mainService = new MainService(name);
        serviceDb.addMainService(mainService);

    }
    public void deleteMainService(String name) {
        MainService mainService=serviceDb.findServiceByName(name);
        serviceDb.deleteMainService(mainService);
    }
    public MainServiceDto findMainServiceByName(String name){
        MainService mainService = serviceDb.findServiceByName(name);
        return mainServiceMapper.convertMainServiceToMainServiceDto(mainService);
    }
}
