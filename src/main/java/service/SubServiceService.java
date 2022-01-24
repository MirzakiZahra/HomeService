package service;

import dao.SubServiceDb;
import dto.MainServiceDto;
import dto.SubServiceDto;
import exception.InputException;
import model.services.MainService;
import model.services.SubService;
import service.mapper.SubServiceMapper;

import java.util.ArrayList;
import java.util.List;

public class SubServiceService {
    SubServiceDb subServiceDb = new SubServiceDb();
    SubServiceMapper subServiceMapper=new SubServiceMapper();

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

    public void createSubService(String name, String description,
                                 float price, MainService mainService) {
        SubService subService = new SubService(name, description, price, mainService);
        subServiceDb.addSubService(subService);
    }

    public void deleteSubService(String name) {
        SubService subService=subServiceDb.findSubServiceByName(name);
        subServiceDb.deleteSubService(subService);
    }
    public SubServiceDto findSubServiceByName(String name) {
        List<SubService>subServices=subServiceDb.findSubServiceByNameReturnList(name);
        if (subServices.size() != 0) {
            throw new InputException("MainService Exist");
        }
        return subServiceMapper.convertSubServiceToSubServiceDto(subServices.get(0));
    }
}
