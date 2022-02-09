package ir.service.mapper;

import ir.data.dto.SubServiceDto;
import ir.data.model.services.SubService;
import org.springframework.stereotype.Component;

@Component
public class SubServiceMapper {
    public SubServiceDto convertSubServiceToSubServiceDto(SubService subService) {
        SubServiceDto subServiceDto = SubServiceDto.builder()
                .name(subService.getName())
                .price(subService.getBasePrice())
                .description(subService.getDescription())
                .build();
        return subServiceDto;
    }
}
