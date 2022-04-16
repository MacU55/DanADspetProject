package home.example.petProject.service;

import home.example.petProject.entities.Ads;
import home.example.petProject.entities.Campaign;
import home.example.petProject.repo.AdsRepo;
import home.example.petProject.repo.CampaignRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AdsService {

    @Autowired
    private AdsRepo adsRepo;

    @Autowired
    private CampaignRepo campaignRepo;

    public List<Ads> getAdsList() {
        return adsRepo.findAll();
    }

    public Ads getAds(Long id) {
        return adsRepo.findById(id).get();
    }

    public void delAds(Long id) {
        adsRepo.deleteById(id);
    }

    public void saveAds(Ads ads) {
        adsRepo.save(ads);
    }

    public List<Long> getCampaignsIdList() {
        List<Campaign> campaignsList = campaignRepo.findAll();
        List<Long> campaignsIdList = new ArrayList<>();
        for (Campaign campaign : campaignsList) {
            Long id = campaign.getId();
            campaignsIdList.add(id);
        }
        return campaignsIdList;
    }
}
