package service;

import data.repository.SubServiceRepository;
import data.dto.SubServiceDto;
import exception.InputException;
import data.model.services.MainService;
import data.model.services.SubService;
import service.mapper.SubServiceMapper;

import java.util.ArrayList;
import java.util.List;

public class SubServiceService {
    SubServiceRepository subServiceRepository = new SubServiceRepository();
    SubServiceMapper subServiceMapper=new SubServiceMapper();
    MainServiceService mainServiceService = new MainServiceService();

    public List<SubServiceDto> showAllSubService() {
        List<SubService> subServiceList = subServiceRepository.findAllSubService();
        List<SubServiceDto> subServiceDtoList = new ArrayList<>();
        for (SubService subService : subServiceList) {
            SubServiceDto subServiceDto = new SubServiceDto(subService.getId(),
                    subService.getName(), subService.getDescription(), subService.getPrice());
            subServiceDtoList.add(subServiceDto);
        }
        return subServiceDtoList;
    }

    public SubService checkExistOfSubServiceById(int id) {
        if (subServiceRepository.findById(id).equals(null)) {
            throw new InputException("Wrong ID");
        }
        return subServiceRepository.findById(id);
    }

    public void createSubService(String name, String description,
                                 float price, String mainServiceName) {
        List<MainService> mainServices = mainServiceService.findMainService(mainServiceName);
        SubService subService = new SubService(name, description, price, mainServices.get(0));
        mainServices.get(0).getSubServiceSet().add(subService);
        mainServiceService.updateMainService(mainServices.get(0));
        subServiceRepository.addSubService(subService);
    }
    public void deleteSubService(String name) {
        SubService subService= subServiceRepository.findByName(name);
        subServiceRepository.deleteSubService(subService);
    }
    public SubServiceDto findSubServiceByName(String name) {
        List<SubService>subServices= subServiceRepository.findAllByName(name);
        if (subServices.size() == 0) {
            throw new InputException("SubService DosesNot Exist");
        }
        return subServiceMapper.convertSubServiceToSubServiceDto(subServices.get(0));
    }
    public void deleteSubServiceByName(String name) {
        SubService subService= subServiceRepository.findByName(name);
        MainService mainService = subService.getMainService();
        mainService.getSubServiceSet().remove(subService);
        mainServiceService.updateMainService(mainService);
        subServiceRepository.deleteSubService(subService);
    }

}
