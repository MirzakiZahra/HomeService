package service.mapper;

import dto.MainServiceDto;
import model.services.MainService;

public class MainServiceMapper {
    public MainServiceDto convertMainServiceToMainServiceDto(MainService mainService){
        MainServiceDto mainServiceDto = MainServiceDto.builder()
                .name(mainService.getName())
                .subServiceSet(mainService.getSubServiceSet())
                .build();
        return mainServiceDto;
    }
}
