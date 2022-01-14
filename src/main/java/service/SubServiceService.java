package service;

import dao.SubServiceDb;
import dto.SubServiceDto;
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
}
