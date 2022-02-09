package ir.service.mapper;

import ir.data.dto.ExpertDto;
import ir.data.model.user.Expert;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ExpertMapper {
    public ExpertDto convertExpertToExpertDto(Expert expert) {
        ExpertDto expertDto = ExpertDto.builder()
                .id(expert.getId())
                .email(expert.getEmail())
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
                    .email(expertDto.getEmail())
                    .creditExpert(expertDto.getCreditExpert())
                    .subServiceList(expertDto.getSubServiceList())
                    .build();
            expertList.add(expert);
        }
        return expertList;
    }
}
