package home.example.petProject.service;

import home.example.petProject.entities.Campaign;
import home.example.petProject.repo.CampaignRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CampaignService {

    @Autowired
    private CampaignRepo campaignRepo;

    public List<Campaign> getCampaignsList() {
        return campaignRepo.findAll();
    }

    public Campaign getCampaign(long id) {
        return campaignRepo.findById(id).get();
    }

    public void deleteCampaign(Long id) {
        campaignRepo.deleteById(id);
    }

    public void saveCampaign(Campaign campaign){
        campaignRepo.save(campaign);
    }
}
