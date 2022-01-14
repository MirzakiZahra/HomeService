package service;

import dao.SubServiceDb;
import dto.SubServiceDto;
import exception.InputException;
import model.services.SubService;

import java.util.ArrayList;
import java.util.List;

public class SubServiceService {
    SubServiceDb subServiceDb = new SubServiceDb();
    public List<SubServiceDto> showAllSubService(){
        List<SubService> subServiceList = subServiceDb.getAllSubService();
        List<SubServiceDto> subServiceDtoList = new ArrayList<>();
        for (SubService subService : subServiceList){
            SubServiceDto subServiceDto = new SubServiceDto(subService.getId(),
                    subService.getName(),subService.getDescription(),subService.getPrice());
            subServiceDtoList.add(subServiceDto);
        }
        return subServiceDtoList;
    }
    public boolean checkExistOfSubServiceById(int id){
        if (subServiceDb.checkExistOfSubServiceById(id) == 0){
            throw new InputException("Wrong ID");
        }
        return true;
    }
}
