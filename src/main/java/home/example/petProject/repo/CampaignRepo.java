package home.example.petProject.repo;

import home.example.petProject.entities.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepo extends JpaRepository<Campaign, Long> {

}
