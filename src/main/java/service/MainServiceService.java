package service;

import dao.ServiceDb;
import dto.MainServiceDto;
import exception.InputException;
import model.services.MainService;
import service.mapper.MainServiceMapper;

import java.util.List;

public class MainServiceService {
    ServiceDb serviceDb = new ServiceDb();
    MainServiceMapper mainServiceMapper = new MainServiceMapper();

    public void createMainService(String name) {
        MainService mainService = new MainService(name);
        serviceDb.addMainService(mainService);
    }

    public void deleteMainService(String name) {
        MainService mainService = serviceDb.findServiceByName(name).get(0);
        serviceDb.deleteMainService(mainService);
    }

    public MainServiceDto findMainServiceByName(String name) {
        List<MainService> mainService = serviceDb.findServiceByName(name);
        if (mainService.size() != 0) {
            throw new InputException("MainService Exist");
        }
        return mainServiceMapper.convertMainServiceToMainServiceDto(mainService.get(0));
    }

    public List<MainService> findMainService(String name) {
        return serviceDb.findServiceByName(name);
    }
    public boolean checkExistOfMainService(String name){
        List<MainService> mainServiceList = serviceDb.findServiceByName(name);
        if (mainServiceList.size()!=0){
            return false;
        }
        return true;
    }
}
