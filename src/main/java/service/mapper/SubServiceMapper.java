package service.mapper;

import data.dto.SubServiceDto;
import data.model.services.SubService;

public class SubServiceMapper {
    public SubServiceDto convertSubServiceToSubServiceDto(SubService subService){
        SubServiceDto subServiceDto = SubServiceDto.builder()
                .name(subService.getName())
                .price(subService.getPrice())
                .description(subService.getDescription())
                .build();
        return subServiceDto;
    }
}
