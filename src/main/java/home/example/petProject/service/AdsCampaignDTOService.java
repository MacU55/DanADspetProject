package home.example.petProject.service;

import java.util.List;
import home.example.petProject.DTOSimple.AdsCampaignDTO;
import home.example.petProject.entities.Ads;
import home.example.petProject.entities.Campaign;
import home.example.petProject.repo.AdsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AdsCampaignDTOService {

    @Autowired
    private AdsRepo adsRepo;

    public List <AdsCampaignDTO> getAdsCampaignDTOList(){
        return adsRepo.
                findAll().
                stream().
                map(this::convertDataToDTO).
                collect(Collectors.toList());
    }

    private AdsCampaignDTO convertDataToDTO (Ads ads){

        AdsCampaignDTO adsCampaignDTO = new AdsCampaignDTO();

        adsCampaignDTO.setAdsName(ads.getName());
        adsCampaignDTO.setAdsMessage(ads.getMessage());
        Campaign campaign = ads.getCampaign();
        adsCampaignDTO.setCampaignId(campaign.getId());
        adsCampaignDTO.setCampaignName(campaign.getName());
        adsCampaignDTO.setCampaignEmployees(campaign.getEmployees());
        return adsCampaignDTO;
    }
}
