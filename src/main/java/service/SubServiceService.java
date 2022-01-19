package service;

import dao.SubServiceDb;
import dto.SubServiceDto;
import exception.InputException;
import model.services.MainService;
import model.services.SubService;

import java.util.ArrayList;
import java.util.List;

public class SubServiceService {
    SubServiceDb subServiceDb = new SubServiceDb();

    public List<SubServiceDto> showAllSubService() {
        List<SubService> subServiceList = subServiceDb.getAllSubService();
        List<SubServiceDto> subServiceDtoList = new ArrayList<>();
        for (SubService subService : subServiceList) {
            SubServiceDto subServiceDto = new SubServiceDto(subService.getId(),
                    subService.getName(), subService.getDescription(), subService.getPrice());
            subServiceDtoList.add(subServiceDto);
        }
        return subServiceDtoList;
    }

    public SubService checkExistOfSubServiceById(int id) {
        if (subServiceDb.checkExistOfSubServiceById(id).equals(null)) {
            throw new InputException("Wrong ID");
        }
        return checkExistOfSubServiceById(id);
    }
    public void createSubService(String name,String description,
                                 float price, MainService mainService) {
        SubService subService=new SubService(name,description,price,mainService);
        subServiceDb.a
        MainService mainService = new MainService(name);
        serviceDb.addMainService(mainService);

    }
    public void deleteMainService(String name) {
        MainService mainService=serviceDb.findServiceByName(name);
        serviceDb.deleteMainService(mainService);


    }
}
