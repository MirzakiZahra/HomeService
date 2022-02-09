package ir.service.mapper;

import ir.data.dto.MainServiceDto;
import ir.data.model.services.MainService;
import org.springframework.stereotype.Component;

@Component
public class MainServiceMapper {
    public MainServiceDto convertMainServiceToMainServiceDto(MainService mainService) {
        MainServiceDto mainServiceDto = MainServiceDto.builder()
                .name(mainService.getName())
                .subServiceSet(mainService.getSubServiceSet())
                .build();
        return mainServiceDto;
    }
}
