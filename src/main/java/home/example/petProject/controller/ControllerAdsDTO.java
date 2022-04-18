package home.example.petProject.controller;

import home.example.petProject.mapstruct.dtos.AdsDTO;
import home.example.petProject.mapstruct.mappers.MapperStruct;
import home.example.petProject.repo.AdsRepo;
import home.example.petProject.service.AdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/adsdto")
public class ControllerAdsDTO {

    private MapperStruct mapperStruct;
    private AdsService adsService;


    @Autowired
    public ControllerAdsDTO(MapperStruct mapperStruct,
                            AdsService adsService,
                            AdsRepo adsRepo) {
        this.mapperStruct = mapperStruct;
        this.adsService = adsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdsDTO> getAdsDTOById( @PathVariable("id") Long id) {
        return new ResponseEntity<>(mapperStruct.adsToAdsDTO(adsService.getAds(id)), HttpStatus.OK);
    }

    @GetMapping("/allAds")
    public ResponseEntity <List<AdsDTO>> getListAdsDTO(){
        return new ResponseEntity<>(mapperStruct.adsToAdsDTOList(adsService.getAdsList()                ),
                HttpStatus.OK
        );
    }



}
