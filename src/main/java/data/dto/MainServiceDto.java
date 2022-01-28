package data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import data.model.services.SubService;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MainServiceDto {
    private int id;
    private String name;
    private Set<SubService> subServiceSet = new HashSet<>();
}
