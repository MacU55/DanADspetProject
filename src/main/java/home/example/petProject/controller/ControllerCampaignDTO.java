package home.example.petProject.controller;

import home.example.petProject.entities.Campaign;
import home.example.petProject.mapstruct.dtos.CampaignFullDTO;
import home.example.petProject.mapstruct.dtos.CampaignSlimDTO;
import home.example.petProject.mapstruct.mappers.MapperStruct;
import home.example.petProject.repo.CampaignRepo;
import home.example.petProject.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/campaigndto")
public class ControllerCampaignDTO {

    private MapperStruct mapperStruct;
    private CampaignService campaignService;

    @Autowired
    public ControllerCampaignDTO(
            MapperStruct mapperStruct,
            CampaignService campaignService
    ) {
        this.mapperStruct = mapperStruct;
        this.campaignService = campaignService;
    }

    @GetMapping("/idFull/{id}")
    public ResponseEntity<CampaignFullDTO> getCampaignFullDTOById(
            @PathVariable("id") Long id) {
        return new ResponseEntity<>(mapperStruct.
                campaignToCampaignFullDTO(campaignService.getCampaign(id)), HttpStatus.OK);
    }

    @GetMapping("/idSlim/{id}")
    public ResponseEntity<CampaignSlimDTO> getCampaignSlimDTOById(
            @PathVariable("id") Long id ){
        return new ResponseEntity<>(mapperStruct.campaignToCampaignSlimDTO(
                campaignService.getCampaign(id)), HttpStatus.OK);
    }

    @GetMapping("/campaignFullList")
    public ResponseEntity<List<CampaignFullDTO>> getListCampaignFullDTO(){
        return new ResponseEntity<>(mapperStruct.
                campaignsToCampaignsFullDTOs(campaignService.getCampaignsList()), HttpStatus.OK);
    }

    @GetMapping("/campaignSlimList")
    public ResponseEntity<List<CampaignSlimDTO>> getListCampaignSlimDTO(){
        return new ResponseEntity<>(mapperStruct.
                campaignsToCampaignsSlimDTOs(campaignService.getCampaignsList()), HttpStatus.OK);
    }


}
