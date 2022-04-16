package home.example.petProject.mapstruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import home.example.petProject.entities.Ads;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class CampaignFullDTO {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("employees")
    private int employees;
    @JsonProperty("email")
    private String email;
    @JsonProperty("price")
    private float price;
    @JsonProperty("ads")
    private Set<AdsDTO> ads;
}
