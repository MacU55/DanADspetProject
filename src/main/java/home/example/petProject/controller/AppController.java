package home.example.petProject.controller;

import home.example.petProject.DTOSimple.AdsCampaignDTO;
import home.example.petProject.entities.Ads;
import home.example.petProject.entities.Campaign;
import home.example.petProject.service.AdsCampaignDTOService;
import home.example.petProject.service.AdsService;
import home.example.petProject.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RequestMapping("/")
public class AppController {

    @Autowired
    private CampaignService campaignService;

    @Autowired
    private AdsService adsService;

    @Autowired
    private AdsCampaignDTOService adsCampaignDTOService;

    @GetMapping ("/")
    public String viewAllCampaigns(Model model) {
        List<Campaign> campaignList = campaignService.getCampaignsList();
        model.addAttribute("campaignList", campaignList);
        return "index";
    }

    @RequestMapping("/showAdsList")
    public String viewAllAds(Model model) {
        List<Ads> adsList = adsService.getAdsList();
        model.addAttribute("adsList", adsList);
        return "ads";
    }


    @RequestMapping("/editCampaign/{id}")
    public ModelAndView editCampaign(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("editCampaign");
        Campaign campaign = campaignService.getCampaign(id);
        mav.addObject("campaign", campaign);
        return mav;
    }

    @RequestMapping("/editAds/{id}")
    public ModelAndView editAds(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("editAds");
        Ads ads = adsService.getAds(id);
        List<Long> campaignIdList = adsService.getCampaignsIdList();
        mav.addObject("ads", ads);
        mav.addObject("campaignsIdList", campaignIdList);
        return mav;
    }

    @RequestMapping("/deleteCampaign/{id}")
    public String deleteCampaign(@PathVariable(name = "id") long id) {
        campaignService.deleteCampaign(id);
        return "redirect:/";
    }

    @RequestMapping("/deleteAds/{id}")
    public String deleteAds(@PathVariable(name = "id") long id) {
        adsService.delAds(id);
        return "redirect:/";
    }

    @RequestMapping("/newCampaign")
    public String createNewCampaign(Model model) {
        Campaign campaign = new Campaign();
        model.addAttribute("newCampaign", campaign);
        return "newCampaign";
    }

    @RequestMapping("/newAds")
    public String createNewAds(Model model) {
        Ads ads = new Ads();
//        List<Campaign> campaignList = campaignService.getCampaignsList();
        List<Long> campaignsIdList = adsService.getCampaignsIdList();
            model.addAttribute("newAds", ads);
            model.addAttribute("campaignsIdList", campaignsIdList);
            return "newAds";

    }

    @PostMapping(value = "/saveCampaign")
    public String saveCompany(@ModelAttribute("newCampaign") Campaign campaign) {
        campaignService.saveCampaign(campaign);
        return "redirect:/";
    }

    @PostMapping(value = "/saveAds")
    public String saveAds(@ModelAttribute("newAds") Ads ads, Model model) {
        adsService.saveAds(ads);
        List<Ads> adsList = adsService.getAdsList();
        model.addAttribute("adsList", adsList);

        return "ads";
    }

    @GetMapping (value = "/showAdsCampaignDTOList")
    public String getAdsCampaignDTOList(Model model){
        List <AdsCampaignDTO> adsCampaignDTOList = adsCampaignDTOService.
                getAdsCampaignDTOList();
        model.addAttribute("adsCampaignDTOList", adsCampaignDTOList);
        return "adsCampaign";

    }
}
