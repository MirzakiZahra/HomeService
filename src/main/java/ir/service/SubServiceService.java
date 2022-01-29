package ir.service;

import ir.data.repository.ServiceRepository;
import ir.data.repository.SubServiceRepository;
import ir.data.dto.SubServiceDto;
import ir.exception.InputException;
import ir.data.model.services.MainService;
import ir.data.model.services.SubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ir.service.mapper.SubServiceMapper;

import java.util.ArrayList;
import java.util.List;
@Service
public class SubServiceService {
    private SubServiceRepository subServiceRepository;
    @Autowired
    public SubServiceService(SubServiceRepository subServiceRepository) {
        this.subServiceRepository = subServiceRepository;
    }
    SubServiceMapper subServiceMapper=new SubServiceMapper();
    @Autowired
    MainServiceService mainServiceService;

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
        subServiceRepository.save(subService);
    }
    public void deleteSubService(String name) {
        SubService subService= subServiceRepository.findByName(name);
        subServiceRepository.delete(subService);
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
        subServiceRepository.delete(subService);
    }

}
