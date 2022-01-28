package ir.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ir.data.model.Offer;
import ir.data.model.services.SubService;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpertDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String username;
    private float score;
    private List<SubService> subServiceList = new ArrayList<>();
    private List<Offer> offerList = new ArrayList<>();
    private float creditExpert;
    private int countOfOrder = 0;
}
