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
//    Ads convertAdsDTOToAds (AdsDTO adsDTO);
    CampaignFullDTO campaignToCampaignFullDTO(Campaign campaign);
//    Campaign convertCampaignFullDTOCampaign (CampaignFullDTO campaignFullDTO);
    CampaignSlimDTO campaignToCampaignSlimDTO(Campaign campaign);
//    Campaign convertCampaignSlimDTOToCampaign (CampaignSlimDTO campaignSlimDTO);

   //



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
