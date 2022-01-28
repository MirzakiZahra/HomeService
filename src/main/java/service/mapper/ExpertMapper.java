package service.mapper;

import data.dto.ExpertDto;
import data.model.user.Expert;

import java.util.ArrayList;
import java.util.List;

public class ExpertMapper {
    public ExpertDto convertExpertToExpertDto(Expert expert) {
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

    public List<Expert> convertExpertDtoToExpert(List<ExpertDto> expertDtoList) {
        List<Expert> expertList = new ArrayList<>();
        for (ExpertDto expertDto : expertDtoList) {
            Expert expert = Expert.builder()
                    .score(expertDto.getScore())
                    .creditExpert(expertDto.getCreditExpert())
                    .subServiceList(expertDto.getSubServiceList())
                    .build();
            expertList.add(expert);
        }
        return expertList;
    }
}
