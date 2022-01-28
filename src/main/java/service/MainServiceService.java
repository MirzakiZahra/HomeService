package service;

import data.repository.ServiceRepository;
import data.dto.MainServiceDto;
import exception.InputException;
import data.model.services.MainService;
import service.mapper.MainServiceMapper;

import java.util.List;

public class MainServiceService {
    ServiceRepository serviceRepository ;
    MainServiceMapper mainServiceMapper = new MainServiceMapper();

    public void createMainService(String name) {
        MainService mainService = new MainService(name);
        serviceRepository.addMainService(mainService);
    }

    public void deleteMainService(String name) {
        List<MainService> mainServiceList = serviceRepository.findMainServiceByName(name);
        if (mainServiceList.size()==0){
            throw new InputException("Main Service Does Not Exit");
        }
        serviceRepository.delete(mainServiceList.get(0));
    }
    public void updateMainService(MainService mainService){
        serviceRepository.save(mainService);
    }

    public MainServiceDto findMainServiceByName(String name) {
        List<MainService> mainService = serviceRepository.findMainServiceByName(name);
        if (mainService.size() != 0) {
            throw new InputException("MainService Exist");
        }
        return mainServiceMapper.convertMainServiceToMainServiceDto(mainService.get(0));
    }

    public List<MainService> findMainService(String name) {
        if (serviceRepository.findMainServiceByName(name).size()==0){
            throw new InputException("MainService DoesNot Exist");
        }
        return serviceRepository.findMainServiceByName(name);
    }
    public boolean checkExistOfMainService(String name){
        List<MainService> mainServiceList = serviceRepository.findMainServiceByName(name);
        if (mainServiceList.size()!=0){
            return true;
        }
        return false;
    }
}
