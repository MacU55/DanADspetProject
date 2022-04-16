package home.example.petProject.repo;

import home.example.petProject.entities.Ads;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdsRepo extends JpaRepository<Ads, Long> {
}
