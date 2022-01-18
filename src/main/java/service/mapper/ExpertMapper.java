package service.mapper;

import dto.ExpertDto;
import model.user.Expert;

public class ExpertMapper {
    public ExpertDto convertExpertToExpertDto(Expert expert){
        ExpertDto expertDto = ExpertDto.builder()
                .id(expert.getId())
                .username(expert.getUsername())
                .firstName(expert.getFirstName())
                .lastName(expert.getLastName())
                .subServiceList(expert.getSubServiceList())
                .score(expert.getScore())
                .offerList(expert.getOfferList())
                .build();
        return expertDto;
    }
}
