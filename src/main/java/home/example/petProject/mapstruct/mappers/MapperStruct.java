package home.example.petProject.mapstruct.mappers;

import home.example.petProject.mapstruct.dtos.AdsDTO;
import home.example.petProject.mapstruct.dtos.CampaignFullDTO;
import home.example.petProject.mapstruct.dtos.CampaignSlimDTO;
import home.example.petProject.entities.Ads;
import home.example.petProject.entities.Campaign;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper( componentModel = "spring")
public interface MapperStruct {

    AdsDTO adsToAdsDTO(Ads ads);
    CampaignFullDTO campaignToCampaignFullDTO(Campaign campaign);
    CampaignSlimDTO campaignToCampaignSlimDTO(Campaign campaign);

    List<CampaignFullDTO> campaignsToCampaignsFullDTOs(
            List<Campaign> campaigns
    );

    List<CampaignSlimDTO> campaignsToCampaignsSlimDTOs(
            List<Campaign> campaigns
    );

    List<AdsDTO> adsToAdsDTOList(
            List<Ads> ads
    );



}
