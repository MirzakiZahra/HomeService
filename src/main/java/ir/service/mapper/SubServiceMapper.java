package ir.service.mapper;

import ir.data.dto.SubServiceDto;
import ir.data.model.services.SubService;

public class SubServiceMapper {
    public SubServiceDto convertSubServiceToSubServiceDto(SubService subService) {
        SubServiceDto subServiceDto = SubServiceDto.builder()
                .name(subService.getName())
                .price(subService.getPrice())
                .description(subService.getDescription())
                .build();
        return subServiceDto;
    }
}
